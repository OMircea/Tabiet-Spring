package com.tabiet.tabiet.repositories;

import com.tabiet.tabiet.TabietApplication;
import com.tabiet.tabiet.models.Tabiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TabietRepository extends JpaRepository<Tabiet, Long>{

    List<Tabiet> findAll();
    List<Tabiet> findAllByUsername(String username);
    Tabiet findTabietById(Long id);
}
