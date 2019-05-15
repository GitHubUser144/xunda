package com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Area;
import com.pojo.Users;
import com.service.AreaService;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户控制器
 */
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AreaService areaService;

    @RequestMapping("/userLogout")
    public String userLogout(HttpSession session){
        session.invalidate();
        return "index";
    }

    /**
     * 跟新用户的密码
     * @param oldpwd
     * @param password
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/userUpdatePassword")
    public String userUpdatePassword(String oldpwd,String password,HttpSession session,Model model){
        Users user = (Users) session.getAttribute("user");
        if(oldpwd.equals(user.getPassword())){
            usersService.updateUserPassword(user.getId(),password);
            model.addAttribute("ret","修改成功");
            return "modifypwd";
        }else{
            model.addAttribute("ret","原始密码错误");
            return "modifypwd";
        }

    }

    /**
     * 修改用户状态
     * @param pn
     * @param id
     * @param staus
     * @return
     */
    @RequestMapping("/userUpdateStatus")
    public String userUpdateStatus(int pn,int id,int staus){
        usersService.updateUserStaus(id,staus);
        return "redirect:getUsers?pn="+pn;
    }

    /**
     * 添加用户的判断 判断该用户是否存在
     * @param username
     * @return status:0 不可用 ，status:1 可用
     */
    @RequestMapping("/userRepetition")
    @ResponseBody
    public Map userRepetition(String username){
        Users users = usersService.getUserByName(username);
        Map<String,Object> map = new HashMap<>();
        if (users!=null){
            map.put("status","0");
            map.put("faile","用户名已存在");
        }else{
            map.put("status","1");
            map.put("ok","用户名可用");
        }
        return map;
    }

    /**
     * 执行用户删除操作
     * @return
     */
    @RequestMapping("/userDelete")
    public String userDelete(Integer id,Integer pn){
        usersService.deleteUser(id);
        return "redirect:getUsers?pn="+pn;
    }
    /**
     * 执行用户更新操作
     * @param users
     * @return
     */
    @RequestMapping("/userUpdate")
    public String userUpdate(Users users,Integer pn){
        usersService.updateUser(users);
        return "redirect:getUsers?pn="+pn;
    }

    /**
     * 进入修改用户页面并显示用户信息
     * @param id
     * @return
     */
    @RequestMapping("/userUpdatePage")
    public String userUpdatePage(Integer id,Integer pn,Model model){
        Users user = usersService.getUserById(id);
        List<Area> areaList = areaService.getAllArea();
        model.addAttribute("user",user);
        model.addAttribute("areas",areaList);
        model.addAttribute("pn",pn);
        return "userUpdate";
    }

    /**
     * 添加用户的操作
     * @return
     */
    @RequestMapping("/userAdd")
    public String userAdd(Users users){
        users.setStaus(1);
        usersService.save(users);
        long count = usersService.getUserCount();
        return "redirect:getUsers?pn="+count;
    }
    /**
     *  进入用户添加页面
     * @return
     */
    @RequestMapping("/userAddPage")
    public String userAddPage(Model model){
        List<Area> areaList = areaService.getAllArea();
        model.addAttribute("areas",areaList);
        return "userAdd";
    }

    /**
     * 登录
     * @param users 用户名及密码
     * @param yzm 验证码
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/users_login")
    public String login(Users users, String yzm, Model model, HttpSession session){

        Users user = usersService.getUserByNmaeAndPw(users.getUsername(),users.getPassword());
        String verification = (String) session.getAttribute("rand");
        if(yzm.equalsIgnoreCase(verification)){
            if(user != null){
                if(user.getStaus()==0){
                    model.addAttribute("islogin","dis");
                    return "index";
                }else{
                    session.setAttribute("user",user);
                    return "main";
                }
            }else{
                model.addAttribute("islogin","failed");
                return "index";
            }
        }else{
            model.addAttribute("islogin","expire");
            return "index";
        }
    }

    /**
     * 查询所有的用户列表并且分页
     * @param model
     * @return
     */
    @RequestMapping("/getUsers")
    public String getUsers(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
        PageHelper.startPage(pn,5);
        List<Users> usersList = usersService.getAllUser();
        PageInfo page = new PageInfo(usersList);
        model.addAttribute("userList",usersList);
        model.addAttribute("pages",page);
        return "userlist";
    }
}
