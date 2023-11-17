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
import com.chrony.dslist.projections.GameMinProjection;
import com.chrony.dslist.repositories.GameListRepository;
import com.chrony.dslist.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

//        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int min = Math.min(sourceIndex, destinationIndex);
//        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
