package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

@Autowired
private UserService userService ;

    @GetMapping()
   public String getUsers(Model model){
      model.addAttribute("users", userService.index());
     return "users";
  }
    @GetMapping("/{id}")
    public String showUser(@PathVariable ("id") int id,Model model){
        model.addAttribute("user", userService.show(id));
        return "show";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable ("id") int id,Model model){
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @GetMapping("/new")
     public String newUser(@ModelAttribute("user") User user){
        return "new";
     }

    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}/edit")
    public String update(@ModelAttribute ("user") User user, @PathVariable ("id") int id){
        userService.update(id, user);
        return  "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}


