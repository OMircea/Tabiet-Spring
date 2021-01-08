package com.tabiet.tabiet.controllers;

import com.tabiet.tabiet.models.Badge;
import com.tabiet.tabiet.services.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/badges")
public class BadgeController {

    private BadgeService badgeService;

    @Autowired
    public BadgeController(BadgeService badgeService) {
        this.badgeService = badgeService;
    }

    @GetMapping("")
    public List<Badge> getBadges(){
        return badgeService.getBadges();
    }
}
