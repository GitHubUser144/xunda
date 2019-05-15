package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Area;
import com.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 区域的控制器
 */
@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("/areaDelete")
    public String areaDelete(Integer pn,Integer areaid){
        areaService.delete(areaid);
        return "redirect:getArea?pn="+pn;
    }

    /**
     * 执行更新操作
     * @param pn
     * @param area
     * @return
     */
    @RequestMapping("/areaUpdate")
    public String areaUpdate(Integer pn,Area area){
        areaService.update(area);
        return "redirect:getArea?pn="+pn;
    }

    /**
     * 进入区域更新页面
     * @param model
     * @param areaid
     * @param pn
     * @return
     */
    @RequestMapping("/areaUpdatePage")
    public String areaUpdate(Model model,Integer areaid,Integer pn){
        Area area = areaService.getAreaById(areaid);
        model.addAttribute("area",area);
        model.addAttribute("pn",pn);
        return "areaUpdate";
    }

    /**
     * 执行添加方法
     * @param area
     * @return
     */
    @RequestMapping("/areaAdd")
    public String areaAdd(Area area){
        areaService.save(area);
        Long count = areaService.getCount();
        return "redirect:getArea?pn="+count;
    }

    /**
     * 进入区域添加页面
     * @return
     */
    @RequestMapping("/areaAddPage")
    public String areaAddPage(){
        return "areaAdd";
    }

    @RequestMapping("/getArea")
    public String getArea(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,10);
        List<Area> areaList = areaService.getAllArea();
        PageInfo pageInfo = new PageInfo(areaList);
        model.addAttribute("areas",areaList);
        model.addAttribute("pages",pageInfo);
        return "arealist";
    }
}
