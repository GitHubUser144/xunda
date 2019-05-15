package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Orderstatus;
import com.service.OrderstatusService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 订单状态管理的控制器
 */
@Controller
public class OrderstatusController {

    @Autowired
    private OrderstatusService orderstatusService;

    @RequestMapping("/orderstatusDelete")
    public String orderstatusDelete(Integer orderid,Integer pn){
        orderstatusService.delete(orderid);
        return "redirect:getOrderstatus?pn="+pn;
    }

    /**
     * 修改订单状态
     * @param pn
     * @param orderstatus
     * @return
     */
    @RequestMapping("/orderstatusUpdate")
    public String orderstatusUpdate(Integer pn,Orderstatus orderstatus){
        orderstatusService.update(orderstatus);
        return "redirect:getOrderstatus?pn="+pn;
    }

    /**
     * 进入订单状态修改页面
     * @param orderid
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/orderstatusUpdatePage")
    public String orderstatusUpdatePage(Integer orderid,Integer pn,Model model){
        Orderstatus orderstatus = orderstatusService.getOrderStatusById(orderid);
        model.addAttribute("orders",orderstatus);
        model.addAttribute("pn",pn);
        return "orderstsUpdate";
    }

    /**
     * 添加订单状态
     * @param orderstatus
     * @return
     */
    @RequestMapping("/orderstatusAdd")
    public String orderstatusAdd(Orderstatus orderstatus){
        orderstatusService.save(orderstatus);
        long count = orderstatusService.getCount();
        return "redirect:getOrderstatus?pn="+count;
    }

    /**
     * 进去订单状态管理添加页面
     * @return
     */
    @RequestMapping("/orderstatusAddpage")
    public String orderstatusAddpage(){
        return "orderstsAdd";
    }

    /**
     * 查询订单状态且分页
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/getOrderstatus")
    public String getOrderstatus(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Orderstatus> orderstatusList = orderstatusService.getAll();
        PageInfo pageInfo = new PageInfo(orderstatusList);
        model.addAttribute("pages",pageInfo);
        return "orderstslist";
    }
}
