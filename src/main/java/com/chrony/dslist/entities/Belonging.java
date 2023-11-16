package com.chrony.dslist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK();

    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game, GameList list, final Integer position) {
        id.setGame(game);
        id.setList(list);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(final BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(final Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final Belonging belonging)) {
            return false;
        }
        return Objects.equals(id, belonging.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
