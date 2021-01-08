package com.tabiet.tabiet.controllers;

import com.tabiet.tabiet.models.*;
import com.tabiet.tabiet.repositories.StatusRepository;
import com.tabiet.tabiet.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Null;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MainController {

    private UserService userService;
    private TabietService tabietService;
    private BadgeService badgeService;
    private Tabiet_BadgeService tabiet_badgeService;
    private TabietGeneralService tabietGeneralService;
    private StatusService statusService;

    @Autowired
    public MainController(UserService userService, TabietService tabietService, BadgeService badgeService, Tabiet_BadgeService tabiet_badgeService, TabietGeneralService tabietGeneralService, StatusService statusService) {
        this.userService = userService;
        this.tabietService = tabietService;
        this.badgeService = badgeService;
        this.tabiet_badgeService = tabiet_badgeService;
        this.tabietGeneralService = tabietGeneralService;
        this.statusService = statusService;
    }

    @GetMapping("")
    public String home(){
        return "home";
    }

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registrationSubmit(@ModelAttribute User user) {
        if(userService.getUser(user.getUsername()).getUsername().equals(user.getUsername())) {
            return "tryagain";
        }
        else {
            userService.addUser(user);
            return "succes";
        }
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/tabieturiuser")
    public String tabieturiUser(@CookieValue(value = "username") String username, Model model)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String azi= (String)formatter.format(date);

        model.addAttribute("azi", azi);
        model.addAttribute("tabieturi", tabietService.getUserTabiet(username));
        return "tabieturiuser";
    }

    @PostMapping("/tabieturiuser")
    public String indeplinireTask(Long id, @CookieValue(value = "username") String username, Model model)
    {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String azi= (String)formatter.format(date);

        Tabiet curent=tabietService.findTabiet(id);

        curent.setZile_ramase(curent.getZile_ramase() - 1);
        curent.setUltima_indeplinire(azi);
        tabietService.addTabiet(curent);

        List<Badge> badges=badgeService.getBadges();

        for(Badge badge:badges){
            if(curent.getNr_zile()-curent.getZile_ramase() == badge.getZile_necesare()){
                Tabiet_Badge temp=new Tabiet_Badge();
                temp.setIdb(badge.getId());
                temp.setIdt(id);
                tabiet_badgeService.addTabiet_Badge(temp);
            }
        }


        model.addAttribute("azi", azi);
        model.addAttribute("tabieturi", tabietService.getUserTabiet(username));

        return "tabieturiuser";
    }


    @GetMapping("/index")
    public String showIndex()
    {
        return "index";
    }


    @PostMapping("/index")
    public String index(@ModelAttribute User user, HttpServletResponse response)
    {
        if (!(userService.getUser(user.getUsername()).getUsername().equals(user.getUsername()))) return "tryagain2";
        else if (userService.getUser(user.getUsername()).getPassword().equals(user.getPassword()))
        {
            Cookie cookie = new Cookie("username", user.getUsername());
            response.addCookie(cookie);
            return "index";
        } else return "tryagain2";
    }

    @GetMapping("/adaugaretabiet")
    public String addTabiet(Model model){
        model.addAttribute("tabiet", new Tabiet());
        return "adaugaretabiet";
    }

    @PostMapping("/adaugaretabiet")
    public String saveTabiet(@ModelAttribute Tabiet tabiet, @CookieValue(value = "username") String username)
    {
        tabiet.setUsername(username);
        tabiet.setIdTG(null);
        tabiet.setId(null);
        tabiet.setZile_ramase(tabiet.getNr_zile());
        tabiet.setUltima_indeplinire(null);
        tabietService.addTabiet(tabiet);
        return "succestabiet";
    }

    @GetMapping("/stergeretabiet")
    public String showStergereTabiet(@CookieValue(value = "username") String username, Model model)
    {
        model.addAttribute("tabieturi", tabietService.getUserTabiet(username));
        return "stergeretabiet";
    }

    @GetMapping("/badgeuriuser")
    public String showBadgeuriUser(@CookieValue(value = "username") String username, Model model)
    {
        List<Tabiet> tabiets = tabietService.getUserTabiet(username);
        List<Badge> badges = badgeService.getBadges();
        List<Zi_Desc> zi_descs = new ArrayList<>();

        for(Tabiet i:tabiets) {

            List<Tabiet_Badge> ta_ba= tabiet_badgeService.getAllByTabiet(i.getId());
            for(Tabiet_Badge y: ta_ba){
                Zi_Desc temp = new Zi_Desc();
                temp.setDescriere(i.getDescriere());
                temp.setZile(badgeService.findBadge(y.getIdb()).getZile_necesare());
                zi_descs.add(temp);
            }

        }

        model.addAttribute("zi_descs", zi_descs);

        return "badgeuriuser";
    }

    @GetMapping("/tabieturigenerale")
    public String tabieturiGenerale(Model model)
    {
        List<TabietGeneral> tabiets = tabietGeneralService.getTabietGeneral();

        model.addAttribute("tabieturigen", tabiets);

        return "tabieturigenerale";
    }


    @PostMapping("/tabieturigenerale")
    public String tabieturiGeneraleAdd(@ModelAttribute Tabiet tabiet, @CookieValue(value = "username") String username)
    {
        tabiet.setUsername(username);
        tabiet.setId(null);
        tabiet.setZile_ramase(tabiet.getNr_zile());
        tabiet.setUltima_indeplinire(null);
        tabietService.addTabiet(tabiet);
        return "succestabiet";
    }

    @GetMapping("/rapoarteuser")
    public String showRapoarte(@CookieValue(value = "username") String username, Model model)
    {
        List<Tabiet> tabiets = tabietService.getUserTabiet(username);
        List<Struct> date = new ArrayList<>();

        for(Tabiet i:tabiets){
            Struct temp = new Struct();
            temp.setDescriere(i.getDescriere());
            temp.setNr_zile(i.getNr_zile());
            temp.setZile_complete(i.getNr_zile()-i.getZile_ramase());
            Float a = i.getZile_ramase().floatValue();
            Float b = i.getNr_zile().floatValue();
            Float c = 100f;
            temp.setProcent(c-(a/b*c));
            date.add(temp);
        }

        model.addAttribute("date", date);

        return"rapoarteuser";
    }

    @PostMapping("/addstatus")
    public String addStatus(@ModelAttribute Status status)
    {
        statusService.addStatus(status);
        return "successtatus";
    }

    @GetMapping("/statusuritabiet")
    public String showStatsTabiet(Long id, Model model)
    {
        model.addAttribute("statstabiet", statusService.getStatusByIdT(id));
        return "statusuritabiet";
    }
}
