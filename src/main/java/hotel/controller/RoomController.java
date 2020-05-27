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
        if(httpSession.getAttribute("type")==null){
            List<String> typelist = new ArrayList<>();
            typelist.add("Classic");
            typelist.add("Comfort");
            typelist.add("Premium");
            httpSession.setAttribute("type",typelist);
        }

        Reservation reservation = new Reservation();
        model.addAttribute("reservation",reservation);
        return "rooms";
    }


}
