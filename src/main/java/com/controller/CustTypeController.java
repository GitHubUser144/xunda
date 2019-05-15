package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Customertype;
import com.service.CusttypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 客户类型的控制器
 */
@Controller
public class CustTypeController {

    @Autowired
    private CusttypeService custtypeService;

    /**
     * 删除客户类型
     * @param pn
     * @param customertypeid
     * @return
     */
    @RequestMapping("/custTypeDelete")
    public String custTypeDelete(Integer pn,Integer customertypeid){
        custtypeService.delete(customertypeid);
        return "redirect:getCustType?pn="+pn;
    }

    /**
     * 更新客户类型
     * @param pn
     * @param customertype
     * @return
     */
    @RequestMapping("/custTypeUpdate")
    public String custTypeUpdate(Integer pn,Customertype customertype){
        custtypeService.update(customertype);
        return "redirect:getCustType?pn="+pn;
    }

    /**
     * 进入修改页面且回显数据
     * @param customertypeid
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/custTypeUpdatePage")
    public String custTypeUpdatePage(Integer customertypeid,Integer pn,Model model){
        Customertype customertype = custtypeService.getCustTypeById(customertypeid);
        model.addAttribute("custType",customertype);
        model.addAttribute("pn",pn);
        return "custTypeUpdate";
    }

    /**
     * 添加用户类型操作
     * @param customertype
     * @return
     */
    @RequestMapping("/custTypeAdd")
    public String custTypeAdd(Customertype customertype){
        custtypeService.save(customertype);
        long count = custtypeService.getCount();
        return "redirect:getCustType?pn="+count;
    }

    /**
     * 进入添加页面
     * @return
     */
    @RequestMapping("/custTypeAddPage")
    public String custTypeAddPage(){
        return "custTypeAdd";
    }

    /**
     * 获取客户类型且进分页
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/getCustType")
    public String getCustType(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Customertype> customertypeList = custtypeService.getAll();
        PageInfo pageInfo = new PageInfo(customertypeList);
        model.addAttribute("pages",pageInfo);
        return "custtypelist";
    }
}
