package com.tabiet.tabiet.services;

import com.tabiet.tabiet.models.TabietGeneral;
import com.tabiet.tabiet.repositories.TabietGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabietGeneralService {

    private TabietGeneralRepository tabietGeneralRepository;

    @Autowired
    public TabietGeneralService(TabietGeneralRepository tabietGeneralRepository) {
        this.tabietGeneralRepository = tabietGeneralRepository;
    }

    public List<TabietGeneral> getTabietGeneral() {
        return tabietGeneralRepository.findAll();
    }
}
