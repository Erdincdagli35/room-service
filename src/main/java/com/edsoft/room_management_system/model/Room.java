package com.edsoft.room_management_system.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rooms")
public class Room {
    @Id
    private String id;
    private String roomNo;
    private String description;

    // No-arg constructor (Mongo için gerekebilir)
    public Room() {}

    // id içeren constructor (DataLoader'da kullandığın şekil için)
    public Room(String id, String roomNo, String description) {
        this.id = id;
        this.roomNo = roomNo;
        this.description = description;
    }

    // name-description constructor (istersen bunu kullan)
    public Room(String name, String description) {
        this.description = description;
    }

    // Getters / Setters (veya Lombok @Data kullan)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
