package hotel.repository;

import hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    @Query(value = "SELECT * FROM rooms AS r WHERE  r.type = :type AND r.num_of_ppl = :num_of_ppl")
    List<Room> findRoomsByTypeAndBusyQuery(@Param("type") String type,@Param("num_of_ppl") int num_of_ppl);
}
