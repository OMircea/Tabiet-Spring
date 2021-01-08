package com.tabiet.tabiet.repositories;


import com.tabiet.tabiet.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    List<Status> findAllByIdT(Long id);
}
