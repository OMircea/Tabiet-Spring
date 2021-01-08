package com.tabiet.tabiet.repositories;

import com.tabiet.tabiet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    List<User> findAll();
    User findByUsername(String username);


}
