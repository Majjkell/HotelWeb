package hotel.controller;

import hotel.model.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservationController {



    @RequestMapping("/wybor_pokoju")
    public String wybor_pokoju(Reservation reservation){







        return "redirect:/";
    }
}
