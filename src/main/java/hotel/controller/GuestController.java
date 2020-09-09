package hotel.controller;

import hotel.model.Guest;
import hotel.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

@Controller
public class GuestController {
    private final GuestRepository guestRepository;

    @Autowired
    private GuestController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping("/register")
    public String register(Model model) {
        // EN| Creating a Guest object and adding it to the model to map the object in the form
        // PL| Stworzenie obiektu Gościa i dodanie go do modelu w celu zmapowania obiektu w formularzu
        Guest guest = new Guest();
        model.addAttribute("guest", guest);
        return "register";
    }
    
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String saveregister(Guest guest) {
        // EN| Retrieving the mapped guest object and saving it to the database
        // PL| Pobranie zmapowanego obiektu gościa i zapisanie go do bazy danych
        guestRepository.save(guest);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String loginin(HttpSession httpSession, @RequestParam String firstName,@RequestParam String password){
        // EN| Getting from the database the guest object matching the given data
        // PL| Pobranie z bazy danych obiektu gościa pasującego do podanych danych
        Guest guest = guestRepository.findFirstByFirstNameAndPassword(firstName,password);
        httpSession.setAttribute("guest",guest);
        return "redirect:/";
    }
}
