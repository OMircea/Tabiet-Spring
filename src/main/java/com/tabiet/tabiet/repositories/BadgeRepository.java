package com.tabiet.tabiet.repositories;

import com.tabiet.tabiet.models.Badge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {

    List<Badge> findAll();

    Badge findBadgeById(Long id);
}
