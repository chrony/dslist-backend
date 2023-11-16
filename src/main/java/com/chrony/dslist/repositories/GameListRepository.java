package com.chrony.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chrony.dslist.entities.Game;
import com.chrony.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
