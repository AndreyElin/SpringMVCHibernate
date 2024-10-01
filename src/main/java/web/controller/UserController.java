package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @RequestMapping ("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestParam("id") int id, Model model) {
        User user = userService.edit(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @RequestMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.update(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
