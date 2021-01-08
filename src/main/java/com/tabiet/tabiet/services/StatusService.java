package com.tabiet.tabiet.services;

import com.tabiet.tabiet.models.Status;
import com.tabiet.tabiet.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private StatusRepository statusRepository;

    @Autowired
    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> getStatusByIdT(Long id){
        return statusRepository.findAllByIdT(id);
    }

    public Status addStatus(Status status) { return statusRepository.save(status);}
}
