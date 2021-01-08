package com.tabiet.tabiet.repositories;

import com.tabiet.tabiet.models.Tabiet_Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Tabiet_BadgeRepository extends JpaRepository<Tabiet_Badge, Long> {

    List<Tabiet_Badge> findAllByIdt(Long idt);
    List<Tabiet_Badge> findAllByIdb(Long idb);
}
