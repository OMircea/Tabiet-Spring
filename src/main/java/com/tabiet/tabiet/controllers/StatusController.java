package com.tabiet.tabiet.controllers;


import com.tabiet.tabiet.models.Status;
import com.tabiet.tabiet.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statusuri")
public class StatusController {

    private StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/id")
    public List<Status> getStatusByIdT(Long id){
        return statusService.getStatusByIdT(id);
    }
}
