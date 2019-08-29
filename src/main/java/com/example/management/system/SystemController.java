package com.example.management.system;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SystemController {

    private static List<System> systems = new ArrayList<System>();

    static {
        systems.add(new System("Bill", "Gates"));
        systems.add(new System("Steve", "Jobs"));
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        String message = "Hello Spring Boot + JSP";

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {

        model.addAttribute("system", systems);

        return "personList";
    }

    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public String viewLogin(Model model) {

        model.addAttribute("system", systems);

        return "login";
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


}