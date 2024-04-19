package com.ressourcemanagement.controller;

import com.ressourcemanagement.dto.UserDto;
import com.ressourcemanagement.enumeration.UsersRoles;
import com.ressourcemanagement.model.User;
import com.ressourcemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("/responsable/users")
    public String getAllUsers(Model model, @AuthenticationPrincipal User user) {
        List<User> userList = userService.getAllUsers();
        List<User> filtredList = userList.stream().filter(u -> u.getRole() != UsersRoles.RESPONSABLE).toList();
        model.addAttribute("user", user);
        model.addAttribute("userList", filtredList);
        return "responsable/users";
    }

    @GetMapping("/responsable/users/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:responsable/users?delete_success";
    }

    @GetMapping("/responsable/users/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model, @AuthenticationPrincipal User user) {
        User user_to_modify = userService.getUser(id);
        model.addAttribute("user_to_modify", user_to_modify);
        model.addAttribute("user", user);
        return "responsable/editUser";
    }

    @PostMapping("/responsable/users/{id}/edit")
    public String updateUser(@PathVariable("id") long id, UserDto user) {
        userService.updateUser(id, user);
        return "redirect:/responsable/users?update_success";
    }

    @GetMapping("/responsable/users/add")
    public String addUser(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "responsable/addUser";
    }

}