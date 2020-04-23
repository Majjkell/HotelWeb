package hotel.controller;

import hotel.model.Busy;
import hotel.model.Reservation;
import hotel.model.Room;
import hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {
    private RoomRepository roomRepository;

    @Autowired
    public ReservationController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }


    @RequestMapping("/wybor_pokoju")
    @ResponseBody
    public String wybor_pokoju(Reservation reservation) {
        int num_of_ppl = reservation.getNum_of_ppl();
        Date date_from = reservation.getDate_from();
        Date date_to = reservation.getDate_to();
        String type = reservation.getRoom_type();
        List<Room> rooms = roomRepository.findRoomsByTypeAndBusyQuery(type, num_of_ppl);
        for (Room r : rooms) {
            for (Busy b : r.getBusies()) {
                if (date_from.compareTo(b.getDate_from()) == 0 && date_from.compareTo(b.getDate_to()) == 0 && date_to.compareTo(b.getDate_to()) == 0 && date_to.compareTo(b.getDate_from()) == 0 &&
                        date_from.compareTo(b.getDate_from()) > 0 && date_from.compareTo(b.getDate_to()) < 0 && date_to.compareTo(b.getDate_from()) > 0 && date_to.compareTo(b.getDate_to()) < 0) {
                    rooms.remove(r);
                }
            }
        }


        return rooms.toString();
    }
}
