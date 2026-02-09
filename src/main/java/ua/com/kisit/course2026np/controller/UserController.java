package ua.com.kisit.course2026np.controller;

import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.com.kisit.course2026np.entity.Clients;
import ua.com.kisit.course2026np.entity.Roles;
import ua.com.kisit.course2026np.entity.Users;
import ua.com.kisit.course2026np.service.ClientsService;
import ua.com.kisit.course2026np.service.UserService;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ClientsService clientService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model,
                               @RequestParam(name = "message", defaultValue = " ") String message) {

        model.addAttribute("users", new Users());
        model.addAttribute("clients", new Clients());
        model.addAttribute("info", message);

        return "registration";
    }


    @PostMapping("/registration")
    public String saveNewUserToDB(@Valid Users user,
                                  BindingResult bindingResult1,
                                  @Valid Clients client,
                                  BindingResult bindingResult2,
                                  RedirectAttributes redirectAttributes
                                  ) {

        // Перевірка на логін
        if(userService.getUserFromDB(user.getUsername())){
            redirectAttributes.addAttribute("message", "User already exists");
            return "redirect:/registration";
        }

        if (bindingResult1.hasErrors()) {
            return "registration";
        }

        if (bindingResult2.hasErrors()) {
            return "registration";
        }

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        Users userById = userService.saveNewUser(user);

        userById.setRoles(Collections.singleton(new Roles(1L, "ROLE_user")));
        client.setUser(userById);

        clientService.saveNewClient(client);

        return "redirect:/login";
    }

}
