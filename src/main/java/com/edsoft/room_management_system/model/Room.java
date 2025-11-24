package com.edsoft.room_management_system.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rooms")
public class Room {
    @Id
    private String id;
    private String name;
    private String description;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }
}