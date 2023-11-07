package com.example.nicecoding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

    @GetMapping("/index")
    public String dashboard(){
        return"dashboard/index";
    }

    @GetMapping("/account")
    public String account(){
        return"account/transaction/index";
    }

    @GetMapping("/fleet")
    public String fleet(){
        return"fleet/vehicle/index";
    }

    @GetMapping("/hr")
    public String hr(){
        return"hr/department/index";
    }

    @GetMapping("/parameter")
    public String parameter(){
        return"parameter/country/index";
    }

}
