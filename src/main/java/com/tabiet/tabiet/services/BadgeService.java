package com.tabiet.tabiet.services;


import com.tabiet.tabiet.models.Badge;
import com.tabiet.tabiet.repositories.BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BadgeService {

    private BadgeRepository badgeRepository;

    @Autowired
    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    public List<Badge> getBadges(){
        return badgeRepository.findAll();
    }

    public Badge findBadge(Long id) {return badgeRepository.findBadgeById(id); }
}
