package com.edsoft.room_management_system.data;

import com.edsoft.room_management_system.model.Room;
import com.edsoft.room_management_system.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private final RoomRepository roomRepository;

    public DataLoader(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(roomRepository.count() == 0) {
            roomRepository.saveAll(List.of(
                    new Room("1", "Sea View Garden Standard"),
                    new Room("2", "Sea View Garden Suit"),
                    new Room("3", "Sea View Garden Suit"),

                    new Room("4", "Sea View Suit"),
                    new Room("5", "Sea View Standard"),
                    new Room("6", "Sea View Standard"),
                    new Room("7", "Sea View Jacuzzi Suit"),
                    new Room("8", "Sea View Suit"),

                    new Room("9", "Sea View Roof Suit"),
                    new Room("10", "Sea View Roof Standard"),
                    new Room("11", "Sea View Roof Standard"),
                    new Room("12", "Sea View Roof Jacuzzi Suit"),
                    new Room("13", "Sea View Roof Suit"),


                    new Room("Loft 1", "Loft Suit"),
                    new Room("Loft 2", "Loft Suit"),
                    new Room("Loft 3", "Loft Suit"),
                    new Room("Loft 4", "Loft Suit"),
                    new Room("Loft 5", "Loft Suit"),
                    new Room("Loft 6", "Loft Suit")
            ));
            System.out.println("Sample rooms created!");
        }
    }
}
