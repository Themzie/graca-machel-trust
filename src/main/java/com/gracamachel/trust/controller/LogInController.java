package com.gracamachel.trust.controller;

import com.gracamachel.trust.utils.LoggedInUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by thembelani on 11/2/17.
 */

@Slf4j
@Controller
public class LogInController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLogInPage(){
        log.debug("********************IN LOGIN PAGE************************************************");
        return "login/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginMessage(@RequestParam(name = "error", required = false) final String error, @RequestParam(name = "logout", required = false) final String logout){
        final ModelAndView modelAndView = new ModelAndView("login/login");
        log.debug("********************ATTEMPTING TO LOGIN************************************************");
        if(error != null) {
            log.info(">> Error  DURING LOGIN : "+error);
            modelAndView.addObject("error", "Invalid username and password");
        }
        if(logout != null) {
            log.info(">> Log out : " + logout);
            modelAndView.addObject("info", "You have been logged out successfully");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showDashboard(Model model ){
        model.addAttribute("loggedInUser", LoggedInUser.getUsername());
        return "home/home";
    }
}
