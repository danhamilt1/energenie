package com.energenie.energenie;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class EnergenieControllerRestfulInterface {

	@Autowired
	EnergenieController controller;
	
    @RequestMapping("/")
    public String helloWorld() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/l1/on")
    public String l1On() {
        controller.l1On();
        return "l1 on";
    }
    
    @RequestMapping("/l1/off")
    public String l1Off() {
        controller.l1Off();
        return "l1 off";
    }
    
    @RequestMapping("/l2/on")
    public String l2On() {
        controller.l2On();
        return "l2 on";
    }
    
    @RequestMapping("/l2/off")
    public String l2Off() {
        controller.l2Off();
        return "l2 off";
    }
    @RequestMapping("/l3/on")
    public String l3On() {
        controller.l3On();
        return "l3 on";
    }
    
    @RequestMapping("/l3/off")
    public String l3Off() {
        controller.l3Off();
        return "l3 off";
    }
    
    @RequestMapping("/l4/on")
    public String l4On() {
        controller.l4On();
        return "l4 on";
    }
    
    @RequestMapping("/l4/off")
    public String l4Off() {
        controller.l4Off();
        return "l4 off";
    }
    
    @RequestMapping("/sleep/on")
    public String sleepModeOn() {
        controller.l2Off();
        controller.l3On();
        return "sleep on";
    }
    
    @RequestMapping("/sleep/off")
    public String sleepModeOff() {
    	controller.l2On();
        controller.l3Off();
        return "sleep off";
    }
}