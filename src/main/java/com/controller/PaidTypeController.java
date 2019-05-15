package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Paidtype;
import com.service.PaidtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 付款方式的控制器
 */
@Controller
public class PaidTypeController {

    @Autowired
    private PaidtypeService paidtypeService;

    /**
     * 删除付款方式
     * @param paidid
     * @param pn
     * @return
     */
    @RequestMapping("/paidTypeDelete")
    public String paidTypeDelete(Integer paidid,Integer pn){
        paidtypeService.delete(paidid);
        return "redirect:getPaidType?pn="+pn;
    }

    /**
     * 执行修改操作
     * @param pn
     * @param paidtype
     * @return
     */
    @RequestMapping("/paidTypeUpdate")
    public String paidTypeUpdate(Integer pn,Paidtype paidtype){
        paidtypeService.update(paidtype);
        return "redirect:getPaidType?pn="+pn;
    }

    /**
     * 进入付款方式修改页面
     * @param paidid
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/paidTypeUpdatePage")
    public String paidTypeUpdatePage(Integer paidid,Integer pn,Model model){
        Paidtype paidtype = paidtypeService.getPaidTypeById(paidid);
        model.addAttribute("paid",paidtype);
        model.addAttribute("pn",pn);
        return "paidTypeUpdate";
    }

    /**
     * 添加付款方式
     */
    @RequestMapping("/addPaidtype")
    public String addPaidtype(Paidtype paidtype){
        paidtypeService.save(paidtype);
        long count = paidtypeService.getCount();
        return "redirect:getPaidType?pn="+count;
    }
    /**
     * 进入付款方式添加页面
     * @return
     */
    @RequestMapping("/addPaidtypePage")
    public String addPaidtypePage(){
        return "paidTypeAdd";
    }

    /**
     * 获取所有的付款方式且分页
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/getPaidType")
    public String getPaidType(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Paidtype> paidtypeList = paidtypeService.getAll();
        PageInfo pageInfo = new PageInfo(paidtypeList);
        model.addAttribute("pages",pageInfo);
        return "paidTypelist";
    }
}
