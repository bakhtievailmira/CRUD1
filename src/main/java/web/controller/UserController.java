package web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import web.model.User;


@Controller
@RequestMapping("/users")
public class UserController {

    private  UserDao userDao ;

    @Autowired
    public UserController(UserDaoImpl userDaoImpl){
        this.userDao = userDaoImpl;
    }

    @GetMapping()
   public String getUsers(Model model){
      model.addAttribute("users", userDao.index());
     return "users";
  }
    @GetMapping("/{id}")
    public String showUser(@PathVariable ("id") int id,Model model){
        model.addAttribute("user", userDao.show(id));
        return "show";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable ("id") int id,Model model){
        model.addAttribute("user", userDao.show(id));
        return "edit";
    }



    @GetMapping("/new")
     public String newUser(@ModelAttribute("user") User user){
        return "new";
     }

    @PostMapping()
    public String creatUser(@ModelAttribute("user") User user){
        userDao.save(user);
        return "redirect:/users";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute ("user") User user, @PathVariable ("id") int id){
        userDao.update(id, user);
        return  "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDao.delete(id);
        return "redirect:/users";
    }
}


