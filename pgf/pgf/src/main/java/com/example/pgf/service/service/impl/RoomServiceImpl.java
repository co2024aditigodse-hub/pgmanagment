package com.example.pgf.service.service.impl;

import com.example.pgf.dto.RoomDto;
import com.example.pgf.entity.Pg;
import com.example.pgf.entity.Room;
import com.example.pgf.repository.PgRepository;
import com.example.pgf.repository.RoomRepository;
import com.example.pgf.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PgRepository pgRepository;

    @Override
    public RoomDto saveRoom(RoomDto roomDto) {

        Pg pg = pgRepository.findById(roomDto.getPgId())
                .orElseThrow(() -> new RuntimeException("PG Not Found"));

        Room room = new Room();

        room.setRoomNumber(roomDto.getRoomNumber());
        room.setRoomType(roomDto.getRoomType());
        room.setCapacity(roomDto.getCapacity());
        room.setOccupiedBeds(roomDto.getOccupiedBeds());
        room.setRent(roomDto.getRent());
        room.setAvailable(roomDto.getAvailable());
        room.setPg(pg);

        return convertToDto(roomRepository.save(room));
    }

    @Override
    public RoomDto updateRoom(Long id, RoomDto roomDto) {

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room Not Found"));

        room.setRoomNumber(roomDto.getRoomNumber());
        room.setRoomType(roomDto.getRoomType());
        room.setCapacity(roomDto.getCapacity());
        room.setOccupiedBeds(roomDto.getOccupiedBeds());
        room.setRent(roomDto.getRent());
        room.setAvailable(roomDto.getAvailable());

        return convertToDto(roomRepository.save(room));
    }

    @Override
    public RoomDto getRoomById(Long id) {

        return convertToDto(roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room Not Found")));
    }

    @Override
    public List<RoomDto> getAllRooms() {

        List<RoomDto> list = new ArrayList<>();

        for (Room room : roomRepository.findAll()) {
            list.add(convertToDto(room));
        }

        return list;
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    private RoomDto convertToDto(Room room) {

        RoomDto dto = new RoomDto();

        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setRoomType(room.getRoomType());
        dto.setCapacity(room.getCapacity());
        dto.setOccupiedBeds(room.getOccupiedBeds());
        dto.setRent(room.getRent());
        dto.setAvailable(room.getAvailable());

        if (room.getPg() != null) {
            dto.setPgId(room.getPg().getId());
        }

        return dto;
    }
}