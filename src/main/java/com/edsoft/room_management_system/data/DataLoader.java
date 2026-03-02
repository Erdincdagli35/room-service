package com.edsoft.room_management_system.data;

import com.edsoft.room_management_system.model.Room;
import com.edsoft.room_management_system.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("!prod") // istersen sadece prod dışı çalışsın; prod'da otomatik data yüklemesin
public class DataLoader implements CommandLineRunner {

    private final RoomRepository roomRepository;

    @Value("${app.init-sample-data:true}")
    private boolean initSampleData;

    public DataLoader(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public void run(String... args) {
        if (!initSampleData) {
            System.out.println("Sample data initialization skipped (app.init-sample-data=false).");
            return;
        }

        try {
            long count = roomRepository.count();
            if (count == 0) {
                List<Room> rooms = List.of(
                        new Room("1", "Bahçe 1", "Sea View Garden Standard"),
                        new Room("2", "Bahçe 2", "Sea View Garden Suit"),
                        new Room("3", "Bahçe 3", "Sea View Garden Suit"),
                        new Room("4", "4", "Sea View Suit"),
                        new Room("5", "5", "Sea View Standard"),
                        new Room("6", "6", "Sea View Standard"),
                        new Room("7", "7", "Sea View Jacuzzi Suit"),
                        new Room("8", "8", "Sea View Suit"),
                        new Room("9", "9", "Sea View Roof Suit"),
                        new Room("10", "10", "Sea View Roof Standard"),
                        new Room("11", "11", "Sea View Roof Standard"),
                        new Room("12", "12", "Sea View Roof Jacuzzi Suit"),
                        new Room("13", "13", "Sea View Roof Suit"),
                        new Room("14", "Loft 1", "Loft Suit"),
                        new Room("15", "Loft 2", "Loft Suit"),
                        new Room("16", "Loft 3", "Loft Suit"),
                        new Room("17", "Loft 4", "Loft Suit"),
                        new Room("18", "Loft 5", "Loft Suit"),
                        new Room("19", "Loft 6", "Loft Suit")
                );

                List<Room> saved = roomRepository.saveAll(rooms);
                System.out.println("Sample rooms created! Saved size = " + saved.size());
                System.out.println("ED : -> After saveAll, count = " + roomRepository.count());
            } else {
                System.out.println("Rooms already exist: count = " + count);
            }
        } catch (Exception ex) {
            System.err.println("Could not initialize sample data — skipping. Reason: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

