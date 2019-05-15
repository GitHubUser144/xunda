package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单详细的控制器
 */
@Controller
public class CardetailController {

    @Autowired
    private CardetailService cardetailService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private TranscarService transcarService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaidtypeService paidtypeService;

    /**
     * 根据条件查询订单信息
     * @param pn
     * @param cardetail
     * @param model
     * @return
     */
    @RequestMapping("/getCarDetailRep")
    public String getCarDetailRep(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Cardetail cardetail,Model model){
        System.out.println("-----------"+cardetail);
        PageHelper.startPage(pn,5);
        List<Cardetail> cardetailList = cardetailService.getCardetailByQuery(cardetail);
        PageInfo pageInfo = new PageInfo(cardetailList);
        List<Area> sendcitys = new ArrayList<>();
        List<Area> rececitys = new ArrayList<>();
        List<Customer> sendCust = new ArrayList<>();
        List<Customer> receCust = new ArrayList<>();
        for(int i=0;i<cardetailList.size();i++){
            sendcitys.add(i,areaService.getAreaById(cardetailList.get(i).getSendcity()));
        }
        for(int i=0;i<cardetailList.size();i++){
            rececitys.add(i,areaService.getAreaById(cardetailList.get(i).getRececity()));
        }
        for(int i=0;i<cardetailList.size();i++){
            sendCust.add(i,customerService.getCustomer(cardetailList.get(i).getSendcustid()));
        }
        for(int i=0;i<cardetailList.size();i++){
            receCust.add(i,customerService.getCustomer(cardetailList.get(i).getRececustid()));
        }
        System.out.println("-------------"+cardetailList);
        model.addAttribute("carDetail",cardetailList);
        model.addAttribute("sendcitys",sendcitys);
        model.addAttribute("rececitys",rececitys);
        model.addAttribute("sendCust",sendCust);
        model.addAttribute("receCust",receCust);
        model.addAttribute("pages",pageInfo);
        model.addAttribute("cardetail",cardetail);
        return "CarDetailbyTransIDlist";
    }

    /**
     * 进入订单搜索页面
     * @param model
     * @return
     */
    @RequestMapping("/getCarDetailRepPage")
    public String getCarDetailRepPage(Model model){
        List<Transcar> transcarList = transcarService.getAllTransCar();
        List<Area> areaList = areaService.getAllArea();
        List<Customer> customerList = customerService.getAllCustomer();
        System.out.println("---------"+transcarList);
        List<Area> sendcity = new ArrayList<>();
        List<Area> rececity = new ArrayList<>();
        for (int i=0;i<transcarList.size();i++){
            sendcity.add(i,areaService.getAreaById(transcarList.get(i).getSendcity()));
        }
        for (int i=0;i<transcarList.size();i++){
            rececity.add(i,areaService.getAreaById(transcarList.get(i).getRececity()));
        }
        model.addAttribute("transCars",transcarList);
        model.addAttribute("sendcity",sendcity);
        model.addAttribute("rececity",rececity);
        model.addAttribute("areas",areaList);
        model.addAttribute("custs",customerList);
        return "CarDetailRep";
    }


