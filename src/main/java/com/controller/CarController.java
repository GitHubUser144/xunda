package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Area;
import com.pojo.Car;
import com.pojo.Customer;
import com.service.AreaService;
import com.service.CarServce;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *  运输工具的控制器
 */
@Controller
public class CarController {

    @Autowired
    private CarServce carServce;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AreaService areaService;

    /**
     * 删除运输工具
     * @param carid
     * @param pn
     * @return
     */
    @RequestMapping("/carDelete")
    public String carDelete(Integer carid,Integer pn){
        carServce.deleteById(carid);
        return "redirect:getCar?pn="+pn;
    }

    /**
     *  修改运输车辆
     * @param car
     * @param pn
     * @return
     */
    @RequestMapping("/carUpdate")
    public String carUpdate(Car car,Integer pn){
        carServce.updateCar(car);
        return "redirect:getCar?pn="+pn;
    }
    /**
     * 进入运输工具修改页面
     * @param pn
     * @param model
     * @return
     */
    @RequestMapping("/carUpdatePage")
    public String carUpdatePage(Integer pn,Integer carid,Model model){
        Car car = carServce.getCarByid(carid);
        List<Customer> customerList = customerService.getAllCustomer();
        List<Area> areaList = areaService.getAllArea();
        model.addAttribute("car",car);
        model.addAttribute("custs",customerList);
        model.addAttribute("areas",areaList);
        model.addAttribute("pn",pn);
        return "carUpdate";
    }

    /**
     * 执行添加操作
     * @param car
     * @return
     */
    @RequestMapping("/carAdd")
    public String carAdd(Car car){
        carServce.save(car);
        long count = carServce.getCount();
        return "redirect:getCar?pn="+count;
    }

    /**
     * 进入运输工具添加页面
     * @param model
     * @return
     */
    @RequestMapping("/addCarPage")
    public String addCarPage(Model model){
        List<Customer> customerList = customerService.getAllCustomer();
        List<Area> areaList = areaService.getAllArea();
        model.addAttribute("custs",customerList);
        model.addAttribute("areas",areaList);
        return "carAdd";
    }

    /**
     * 显示所有的运输工具且进行分页
     * @return
     */
    @RequestMapping("/getCar")
    public String getCar(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn,5);
        List<Car> carList = carServce.getAll();
        PageInfo pageInfo = new PageInfo(carList);
        model.addAttribute("cars",carList);
        model.addAttribute("pages",pageInfo);
        return "carlist";
    }
}
