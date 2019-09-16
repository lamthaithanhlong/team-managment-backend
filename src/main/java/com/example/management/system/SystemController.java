package com.example.management.system;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import com.example.management.utils.WebUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SystemController {

    private static List<SystemEntity> systemEntities = new ArrayList<SystemEntity>();

    static {
        systemEntities.add(new SystemEntity("Bill", "Gates"));
        systemEntities.add(new SystemEntity("Steve", "Jobs"));
    }

    @RequestMapping(value = {"/indexEx" }, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "indexPage";
    }

    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("system", systemEntities);

        return "personListPage";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String viewLogin(Model model) {

        model.addAttribute("system", systemEntities);

        return "loginPage";
    }


    @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
    public String homePage(Model model) {
        return "homePage";
    }


    @RequestMapping(value = { "/contactus" }, method = RequestMethod.GET)
    public String contactusPage(Model model) {
        model.addAttribute("address", "Vietnam");
        model.addAttribute("phone", "...");
        model.addAttribute("email", "...");
        return "contactusPage";
    }

    @RequestMapping(value = { "/dashboard" }, method = RequestMethod.GET)
    public String dashboardPage(Model model) {
        return "dashboardPage";
    }

//    =============================================================================
@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
public String welcomePage(Model model) {
    model.addAttribute("title", "Welcome");
    model.addAttribute("message", "This is welcome page!");
    return "welcomePage";
}

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/loginAut", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
//    =============================================================================
}