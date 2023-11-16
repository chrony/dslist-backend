package com.chrony.dslist.projections;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getGameYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
