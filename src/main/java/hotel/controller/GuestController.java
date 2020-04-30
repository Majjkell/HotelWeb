package hotel.controller;

import hotel.model.Guest;
import hotel.repository.GuestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.servlet.http.HttpSession;

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

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginin(HttpSession httpSession, @RequestParam String firstName,@RequestParam String password){
        Guest guest = guestRepository.findFirstByFirstNameAndPassword(firstName,password);
        httpSession.setAttribute("guest",guest);
        return "redirect:/";
    }
}
