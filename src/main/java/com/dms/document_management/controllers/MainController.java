package com.dms.document_management.controllers;

import com.dms.document_management.dto.confis.AuthRequestDto;
import com.dms.document_management.dto.user.UserInfoDto;
import com.dms.document_management.managers.UserInfoManager;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Controller
@RequestMapping( value = "/dms")
public class MainController {
    @Resource
    private UserInfoManager userInfoManager;

    /**
     *
     * @return
     */
    @PostMapping(value = "/login")
    public ModelAndView login(){return new ModelAndView("/user/login");}

    /**
     *
     * @param authRequestDto
     * @return
     */
    @PostMapping(value = "/loginUser")
    public ModelAndView login(AuthRequestDto authRequestDto){
        ModelAndView modelAndView = new ModelAndView("index");
        if (Objects.nonNull(authRequestDto)){
            userInfoManager.loadUserByUsername(authRequestDto.getUsername());
        }
        return modelAndView;
    }

    /**
     *
     * @return
     */
    @PostMapping(value = "/register")
    public ModelAndView openRegister(){ return new ModelAndView("/user/register");}


    /**
     *
     * @param userInfoDto
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/createUser")
    public ModelAndView creatUser(UserInfoDto userInfoDto) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/user/login");
        if (Objects.nonNull(userInfoDto)){
            userInfoManager.createUser(userInfoDto);
        }
        return modelAndView;
    }

}
