package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Sendtype;
import com.service.SendtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 运输工具的控制器
 */
@Controller
public class SendTypeController {

    @Autowired
    private SendtypeService sendtypeService;

    /**
     *  删除运输工具
     * @return
     */
    @RequestMapping("sendTypeDelete")
    public String sendTypeDelete(Integer sendtypeid,Integer pn){
        sendtypeService.deleteSendType(sendtypeid);
        return "redirect:getSendType?pn="+pn;
    }

    /**
     * 更新运输工具
     * @param pn
     * @param sendtype
     * @return
     */
    @RequestMapping("/sendTypeUpdate")
    public String sendTypeUpdate(Integer pn,Sendtype sendtype){
        sendtypeService.update(sendtype);
        return "redirect:getSendType?pn="+pn;
    }

    /**
     * 进入运输工具修改页面
     * @param sendtypeid
     * @return
     */
    @RequestMapping("/sendTypeUpdatePage")
    public String sendTypeUpdatePage(Integer sendtypeid,Integer pn,Model model){
        Sendtype sendtype = sendtypeService.getSendTypeById(sendtypeid);
        model.addAttribute("send",sendtype);
        model.addAttribute("pn",pn);
        return "sendTypeUpdate";
    }

    /**
     * 添加运输工具
     * @param sendtype
     * @return
     */
    @RequestMapping("/sendTypeAdd")
    public String sendTypeAdd(Sendtype sendtype){
        sendtypeService.save(sendtype);
        long count = sendtypeService.getCount();
        return "redirect:getSendType?pn="+count;
    }

    /**
     * 进入运输工具添加页面
     * @return
     */
    @RequestMapping("/sendTypeAddPage")
    public String sendTypeAddPage(){
        return "sendTypeAdd";
    }

    /**
     * 显示运输工具的分类 且进行分页显示
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/getSendType")
    public String getSendType(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Sendtype> sendtypeList = sendtypeService.getAll();
        PageInfo pageInfo = new PageInfo(sendtypeList);
        model.addAttribute("send",sendtypeList);
        model.addAttribute("pages",pageInfo);
        return "sendTypelist";
    }
}
