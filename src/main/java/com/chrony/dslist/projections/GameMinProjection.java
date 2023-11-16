package com.chrony.dslist.projections;

import jakarta.persistence.criteria.CriteriaBuilder.In;

public interface GameMinProjection {

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