    /**
     * 订单明细
     * @param pn
     * @param customerid
     * @param model
     * @return
     */
    @RequestMapping("/getCarDetail")
    public String getCarDetail(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Integer customerid,Model model){
        System.out.println("=========="+customerid);
        PageHelper.startPage(pn,5);
        List<Cardetail> cardetailList =  cardetailService.getCardetail(customerid);
        PageInfo pageInfo = new PageInfo(cardetailList);
        List<Area> sendcitys = new ArrayList<>();
        List<Area> rececitys = new ArrayList<>();
        List<Customer> sendCust = new ArrayList<>();
        List<Customer> receCust = new ArrayList<>();
        for(int i=0;i<cardetailList.size();i++){
            sendcitys.add(i,areaService.getAreaById(cardetailList.get(i).getSendcity()));
        }
        for(int i=0;i<cardetailList.size();i++){
            rececitys.add(i,areaService.getAreaById(cardetailList.get(i).getRececity()));
        }
        for(int i=0;i<cardetailList.size();i++){
            sendCust.add(i,customerService.getCustomer(cardetailList.get(i).getSendcustid()));
        }
        for(int i=0;i<cardetailList.size();i++){
            receCust.add(i,customerService.getCustomer(cardetailList.get(i).getRececustid()));
        }
        System.out.println("===========send"+sendCust+"==============="+receCust);
        model.addAttribute("carDetail",cardetailList);
        model.addAttribute("sendcitys",sendcitys);
        model.addAttribute("rececitys",rececitys);
        model.addAttribute("sendCust",sendCust);
        model.addAttribute("receCust",receCust);
        model.addAttribute("pages",pageInfo);
        return "CarDetailbyCustomerIDlist";
    }

    /**
     * 添加订单
     * @param cardetail
     * @return
     */
    @RequestMapping("/cardetailAdd")
    public String cardetailAdd(Cardetail cardetail){
        System.out.println("====数据"+cardetail);
        return null;
    }

    /**
     *  进入新增订单页面
     * @return
     */
    @RequestMapping("/cardetailAddPage")
    public String cardetailAddPage(Model model){
        List<Transcar> transcarList = transcarService.getAllTransCar();
        List<Area> sendCitys = new ArrayList<>();
        List<Area> receCitys = new ArrayList<>();
        List<Customer> customerList = customerService.getAllCustomer();
        List<Area> areaList = areaService.getAllArea();
        List<Paidtype> paidtypeList = paidtypeService.getAll();
        for (int i=0;i<transcarList.size();i++){
            sendCitys.add(i,areaService.getAreaById(transcarList.get(i).getSendcity()));
        }
        for (int i=0;i<transcarList.size();i++){
            receCitys.add(i,areaService.getAreaById(transcarList.get(i).getRececity()));
        }
        model.addAttribute("transCars",transcarList);
        model.addAttribute("sendCitys",sendCitys);
        model.addAttribute("receCitys",receCitys);
        model.addAttribute("custs",customerList);
        model.addAttribute("areas",areaList);
        model.addAttribute("paidtypes",paidtypeList);
        return "CarDetailAdd";
    }

    /**
     * 获取订单详细
     * @return
     */
    @RequestMapping("/getCardetail")
    public String getCardetail(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Cardetail> cardetailList = cardetailService.getAll();
        PageInfo pageInfo = new PageInfo(cardetailList);
        List<Area> sendcitys = new ArrayList<>();
        List<Area> rececitys = new ArrayList<>();
        List<Customer> sendCust = new ArrayList<>();
        List<Customer> receCust = new ArrayList<>();
        for(int i=0;i<cardetailList.size();i++){
            sendcitys.add(i,areaService.getAreaById(cardetailList.get(i).getSendcity()));
        }
        for(int i=0;i<cardetailList.size();i++){
            rececitys.add(i,areaService.getAreaById(cardetailList.get(i).getRececity()));
        }
        for(int i=0;i<cardetailList.size();i++){
            sendCust.add(i,customerService.getCustomer(cardetailList.get(i).getSendcustid()));
        }
        for(int i=0;i<cardetailList.size();i++){
            receCust.add(i,customerService.getCustomer(cardetailList.get(i).getRececustid()));
        }
        System.out.println("==================="+cardetailList);
        System.out.println("================"+sendCust);
        System.out.println("================"+receCust);
        model.addAttribute("carDetail",cardetailList);
        model.addAttribute("sendcitys",sendcitys);
        model.addAttribute("rececitys",rececitys);
        model.addAttribute("sendCust",sendCust);
        model.addAttribute("receCust",receCust);
        model.addAttribute("pages",pageInfo);
        return "CarDetaillist";
    }
}
