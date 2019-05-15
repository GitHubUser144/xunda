package com.controller;

import com.pojo.Accmodule;
import com.pojo.AccmoduleExample;
import com.pojo.Module;
import com.pojo.Users;
import com.service.AccmoduleService;
import com.service.ModuleService;
import com.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private AccmoduleService accmoduleService;

    @Autowired
    private UsersService usersService;

    /**
     * 删除权限
     * @param request
     * @param userid
     * @return
     */
    @RequestMapping("/delAccModule")
    public String delAccModule(HttpServletRequest request,Integer userid){
        String[] accids = request.getParameterValues("accid");
        for (int i=0;i<accids.length;i++){
            AccmoduleExample accmoduleExample = new AccmoduleExample();
            AccmoduleExample.Criteria criteria = accmoduleExample.createCriteria();
            criteria.andModuleidEqualTo(Integer.valueOf(accids[i]));
            accmoduleService.deleteByModuleid(accmoduleExample);
        }
        return "redirect:AccModuleManageByUserid?userid="+userid;
    }

    /**
     * 授予权限
     * @param request
     * @return
     */
    @RequestMapping("/addAccModule")
    public String addAccModule(HttpServletRequest request,Integer userid){
        String[] moduleids = request.getParameterValues("moduleid");
        List<Accmodule> accmoduleList = accmoduleService.getAccmoduleByUserId(userid);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<accmoduleList.size();i++){
            stringBuffer.append(accmoduleList.get(i).getModuleid());
        }
        for (int i=0;i<moduleids.length;i++){
            if(stringBuffer.toString().contains(moduleids[i])==false){
                Accmodule accmodule = new Accmodule();
                accmodule.setModuleid(Integer.valueOf(moduleids[i]));
                accmodule.setUserid(userid);
                accmoduleService.save(accmodule);
            }
            System.out.println("--------------"+moduleids[i]);
        }
        return "redirect:AccModuleManageByUserid?userid="+userid;
    }

    /**
     * 查看权限
     * @param module
     * @param userid
     * @return
     */
    @RequestMapping("/AccModuleManageByUserid")
    public String AccModuleManageByUserid(org.springframework.ui.Model module,Integer userid){
        List<Module> moduleServiceAll = moduleService.getAll();
        List<Accmodule> accmoduleList = accmoduleService.getAccmoduleByUserId(userid);
        List<Users> usersList = usersService.getAllUser();
        module.addAttribute("accmoduleList",accmoduleList);
        module.addAttribute("moduleServiceAll",moduleServiceAll);
        module.addAttribute("userList",usersList);
        return "accModuleList";
    }

    /**
     * 进入权限管理页面
     * @param module
     * @param session
     * @return
     */
    @RequestMapping("/AccModuleManage")
    public String AccModuleManage(org.springframework.ui.Model module, HttpSession session){
        Users users = (Users) session.getAttribute("user");
        List<Module> moduleServiceAll = moduleService.getAll();
        List<Accmodule> accmoduleList = accmoduleService.getAccmoduleByUserId(users.getId());
        List<Users> usersList = usersService.getAllUser();
        module.addAttribute("accmoduleList",accmoduleList);
        module.addAttribute("moduleServiceAll",moduleServiceAll);
        module.addAttribute("userList",usersList);
        return "accModuleList";
    }
}
