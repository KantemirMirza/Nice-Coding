package com.example.nicecoding.security.controller;

import com.example.nicecoding.security.model.KullaniciDTO;
import com.example.nicecoding.security.service.KullaniciService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class KullaniciController {

    private final KullaniciService kullaniciService;

    @GetMapping("/login")
    public String login(){
        return "security/login";
    }

    @GetMapping("/register")
    public String getRegister(){
        return "security/register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute KullaniciDTO kullaniciDTO){
        kullaniciService.saveKullanici(kullaniciDTO);
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String listOfUser(Model model) {
        model.addAttribute("listOfUser", kullaniciService.listOfKullanici());
        return "security/listOfUser";
    }


    //private final RoleService roleService;


//    @GetMapping("/security/user/{op}/{id}")
//    public String editUser(@PathVariable Integer id, @PathVariable String op, Model model) {
//        User user = userService.findById(id);
//        model.addAttribute("user", user);
//        model.addAttribute("userRoles", roleService.getUserRoles(user));
//        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
//        return "/security/user" + op; //returns employeeEdit or employeeDetails
//    }
//
//    @PostMapping("/users/addNew")
//    public RedirectView addNew(User user, RedirectAttributes redir) {
//        userService.save(user);
//
//        RedirectView redirectView = new RedirectView("/login", true);
//        redir.addFlashAttribute("message", "You have successfully registered a new user!");
//        return redirectView;
//    }

}
