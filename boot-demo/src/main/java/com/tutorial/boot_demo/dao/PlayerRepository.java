package com.tutorial.boot_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //表明下述代码为Repository层代码
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findByEmail(String email);
}
