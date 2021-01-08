package com.tabiet.tabiet.controllers;


import com.tabiet.tabiet.models.Tabiet;
import com.tabiet.tabiet.models.User;
import com.tabiet.tabiet.services.TabietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tabieturi")
public class TabietController {

    private TabietService tabietService;

    @Autowired
    public TabietController(TabietService tabietService) {
        this.tabietService = tabietService;
    }

    @GetMapping("")
    public List<Tabiet> getAllTabiet(){
        return tabietService.getAllTabiet();
    }

    @GetMapping("/user")
    public List<Tabiet> getUserTabiet(String username){
        return tabietService.getUserTabiet(username);
    }

    @PostMapping("/add")
    public Tabiet addTabiet(@RequestBody Tabiet tabiet){
        return tabietService.addTabiet(tabiet);
    }

    @GetMapping("/find")
    public Tabiet findTabiet(Long id) { return tabietService.findTabiet(id);}

}
