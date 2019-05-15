package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.*;
import com.service.BalanceService;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * 客户账目往来明细的控制器
 */
@Controller
public class BalanceController {

    @Autowired
    private BalanceService balanceService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/invalidBalance")
    public String invalidBalance(Integer balanceid,Integer pn,Integer customerid){
        BalanceExample balanceExample = new BalanceExample();
        BalanceExample.Criteria criteria = balanceExample.createCriteria();
        criteria.andBalanceidEqualTo(balanceid);
        Balance balance = new Balance();
        balance.setIsvalid("作废");
        balanceService.updateBalanceWithinvalid(balance,balanceExample);
        System.out.println("------------"+customerid);
        return "redirect:balanceDetailPage?pn="+pn+"&customerid="+customerid;
    }


    /**
     * 添加账目
     * @param balance
     * @param session
     * @return
     */
    @RequestMapping("/balanceAdd")
    public String balanceAdd(Balance balance, HttpSession session){
        Users user = (Users) session.getAttribute("user");
        balance.setUserid(user.getId());
        balance.setIsvalid("有效");
        balance.setOprtime(balance.getPaidtime());
        int customerid = balance.getCustomerid();
        balanceService.save(balance);
        long count = balanceService.getCount();
        return "redirect:balanceDetailPage?pn="+count+"&customerid="+customerid;
    }


    /**
     * 进入客户往来统计页面
     * @param model
     * @return
     */
    @RequestMapping("/getBalanceRepTj")
    public String getBalanceRepTj(Model model){
        List<Balance> balanceList = balanceService.getAll();
        System.out.println("========="+balanceList);
        model.addAttribute("bals",balanceList);
        return "BalanceRep2";
    }

    /**
     * 进入客户往来明细
     * @param pn
     * @param balanceQuery
     * @param model
     * @return
     */
    @RequestMapping("/getBalanceRepQuery")
    public String getBalanceRepQuery(@RequestParam(value = "pn",defaultValue = "1") Integer pn,BalanceQuery balanceQuery,Model model){
        System.out.println("============"+balanceQuery);
        PageHelper.startPage(pn,5);
        List<Balance> balanceQueryList = balanceService.getBalanceByQuery(balanceQuery);
        PageInfo pageInfo = new PageInfo(balanceQueryList);
        model.addAttribute("pages",pageInfo);
        model.addAttribute("bals",balanceQueryList);
        System.out.println("==============="+balanceQueryList);
        return "BalanceRep";
    }

    /**
     * 查询所有的账单且分页
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/getBalanceRep")
    public String getBalanceRep(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
        PageHelper.startPage(pn,5);
        List<Balance> balanceList = balanceService.getAll();
        PageInfo pageInfo = new PageInfo(balanceList);
        model.addAttribute("pages",pageInfo);
        model.addAttribute("bals",balanceList);
        System.out.println(balanceList+"-=============");

        return "BalanceRep";
    }

    /**
     * 显示用户账单的详细信息
     * @param pn
     * @param customerid
     * @param model
     * @return
     */
    @RequestMapping("/balanceDetailPage")
    public String balanceDetailPage(@RequestParam(defaultValue = "1", value = "pn") Integer pn, Integer customerid, Model model) {
        PageHelper.startPage(pn, 5);
        List<Balance> balanceList = balanceService.getBalanceById(customerid);
        PageInfo page = new PageInfo(balanceList);
        model.addAttribute("bals",balanceList);
        model.addAttribute("pages",page);
        model.addAttribute("customerid",customerid);
        return "balancelist";
    }

    /**
     * 进入收/付款开单页面
     * @param customerid
     * @return
     */
    @RequestMapping("/balanceAddPage")
    public String balanceAddPage(Integer customerid,Model model){
        Customer customer = customerService.getCustomer(customerid);
        model.addAttribute("cust",customer);
        return "balanceAdd";
    }
}
