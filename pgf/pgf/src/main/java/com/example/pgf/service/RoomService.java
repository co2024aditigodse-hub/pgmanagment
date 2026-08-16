package com.example.pgf.service;

import com.example.pgf.dto.RoomDto;

import java.util.List;

public interface RoomService {

    RoomDto saveRoom(RoomDto roomDto);

    RoomDto updateRoom(Long id, RoomDto roomDto);

    RoomDto getRoomById(Long id);

    List<RoomDto> getAllRooms();

    void deleteRoom(Long id);

}