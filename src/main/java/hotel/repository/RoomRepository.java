package hotel.repository;

import hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    @Query(value = "SELECT r FROM Room AS r WHERE  r.numOfPpl = ?1 AND r.typeRoom = ?2")
    List<Room> findRoomsByTypeRoomAndNumOfPpl(int numOfPpl,String typeRoom);

    @Query(value = "SELECT r FROM Room AS r WHERE r.typeRoom =: test")
    List<Room> findRoomsByType_room(@Param("test")String test);

    Room findFirstByNumberOfRoom(int number);

}
