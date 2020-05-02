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
    public ReservationController(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, BusyRepsository busyRepsository) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.busyRepsository = busyRepsository;
    }


    @RequestMapping("/roomChoose")
    public String roomChoose(Reservation reservation, HttpSession httpSession) {
        Guest guest = (Guest) httpSession.getAttribute("guest");
        if (guest == null) {
            return "redirect:login";
        }
        httpSession.removeAttribute("rooms");
        List<Room> roomList1 = (List<Room>) httpSession.getAttribute("rooms1");
        if (roomList1 != null) {
            httpSession.removeAttribute("rooms1");
        }
        int numOfPpl = reservation.getNumOfPpl();
        Date dateFrom = reservation.getDateFrom();
        Date dateTo = reservation.getDateTo();
        String typeRoom = reservation.getRoomType();
        List<Room> rooms = roomRepository.findRoomsByTypeRoomAndNumOfPpl(numOfPpl, typeRoom);
        try {
            for (Room r : rooms) {
                for (Busy b : r.getBusies()) {
                    if (dateFrom.compareTo(b.getDateFrom()) == 0 || dateFrom.compareTo(b.getDateTo())==0) {
                        rooms.remove(r);
                    }
                    if (dateTo.compareTo(b.getDateTo()) == 0 || dateTo.compareTo(b.getDateFrom()) == 0) {
                        rooms.remove(r);
                    }
                    if (dateTo.compareTo(b.getDateTo()) < 0 && dateTo.compareTo(b.getDateFrom()) > 0) {
                        rooms.remove(r);
                    }
                    if (dateFrom.compareTo(b.getDateTo()) < 0 && dateFrom.compareTo(b.getDateFrom()) > 0) {
                        rooms.remove(r);
                    }
                    if (dateFrom.compareTo(b.getDateFrom()) < 0 && dateTo.compareTo(b.getDateTo()) > 0) {
                        rooms.remove(r);
                    }
                }
            }
        } catch (java.util.ConcurrentModificationException e) {
            System.out.println(e.getStackTrace());
        }

        httpSession.setAttribute("rooms", rooms);
        httpSession.setAttribute("reservation", reservation);
        return "rooms";
    }

    @RequestMapping(value = "/reservation/{numberOfRoom}")
    public String reservation(@PathVariable int numberOfRoom, HttpSession httpSession) {
        Guest guest = (Guest) httpSession.getAttribute("guest");
        if (guest == null) {
            return "redirect:login";
        }
        Room room = roomRepository.findFirstByNumberOfRoom(numberOfRoom);
        Reservation reservation = (Reservation) httpSession.getAttribute("reservation");


        Busy busy = new Busy();
        busy.setDateFrom(reservation.getDateFrom());
        busy.setDateTo(reservation.getDateTo());
        busy.setRoom(room);

        List<Busy> busies = room.getBusies();
        busies.add(busy);
        room.setBusies(busies);

        List<Reservation> reservations = new ArrayList<>();
//        if(reservations==null){
//            reservations = new ArrayList<>();
//        }
        reservations.add(reservation);

        List<Guest> guests = reservation.getGuest();
        if (guests == null) {
            guests = new ArrayList<>();
        }

        guests.add(guest);
        reservation.setGuest(guests);
        reservation.setRoom(room);
        List<Reservation> reservationList = guest.getReservation();
        if (reservationList == null) {
            reservationList = new ArrayList<>();
        }
        reservationList.add(reservation);
        httpSession.setAttribute("reservation", reservation);
        httpSession.setAttribute("busy", busy);
        httpSession.setAttribute("room", room);
        httpSession.setAttribute("guest", guest);
        return "reservation";
    }

    @GetMapping("/submit")
    public String submit(HttpSession httpSession, @RequestParam String addInfo) {
        Reservation reservation = (Reservation) httpSession.getAttribute("reservation");

        reservation.setAddInfo(addInfo);
        Guest guest = (Guest) httpSession.getAttribute("guest");
        Busy busy = (Busy) httpSession.getAttribute("busy");
        Room room = (Room) httpSession.getAttribute("room");


        reservationRepository.save(reservation);
        busyRepsository.save(busy);
        roomRepository.save(room);
        guestRepository.save(guest);

        return "redirect:/";
    }


    @GetMapping("/myReservations")
    public String myReservations(HttpSession httpSession) {
        Guest guest = (Guest) httpSession.getAttribute("guest");
        if (guest == null) {
            return "redirect:/login";
        }
        System.out.println(guest.toString());
        List<Reservation> myReservations = guest.getReservation();
        httpSession.setAttribute("myReservations", myReservations);
        System.out.println(myReservations.size());
        return "myReservations";
    }
}












