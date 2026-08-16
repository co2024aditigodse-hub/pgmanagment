package com.example.pgf.repository;

import com.example.pgf.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByAvailable(Boolean available);

    List<Room> findByRoomType(String roomType);

}