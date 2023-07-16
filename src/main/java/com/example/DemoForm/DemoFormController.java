package com.example.DemoForm;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoFormController {
    List<User> userList = new ArrayList<>();
    @GetMapping("/")
    public String getForm(Model model) {
        model.addAttribute( "user", new User() );
        return "sign-up";
    }
    @PostMapping("/submitItem")
    public String submitForm(@Valid User user , BindingResult result) {
        if (user.getFirstName().equals( user.getLastName() )) result.rejectValue( "lastname","","please enter valid data" );
        if (result.hasErrors())return "sign-up" ;
        return "redirect:/result";
    }
    @GetMapping("/result")
    public String getResult() {
        return "result";
    }


}
