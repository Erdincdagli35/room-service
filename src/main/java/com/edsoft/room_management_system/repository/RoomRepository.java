package com.edsoft.room_management_system.repository;

import com.edsoft.room_management_system.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomRepository extends MongoRepository<Room, String> {
    List<Room> findAllByOrderById();
}
