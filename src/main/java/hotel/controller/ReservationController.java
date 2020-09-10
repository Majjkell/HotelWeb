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
        // EN| Check if user is logged in if not redirect to the logging page
        // PL| Sprawdza czy użytkownik jest zalogowany : ? przekierowuje na stronę logowania
        Guest guest = (Guest) httpSession.getAttribute("guest");
        if (guest == null) {
            return "redirect:login";
        }

        /*httpSession.removeAttribute("rooms");
        List<Room> roomList1 = (List<Room>) httpSession.getAttribute("rooms1");
        if (roomList1 != null) {
            httpSession.removeAttribute("rooms1");
        }*/

        // EN| Retrieving information from form about reservation
        // PL| Pobiera informacje z formularza dotyczące rezerwacji
        int numOfPpl = reservation.getNumOfPpl();
        Date dateFrom = reservation.getDateFrom();
        Date dateTo = reservation.getDateTo();
        String typeRoom = reservation.getRoomType();

        // EN| Getting rooms matching the given information from the database. Then it checks the availability of those rooms.
        // PL| Pobiera z bazy danych pokoje zgadzające się z podanymi informacjami. Następnie sprawdza dostępność tych że pokoi.
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
        // EN| Check if user is logged in if not redirect to the logging page
        // PL| Sprawdza czy użytkownik jest zalogowany : ? przekierowuje na stronę logowania
        Guest guest = (Guest) httpSession.getAttribute("guest");
        if (guest == null) {
            return "redirect:login";
        }

        // EN| Getting room from data base by 'number of this room' (every room has unique number)
        // PL| Pobiera pokój po numerze (każdy pokój ma unikalny numer)
        Room room = roomRepository.findFirstByNumberOfRoom(numberOfRoom);

        // EN| Retriveing from session reservation
        // PL| Pobiera z sesji rezerwacje
        Reservation reservation = (Reservation) httpSession.getAttribute("reservation");

        // EN| Creates new object 'Busy'
        // PL| Tworzy nowy obiekt 'Busy'
        Busy busy = new Busy();

        // EN| Getting informations from reservations and put them in 'Busy'
        // PL| Pobiera informacje z rezerwacji i dodaje je do  'Busy'
        busy.setDateFrom(reservation.getDateFrom());
        busy.setDateTo(reservation.getDateTo());

        // EN| Adds previously retrieved room to 'Busy'
        // PL| Dodaje wcześniej pobrany pokój do 'Busy'
        busy.setRoom(room);

        // EN| Getting list 'Busies' from room and adds another 'Busy'
        // PL| Pobiera listę 'Busies' pokoju i dodaje do niej nowo utworzony 'Busy'
        List<Busy> busies = room.getBusies();
        busies.add(busy);
        room.setBusies(busies);

        // EN| Creates list of reservations and adds reservation to the list
        // PL| Tworzy listę rezerwacji i dodaje do nich stworzoną rezerwacje
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation);

        // EN| Getting lists of guests from reserwation if not exist creates it
        // PL| Pobiera listę gości z rezerwacji a jak nie ma to tworzy
        List<Guest> guests = reservation.getGuest();
        if (guests == null) {
            guests = new ArrayList<>();
        }

        // EN|
        // PL|
        guests.add(guest);
        reservation.setGuest(guests);
        reservation.setRoom(room);
        List<Reservation> reservationList = guest.getReservation();
        if (reservationList == null) {
            reservationList = new ArrayList<>();
        }
        reservationList.add(reservation);

        // EN| Set session attributes
        // PL| Ustawia atrybuty do sesji
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
        List<Reservation> myReservations = guest.getReservation();
        httpSession.setAttribute("myReservations", myReservations);
        return "myReservations";
    }
}












