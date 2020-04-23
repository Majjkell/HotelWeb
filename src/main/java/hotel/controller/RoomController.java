package hotel.controller;

import hotel.model.Reservation;
import hotel.model.Room;
import hotel.repository.RoomRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository){
        this.roomRepository = roomRepository;
    }


    @RequestMapping("/rooms")
    public String rooms(HttpSession httpSession,Model model){
//        Reservation reservation = (Reservation) httpSession.getAttribute("reservation");
//        if (reservation==null){
//            reservation = new Reservation();
//            httpSession.setAttribute("reservation",reservation);
//        }
//        List<String> typelist = (List<String>) httpSession.getAttribute("type");
        if(httpSession.getAttribute("type")==null){
            List<String> typelist = new ArrayList<>();
            typelist.add("classic");
            typelist.add("Comfort");
            typelist.add("premium");
            httpSession.setAttribute("type",typelist);
        }
        Reservation reservation = new Reservation();
//        List<String> typelist = new ArrayList<>();
//        typelist.add("classic");
//        typelist.add("Comfort");
//        typelist.add("premium");
        model.addAttribute("reservation",reservation);
//        model.addAttribute("type",typelist);



//        List<Room> roomss = (List<Room>) httpSession.getAttribute("rooms1");
//        if(roomss==null){
//            roomss = roomRepository.findRoomsByType_room("test");
//            httpSession.setAttribute("rooms1",roomss);
//            httpSession.setAttribute("reservation",reservation);
//            httpSession.setAttribute("type",typelist);
//        }
        return "rooms";
    }


}
