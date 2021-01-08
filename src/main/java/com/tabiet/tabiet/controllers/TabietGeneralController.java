package com.tabiet.tabiet.controllers;


import com.tabiet.tabiet.models.TabietGeneral;
import com.tabiet.tabiet.services.TabietGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tabgen")
public class TabietGeneralController {

    private TabietGeneralService tabietGeneralService;

    @Autowired
    public TabietGeneralController(TabietGeneralService tabietGeneralService) {
        this.tabietGeneralService = tabietGeneralService;
    }

    @GetMapping("")
    public List<TabietGeneral> getTabietGeneral(){
        return tabietGeneralService.getTabietGeneral();
    }
}
