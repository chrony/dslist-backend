package com.chrony.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelongingPK {

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

    public BelongingPK() {
    }

    public BelongingPK(final Game game, final GameList list) {
        this.game = game;
        this.list = list;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(final Game game) {
        this.game = game;
    }

    public GameList getList() {
        return list;
    }

    public void setList(final GameList list) {
        this.list = list;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final BelongingPK that)) {
            return false;
        }
        return Objects.equals(game, that.game) && Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game, list);
    }
}
