package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Area;
import com.pojo.Car;
import com.pojo.Sendtype;
import com.pojo.Transcar;
import com.service.AreaService;
import com.service.CarServce;
import com.service.SendtypeService;
import com.service.TranscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 车辆调度的控制器
 */
@Controller
public class TransCarController {

    @Autowired
    private TranscarService transcarService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private CarServce carServce;

    @Autowired
    private SendtypeService sendtypeService;

    @RequestMapping("/addTracsCar")
    public String addTracsCar(Transcar transcar){
        transcar.setGcount(BigDecimal.ZERO);
        transcar.setCarstatus("未发车");
        transcar.setSendfee(BigDecimal.ZERO);
        transcarService.save(transcar);
        Long count = transcarService.getCount();
        System.out.println("----------"+transcar);
        return "redirect:getTransCar?pn="+count;
    }

    /**
     * 进入车辆新增页面
     * @param model
     * @return
     */
    @RequestMapping("/addTracsCarPage")
    public String addTracsCarPage(Model model){
        List<Car> carList = carServce.getAll();
        List<Area> areaList = areaService.getAllArea();
        List<Sendtype> sendtypeList = sendtypeService.getAll();
        model.addAttribute("cars",carList);
        model.addAttribute("areas",areaList);
        model.addAttribute("sendtypes",sendtypeList);
        return "transCarAdd";
    }

    /**
     * 根据车辆调度修改
     * @param transcar
     * @param pn
     * @return
     */
    @RequestMapping("/transCarUpdate")
    public String transCarUpdate(Transcar transcar,Integer pn){
        transcarService.updateTranscar(transcar);
        return "redirect:getTransCar?pn="+pn;
    }

    /**
     * 进入车辆调度的修改页面
     * @param transId
     * @return
     */
    @RequestMapping("/transCarUpdatePage")
    public String transCarUpdatePage(Integer transId,Integer pn,Model model){
        Transcar transcar = transcarService.getTransCarByTransId(transId);
        List<Car> carList = carServce.getAll();
        List<Area> areaList = areaService.getAllArea();
        List<Sendtype> sendtypeList = sendtypeService.getAll();
        model.addAttribute("cars",carList);
        model.addAttribute("transCar",transcar);
        model.addAttribute("areas",areaList);
        model.addAttribute("sendtypes",sendtypeList);
        model.addAttribute("pn",pn);
        return "transCarUpdate";
    }

    /**
     * 修改车辆的状态
     * @param transid
     * @return
     */
    @RequestMapping("/transCarUpdateCarStuaus")
    public String transCarUpdateCarStuaus(Integer transid,Integer status){
        System.out.println("============"+transid);
        String statusCar = "";
        String page = "";
        if(status == 0){
            statusCar  = "已发车";
            page = "redirect:getTransCarStatus?statusid=0";
        }
        if(status == 1){
            statusCar  = "已到站";
            page = "redirect:getTransCarStatus?statusid=1";
        }
        transcarService.updateTranscarStatusByTransId(transid,statusCar);
        return page;
    }

    /**
     * 根据车辆不同的状态
     * @param pn
     * @param model
     * @param statusid
     * @return
     */
    @RequestMapping("/getTransCarStatus")
    public String getTransCarStart(@RequestParam (value = "pn",defaultValue = "1") Integer pn, Model model,Integer statusid){
        PageHelper.startPage(pn,5);
        List<Transcar> transcarList = new ArrayList<>();
        String page = null;
        if(statusid == 0){
            transcarList = transcarService.getTransCarByCarStatus("未发车");
            page = "transCarStartlist";
        }
        if(statusid == 1){
            transcarList = transcarService.getTransCarByCarStatus("已发车");
            page = "transCarFinishlist";
        }
        if(statusid == 2){
            transcarList = transcarService.getTransCarByCarStatus("已到站");
            page = "transCarOverlist";
        }
        PageInfo pageInfo = new PageInfo(transcarList);
        model.addAttribute("cars",transcarList);
        model.addAttribute("pages",pageInfo);
        List<Area> rececity = new ArrayList<>();
        List<Area> sendcity = new ArrayList<>();
        for (int i=0;i<transcarList.size();i++){
            Area area = areaService.getAreaById(transcarList.get(i).getRececity());
            System.out.println("============"+area);
            rececity.add(i,area);
        }
        for (int i=0;i<transcarList.size();i++){
            Area area = areaService.getAreaById(transcarList.get(i).getSendcity());
            sendcity.add(i,area);
        }
        model.addAttribute("rececity",rececity);
        model.addAttribute("sendcity",sendcity);
        return page;
    }

    /**
     *  显示车辆调度的页面且分页
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/getTransCar")
    public String getTransCar(@RequestParam (value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Transcar> transcarList = transcarService.getAllTransCar();
        PageInfo pageInfo = new PageInfo(transcarList);
        model.addAttribute("cars",transcarList);
        model.addAttribute("pages",pageInfo);
        List<Area> rececity = new ArrayList<>();
        List<Area> sendcity = new ArrayList<>();
        for (int i=0;i<transcarList.size();i++){
            Area area = areaService.getAreaById(transcarList.get(i).getRececity());
            rececity.add(i,area);
        }
        for (int i=0;i<transcarList.size();i++){
            Area area = areaService.getAreaById(transcarList.get(i).getSendcity());
            sendcity.add(i,area);
        }
        model.addAttribute("rececity",rececity);
        model.addAttribute("sendcity",sendcity);
        return "transCarlist";
    }
}
