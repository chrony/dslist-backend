package com.chrony.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chrony.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
