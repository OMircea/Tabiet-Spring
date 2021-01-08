package com.tabiet.tabiet.services;

import com.tabiet.tabiet.models.Tabiet;
import com.tabiet.tabiet.models.Tabiet_Badge;
import com.tabiet.tabiet.repositories.Tabiet_BadgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Tabiet_BadgeService {

    private Tabiet_BadgeRepository tabiet_badgeRepository;

    @Autowired
    public Tabiet_BadgeService(Tabiet_BadgeRepository tabiet_badgeRepository) {
        this.tabiet_badgeRepository = tabiet_badgeRepository;
    }

    public List<Tabiet_Badge> getAllByTabiet(Long idt){
        return tabiet_badgeRepository.findAllByIdt(idt);
    }

    public List<Tabiet_Badge> getAllByBadge(Long idb){
        return tabiet_badgeRepository.findAllByIdb(idb);
    }

    public Tabiet_Badge addTabiet_Badge(Tabiet_Badge tabiet_badge){
        return tabiet_badgeRepository.save(tabiet_badge);
    }
}
