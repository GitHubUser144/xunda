package com.controller;

import com.pojo.Area;
import com.pojo.Car;
import com.pojo.Carroad;
import com.pojo.Transcar;
import com.service.AreaService;
import com.service.CarServce;
import com.service.CarroadService;
import com.service.TranscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 途径线路明细的控制器
 */
@Controller
public class CarRoadController {

    @Autowired
    private CarroadService carRoadService;

    @Autowired
    private CarServce carServce;

    @Autowired
    private AreaService areaService;

    @Autowired
    private TranscarService transcarService;

    /**
     * 添加线路
     * @param carroad
     * @return
     */
    @RequestMapping("/carRoadAdd")
    public String carRoadAdd(Carroad carroad){
        System.out.println("========="+carroad);
        return null;
    }

    /**
     * 显示途径线路明细信息
     * @param tradsid
     * @param carid
     * @param transid
     * @param model
     * @return
     */
    @RequestMapping("/getCarRoad")
    public String getCarRoad(Integer tradsid,Integer carid,Integer transid,Model model){
        List<Carroad> carroadList = carRoadService.getCarroadById(tradsid);
        Car car = carServce.getCarByid(carid);
        Transcar transcar = transcarService.getTransCarByTransId(tradsid);
        Area sendCity = areaService.getAreaById(transcar.getSendcity());
        Area receCity = areaService.getAreaById(transcar.getRececity());
        List<Area> areaList = areaService.getAllArea();
        List<Area> startcityList = new ArrayList<>();
        List<Area> endcityList = new ArrayList<>();
        for (int i=0;i<carroadList.size();i++){
            Area area = areaService.getAreaById(carroadList.get(i).getStartcity());
            startcityList.add(i,area);
        }
        for (int i=0;i<carroadList.size();i++){
            Area area = areaService.getAreaById(carroadList.get(i).getEndcity());
            endcityList.add(i,area);
        }
        model.addAttribute("sendCity",sendCity.getAreaname());
        model.addAttribute("receCity",receCity.getAreaname());
        model.addAttribute("transcar",transcar);
        model.addAttribute("areas",areaList);
        model.addAttribute("roads",carroadList);
        model.addAttribute("startcitys",startcityList);
        model.addAttribute("endcitys",endcityList);
        return "carRoad";
    }
}
