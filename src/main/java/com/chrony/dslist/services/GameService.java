package com.chrony.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chrony.dslist.dto.GameDTO;
import com.chrony.dslist.dto.GameMinDTO;
import com.chrony.dslist.entities.Game;
import com.chrony.dslist.projections.GameMinProjection;
import com.chrony.dslist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // Sem operacao de escrita
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id).get();

        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();

        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);

        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
