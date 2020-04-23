package hotel.controller;

import hotel.model.Busy;
import hotel.model.Guest;
import hotel.model.Reservation;
import hotel.model.Room;
import hotel.repository.GuestRepository;
import hotel.repository.ReservationRepository;
import hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationController(RoomRepository roomRepository,GuestRepository guestRepository, ReservationRepository reservationRepository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
    }


    @RequestMapping("/wybor_pokoju")
    public String wybor_pokoju(Reservation reservation, HttpSession httpSession) {
        List<Room> roomList1 = (List<Room>) httpSession.getAttribute("rooms1");
        if(roomList1!=null){
            httpSession.removeAttribute("rooms1");
        }
        int num_of_ppl = reservation.getNum_of_ppl();
        Date date_from = reservation.getDate_from();
        Date date_to = reservation.getDate_to();
        String type_room = reservation.getRoom_type();
        List<Room> rooms = roomRepository.findRoomsByType_roomAndNum_of_ppl(num_of_ppl, type_room);
        for (Room r : rooms) {

            if (!r.getBusies().isEmpty()){
                for (Busy b : r.getBusies()) {
                    if (date_from.compareTo(b.getDate_from()) == 0 && date_from.compareTo(b.getDate_to()) == 0 && date_to.compareTo(b.getDate_to()) == 0 && date_to.compareTo(b.getDate_from()) == 0 &&
                            date_from.compareTo(b.getDate_from()) > 0 && date_from.compareTo(b.getDate_to()) < 0 && date_to.compareTo(b.getDate_from()) > 0 && date_to.compareTo(b.getDate_to()) < 0) {
                        rooms.remove(r);
                    }
                }
            }
        }
        System.out.println(rooms);
        httpSession.setAttribute("rooms",rooms);
        httpSession.setAttribute("reservation",reservation);
        return "rooms";
    }

    @RequestMapping(value = "/reservation/{number}")
    public String reserv(@PathVariable int number,HttpSession httpSession){
//        int number1 = Integer.parseInt(number);
        Room room = roomRepository.findRoomByNumber(number);
        Reservation reservation = (Reservation) httpSession.getAttribute("reservation");
        Guest guest = guestRepository.findByOnline(1);

        //busy polaczenie z room
        Busy busy = new Busy();
        busy.setDate_from(reservation.getDate_from());
        busy.setDate_to(reservation.getDate_to());
        busy.setRoom(room);
        List<Busy> busies = room.getBusies();
        busies.add(busy);
        room.setBusies(busies);

        reservation.setGuest(guest);
        reservation.setRoom(room);
        System.out.println(reservation.toString());

        return "reservation";
    }
    @GetMapping("/submit")
    public String submit(HttpSession httpSession){
        Reservation reservation =(Reservation) httpSession.getAttribute("reservation");
//        reservation.setAdd_info(add_info);
        reservationRepository.save(reservation);
        return "index";
    }

}












