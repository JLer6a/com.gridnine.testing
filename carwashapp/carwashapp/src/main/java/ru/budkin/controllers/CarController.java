package ru.budkin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.budkin.model.Car;
import ru.budkin.repositories.CarRepositoryImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class CarController {

    @Autowired
    private CarRepositoryImpl carRepository;



    @RequestMapping(value = "/car", method = RequestMethod.GET)
    public ModelAndView getCarsPage(){
        List<Car> cars = carRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("carlist");
        modelAndView.addObject("cars", cars);
        return modelAndView;
    }

    @RequestMapping (value = "/car", method = RequestMethod.POST)
    public ModelAndView addCar(Car car){
        carRepository.addNewCar(car);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/car");
        return modelAndView;
    }

//    @RequestMapping (value = "/car", method = RequestMethod.POST)
//    public String addCar(Car car){
//        carRepository.addNewCar(car);
//        return "redirect:/car";
//    }


//    @Override
//    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        if (request.getMethod().equals("GET")){
//            List<Car> cars = carRepository.findAll();
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("index");
//            modelAndView.addObject("cars", cars);
//            return modelAndView;
//        }
//        return null;
//    }


    //    @GetMapping("/car")
//    private String index (Model model){
//        model.addAttribute("cars", carRepository.findAll());
//        return "index";
//
//    }

}
