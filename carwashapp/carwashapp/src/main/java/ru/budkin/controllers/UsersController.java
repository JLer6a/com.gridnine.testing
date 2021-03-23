package ru.budkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.budkin.model.User;
import ru.budkin.repositories.UsersRepositoryImpl;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UsersRepositoryImpl usersRepository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUserPage(){
        List<User> users = usersRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersPage");
        modelAndView.addObject("users", users);
        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ModelAndView addUser(User user){
        usersRepository.addNewUser(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/users");
        return modelAndView;
    }

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public String getUserPage(Model model){
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "usersPage";
//    }
//
//    @RequestMapping (value = "/users", method = RequestMethod.POST)
//    public String addUser(User user){
//        userService.addUser(user);
//        return "redirect:/users";
//    }


}
