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
                        new Room(null, "1", "Sea View Garden Standard", "Sea View Garden Standard"),
                        // duplicate "1" kaldırıldı — eğer iki aynı roomNumber istiyorsan tekrar ekleyebilirsin
                        new Room(null, "2", "Sea View Garden Suit", "Sea View Garden Suit"),
                        new Room(null, "3", "Sea View Garden Suit", "Sea View Garden Suit"),
                        new Room(null, "4", "Sea View Suit", "Sea View Suit"),
                        new Room(null, "5", "Sea View Standard", "Sea View Standard"),
                        new Room(null, "6", "Sea View Standard", "Sea View Standard"),
                        new Room(null, "7", "Sea View Jacuzzi Suit", "Sea View Jacuzzi Suit"),
                        new Room(null, "8", "Sea View Suit", "Sea View Suit"),
                        new Room(null, "9", "Sea View Roof Suit", "Sea View Roof Suit"),
                        new Room(null, "10", "Sea View Roof Standard", "Sea View Roof Standard"),
                        new Room(null, "11", "Sea View Roof Standard", "Sea View Roof Standard"),
                        new Room(null, "12", "Sea View Roof Jacuzzi Suit", "Sea View Roof Jacuzzi Suit"),
                        new Room(null, "13", "Sea View Roof Suit", "Sea View Roof Suit"),
                        new Room(null, "Loft 1", "Loft Suit", "Loft Suit"),
                        new Room(null, "Loft 2", "Loft Suit", "Loft Suit"),
                        new Room(null, "Loft 3", "Loft Suit", "Loft Suit"),
                        new Room(null, "Loft 4", "Loft Suit", "Loft Suit"),
                        new Room(null, "Loft 5", "Loft Suit", "Loft Suit"),
                        new Room(null, "Loft 6", "Loft Suit", "Loft Suit")
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

