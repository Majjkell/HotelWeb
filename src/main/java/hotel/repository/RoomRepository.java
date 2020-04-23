package hotel.repository;

import hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {


//    @Query(value = "SELECT * FROM rooms AS r WHERE  r.num_of_ppl =: num_of_ppl AND r.type_room =: type_room")
//    List<Room> findAllByRoomsByType_roomAndNum_of_ppl(@Param("num_of_ppl")int num_of_ppl,@Param("type_room")String type_room);

    @Query(value = "SELECT r FROM Room AS r WHERE  r.num_of_ppl = ?1 AND r.type_room = ?2")
    List<Room> findRoomsByType_roomAndNum_of_ppl(int num_of_ppl,String type_room);

    @Query(value = "SELECT r FROM Room AS r WHERE r.type_room =: test")
    List<Room> findRoomsByType_room(@Param("test")String test);

    Room findFirstRoomByNumber(int number);

}
