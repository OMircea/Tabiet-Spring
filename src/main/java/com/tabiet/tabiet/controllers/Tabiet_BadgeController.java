package com.tabiet.tabiet.controllers;

import com.tabiet.tabiet.models.Tabiet_Badge;
import com.tabiet.tabiet.services.Tabiet_BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tabiet_badge")
public class Tabiet_BadgeController {

    private Tabiet_BadgeService tabiet_badgeService;

    @Autowired
    public Tabiet_BadgeController(Tabiet_BadgeService tabiet_badgeService) {
        this.tabiet_badgeService = tabiet_badgeService;
    }

    @GetMapping("/tabiet")
    public List<Tabiet_Badge> getAllByTabiet(Long idt){
        return tabiet_badgeService.getAllByTabiet(idt);
    }

    @GetMapping("/badge")
    public List<Tabiet_Badge> getAllByBadge(Long idb){
        return tabiet_badgeService.getAllByBadge(idb);
    }
}
