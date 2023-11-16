package com.chrony.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chrony.dslist.dto.GameDTO;
import com.chrony.dslist.dto.GameListDTO;
import com.chrony.dslist.dto.GameMinDTO;
import com.chrony.dslist.entities.Game;
import com.chrony.dslist.entities.GameList;
import com.chrony.dslist.repositories.GameListRepository;
import com.chrony.dslist.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
