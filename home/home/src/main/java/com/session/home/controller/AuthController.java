package com.session.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.session.home.model.User;
import com.session.home.service.AuthService;
import com.session.home.util.LoginVo;
import com.session.home.util.Result;
import com.session.home.util.enums.SessionKey;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
	AuthService authService;

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") User user){
        return "register";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("loginVo") LoginVo loginVo, ModelMap model){
        return "login";
    }

    // @RequestMapping("/login")
    // public String login(Model model){
    //     model.addAttribute("loginVo", new User());
    //     return "login";
    // }

    @PostMapping("/signup")
	public String signUp(@ModelAttribute("user") User user, RedirectAttributes redirAttributes){

        Result result = authService.insertUser(user);
		
		if(result.hasError()) {
			redirAttributes.addFlashAttribute("user", user);
			redirAttributes.addFlashAttribute("errorMsg", result.getMessage());
			return "redirect:/register";
		}

		return "redirect:/login";
	}

    @PostMapping("/signin")
	public String signIn(@ModelAttribute("loginVo") LoginVo loginVo,HttpServletRequest request, ModelMap model) {
		
		loginVo = authService.login(loginVo);
        
        if(!loginVo.getResultSuccess()) {
        	model.addAttribute("msg", loginVo.getMsg());
        	model.addAttribute("error", loginVo.getMsg());
        	return "redirect:/login";
        }
       
        request.getSession().setAttribute(SessionKey.LOGIN_SESSION_NAME.value, loginVo);
        return "redirect:/"; 
	}
}
