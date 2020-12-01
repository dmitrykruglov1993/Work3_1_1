package SpringBoot.controllers;

import SpringBoot.model.User;
import SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Добавление первой записи в БД
    @Autowired
    public void FirstUserInTable(){
        userService.FirstSave();
    }

    @GetMapping("/")
    public String ViewUserListPage(Model model){
        model.addAttribute("user",userService.getUsers());
        return "page";
    }

    //Добавление нового юзера
    @GetMapping("/new")
    public String getNewUser(@ModelAttribute("user") User user){
        return "newUser";
    }
    @PostMapping
    public String create(User user){
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/";
    }

    //Обновить юзера
    @GetMapping("/up/{id}")
    public String ShowUpdatePage(@PathVariable("id") Long id, Model model){
        model.addAttribute("user",userService.findById(id));
        return "updatePage";
    }
    @PostMapping("/{id}")
    public String update(@ModelAttribute("user")User user,@PathVariable("id") Long id){
        userService.save(user);
        return "redirect:/";
    }
}
