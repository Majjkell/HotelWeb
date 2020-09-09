package hotel.controller;

import hotel.model.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {


    @RequestMapping("/rooms")
    public String rooms(HttpSession httpSession,Model model){
        // EN| If not exist creates a list of room types and sets them in the session attribute
        // PL| Jeżeli nie istnieje tworzy liste typów pokoi i ustawia je w atrybucie sesji
        if(httpSession.getAttribute("type")==null){
            List<String> typelist = new ArrayList<>();
            typelist.add("Classic");
            typelist.add("Comfort");
            typelist.add("Premium");
            httpSession.setAttribute("type",typelist);
        }
        // EN| Create Reservation and add it to the model
        // PL| Tworzy Rezerwacje i dodaje ją do modelu
        Reservation reservation = new Reservation();
        model.addAttribute("reservation",reservation);
        return "rooms";
    }


}
