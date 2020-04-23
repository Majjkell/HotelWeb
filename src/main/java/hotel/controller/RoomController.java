package hotel.controller;

import hotel.model.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RoomController {



    @RequestMapping("/rooms")
    public String rooms(Model model){
        List<String> typelist = new ArrayList<>();
        typelist.add("classic");
        typelist.add("Comfort");
        typelist.add("premium");
        model.addAttribute("type",typelist);
        Reservation reservation = new Reservation();
        model.addAttribute("reservation",reservation);
        return "rooms";
    }


}
