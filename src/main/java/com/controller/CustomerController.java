package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.*;
import com.service.AreaService;
import com.service.CustomerService;
import com.service.CustomertypeService;
import com.service.PaidtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *  客户的控制器
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomertypeService customertypeService;

    @Autowired
    private PaidtypeService paidtypeService;

    @Autowired
    private AreaService areaService;

    /**
     * 根据条件查询
     * @param customername
     * @param customertypeid
     * @param model
     * @return
     */
    @RequestMapping("/getCustomerRepByQuery")
    public String getCustomerRepByQuery(String customername,Integer customertypeid,Model model){
        List<Customertype> customertypeList = customertypeService.getAll();
        Customer customer = new Customer();
        if(customername!=""){
            customer.setCustomername(customername);
            System.out.println("客户名称"+customername);
        }
        if (customertypeid!=0){
            customer.setCustomertypeid(customertypeid);
            System.out.println("类型id"+customertypeid);
        }
        List<Customer> customerList = customerService.getCustomerByCondition(customer);
        System.out.println("======"+customerList);
        model.addAttribute("custtypes",customertypeList);
        model.addAttribute("customerList",customerList);
        return "customerRep";
    }

    @RequestMapping("/getCustomerRep")
    public String getCustomerRep(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
        List<Customer> customerList = customerService.getAllCustomer();
        List<Customertype> customertypeList = customertypeService.getAll();
        model.addAttribute("customerList",customerList);
        model.addAttribute("custtypes",customertypeList);
        return "customerRep";
    }

    /**
     * 删除客户
     * @param customerid
     * @return
     */
    @RequestMapping("/customerDelete")
    public String customerDelete(Integer customerid){
        customerService.deleteCustomer(customerid);
        long count = customerService.getCount();
        return "redirect:getCustomer?pn="+count;
    }

    /**
     * 执行跟新操作
     * @param customer
     * @param pn
     * @return
     */
    @RequestMapping("/customerUpdate")
    public String customerUpdate(Customer customer,Integer pn){
        customerService.updateCustomer(customer);
        return "redirect:getCustomer?pn="+pn;
    }

    /**
     * 进入更新页面 并回显数据
     * @param customerid
     * @param model
     * @param pn
     * @return
     */
    @RequestMapping("/customerUpdatePage")
    public String customerUpdatePage(Integer customerid,Model model,Integer pn){
        Customer customer = customerService.getCustomer(customerid);
        List<Customertype> customertypeList = customertypeService.getAll();
        List<Paidtype> paidtypeList = paidtypeService.getAll();
        List<Area> areaList = areaService.getAllArea();
        model.addAttribute("cust",customer);
        model.addAttribute("custtypes",customertypeList);
        model.addAttribute("paidtypes",paidtypeList);
        model.addAttribute("areas",areaList);
        model.addAttribute("pn",pn);
        return "customerUpdate";
    }


    /**
     * 执行添加客户操作
     * @param customer
     * @return
     */
    @RequestMapping("/addCustomer")
    public String addCustomer(Customer customer){
        customerService.save(customer);
        long count = customerService.getCount();
        return "redirect:getCustomer?pn="+count;
    }

    /**
     *  进入用户添加的页面
     * @return
     */
    @RequestMapping("/addCustomerPage")
    public String addCustomerPage(Model model){
        List<Customertype> customertypeList = customertypeService.getAll();
        List<Paidtype> paidtypeList = paidtypeService.getAll();
        List<Area> areaList = areaService.getAllArea();
        model.addAttribute("custtypes",customertypeList);
        model.addAttribute("paidtypes",paidtypeList);
        model.addAttribute("areas",areaList);
        return "customerAdd";
    }

    /**
     *  显示用户页面 且进行分页显示
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/getCustomer")
    public String getCustomer(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Customer> customerList = customerService.getAllCustomer();
        PageInfo page = new PageInfo(customerList);
        model.addAttribute("customerList",customerList);
        model.addAttribute("pages",page);
        System.out.println("========="+page);
        return "customerlist";
    }
}
