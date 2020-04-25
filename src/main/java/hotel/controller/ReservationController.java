package hotel.controller;

import hotel.model.Busy;
import hotel.model.Guest;
import hotel.model.Reservation;
import hotel.model.Room;
import hotel.repository.BusyRepsository;
import hotel.repository.GuestRepository;
import hotel.repository.ReservationRepository;
import hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReservationController {
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final BusyRepsository busyRepsository;

    @Autowired
    public ReservationController(RoomRepository roomRepository,GuestRepository guestRepository, ReservationRepository reservationRepository, BusyRepsository busyRepsository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.busyRepsository = busyRepsository;
    }


    @RequestMapping("/roomChoose")
    public String roomChoose(Reservation reservation, HttpSession httpSession) {
        List<Room> roomList1 = (List<Room>) httpSession.getAttribute("rooms1");
        if(roomList1!=null){
            httpSession.removeAttribute("rooms1");
        }
        int numOfPpl = reservation.getNumOfPpl();
        Date dateFrom = reservation.getDateFrom();
        Date dateTo = reservation.getDateTo();
        String typeRoom = reservation.getRoomType();
        List<Room> rooms = roomRepository.findRoomsByTypeRoomAndNumOfPpl(numOfPpl, typeRoom);
        System.out.println(reservation.toString());
        for (Room r : rooms) {
            if (!r.getBusies().isEmpty()){
                for (Busy b : r.getBusies()) {
                    if (dateFrom.compareTo(b.getDateFrom()) == 0 && dateFrom.compareTo(b.getDateTo()) == 0 && dateTo.compareTo(b.getDateTo()) == 0 && dateTo.compareTo(b.getDateFrom()) == 0 &&
                            dateFrom.compareTo(b.getDateFrom()) > 0 && dateFrom.compareTo(b.getDateTo()) < 0 && dateTo.compareTo(b.getDateFrom()) > 0 && dateTo.compareTo(b.getDateTo()) < 0) {
                        rooms.remove(r);
                    }
                }
            }
        }

        httpSession.setAttribute("rooms",rooms);
        httpSession.setAttribute("reservation",reservation);
        return "rooms";
    }

    @RequestMapping(value = "/reservation/{number}")
    public String reservation(@PathVariable int number,HttpSession httpSession){
        Room room = roomRepository.findFirstByNumberOfRoom(number);
        Reservation reservation = (Reservation) httpSession.getAttribute("reservation");
        Guest guest = guestRepository.findFirstByOnline(1);

        Busy busy = new Busy();
        busy.setDateFrom(reservation.getDateFrom());
        busy.setDateTo(reservation.getDateTo());
        busy.setRoom(room);

        List<Busy> busies = room.getBusies();
        busies.add(busy);
        room.setBusies(busies);

        List<Reservation> reservations = guest.getReservation();
        reservations.add(reservation);

        List<Guest> guests = reservation.getGuest();
        if(guests==null){
            guests = new ArrayList<>();
        }

        guests.add(guest);
        reservation.setGuest(guests);
        reservation.setRoom(room);

        httpSession.setAttribute("reservation",reservation);
        httpSession.setAttribute("busy",busy);
        httpSession.setAttribute("room",room);
        httpSession.setAttribute("guest",guest);
        return "reservation";
    }
    @GetMapping("/submit")
    public String submit(HttpSession httpSession,@RequestParam String add_info){
        Reservation reservation =(Reservation) httpSession.getAttribute("reservation");

        reservation.setAddInfo(add_info);
        Guest guest = (Guest) httpSession.getAttribute("guest");
        Busy busy = (Busy) httpSession.getAttribute("busy");
        Room room = (Room) httpSession.getAttribute("room");
        reservationRepository.save(reservation);
        busyRepsository.save(busy);
        roomRepository.save(room);
        guestRepository.save(guest);

        return "redirect:/";
    }

}












