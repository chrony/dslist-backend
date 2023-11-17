package com.chrony.dslist.dto;

public class ReplacementDTO {
    private Integer sourceIndex;
    private Integer destinationIndex;

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(final Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
    }

    public void setDestinationIndex(final Integer destinationIndex) {
        this.destinationIndex = destinationIndex;
    }
}
