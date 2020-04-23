package hotel.controller;

import hotel.model.Guest;
import hotel.repository.GuestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Controller
public class GuestController {
    private final Logger logger = LoggerFactory.getLogger(GuestController.class);
    private final GuestRepository guestRepository;

    @Autowired
    private GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {
        Guest guest = new Guest();
        model.addAttribute("guest", guest);
        return "register";
    }


    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String saveregister(Guest guest) {
        guestRepository.save(guest);
        return "redirect:/";
    }
}
