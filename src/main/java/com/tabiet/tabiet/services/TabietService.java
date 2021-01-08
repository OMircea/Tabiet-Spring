package com.tabiet.tabiet.services;

import com.tabiet.tabiet.models.Tabiet;
import com.tabiet.tabiet.repositories.TabietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TabietService {

    private TabietRepository tabietRepository;

    @Autowired
    public TabietService(TabietRepository tabietRepository) {
        this.tabietRepository = tabietRepository;
    }

    public List<Tabiet> getAllTabiet(){
        return tabietRepository.findAll();
    }

    public List<Tabiet> getUserTabiet(String username){
        return tabietRepository.findAllByUsername(username);
    }

    public Tabiet addTabiet(Tabiet tabiet){
        return tabietRepository.save(tabiet);
    }

    public Tabiet findTabiet(Long id) { return tabietRepository.findTabietById(id); }

}
