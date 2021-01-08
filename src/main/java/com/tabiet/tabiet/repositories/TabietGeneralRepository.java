package com.tabiet.tabiet.repositories;

import com.tabiet.tabiet.models.Tabiet;
import com.tabiet.tabiet.models.TabietGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TabietGeneralRepository extends JpaRepository<TabietGeneral, Long> {

    List<TabietGeneral> findAll();

}
