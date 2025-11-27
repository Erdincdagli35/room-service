package com.edsoft.room_management_system.controller;

import com.edsoft.room_management_system.model.Room;
import com.edsoft.room_management_system.service.RoomService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@CrossOrigin({"https://roomservice.up.railway.app", "http://localhost:8080"})
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/list/all")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }
}