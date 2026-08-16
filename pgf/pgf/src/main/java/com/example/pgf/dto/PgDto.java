package com.example.pgf.dto;

public class PgDto {

    private Long id;
    private String pgName;
    private String ownerName;
    private String city;
    private Integer totalRooms;
    private Integer availableRooms;

    public PgDto() {
    }

    public PgDto(Long id, String pgName, String ownerName,
                 String city, Integer totalRooms, Integer availableRooms) {
        this.id = id;
        this.pgName = pgName;
        this.ownerName = ownerName;
        this.city = city;
        this.totalRooms = totalRooms;
        this.availableRooms = availableRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPgName() {
        return pgName;
    }

    public void setPgName(String pgName) {
        this.pgName = pgName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getTotalRooms() {
        return totalRooms;
    }

    public void setTotalRooms(Integer totalRooms) {
        this.totalRooms = totalRooms;
    }

    public Integer getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(Integer availableRooms) {
        this.availableRooms = availableRooms;
    }
}