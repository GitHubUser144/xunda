package com.interceptor;

import com.mapper.AccmoduleMapper;
import com.mapper.ModuleMapper;
import com.pojo.Accmodule;
import com.pojo.AccmoduleExample;
import com.pojo.Module;
import com.pojo.Users;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Mycheck {
    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private AccmoduleMapper accmoduleMapper;

    public Object roleCheck(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        HttpSession session = request.getSession();
        Users users = (Users) session.getAttribute("user");
        System.out.println("----------"+users);
        String url = request.getServletPath().replace("/","");
        List<Module> modules = new ArrayList<>();
        AccmoduleExample accmoduleExample = new AccmoduleExample();
        AccmoduleExample.Criteria criteria = accmoduleExample.createCriteria();
        criteria.andUseridEqualTo(users.getId());
        List<Accmodule> accmoduleList = accmoduleMapper.selectByExample(accmoduleExample);
        for(int i=0;i<accmoduleList.size();i++){
            modules.add(i,moduleMapper.selectByPrimaryKey(accmoduleList.get(i).getModuleid()));
        }
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<modules.size();i++){
            stringBuffer.append(modules.get(i).getMoethod());
        }
        String s = stringBuffer.toString();
        System.out.println(stringBuffer+"==========");
        System.out.println("地址"+url+"------");
        System.out.println("===================前置通知=============");
        if(s.contains(url)){
            return pjp.proceed();
        }else {
            request.getRequestDispatcher("unused.jsp").forward(request,response);
            return null;
        }
    }

}
