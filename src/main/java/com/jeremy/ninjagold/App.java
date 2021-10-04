package com.jeremy.ninjagold;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeremy.ninjagold.App;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import javax.servlet.http.HttpSession;
@SpringBootApplication
@Controller
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SpringApplication.run(App.class, args);

	}
	
    @RequestMapping("/")
    public String index(HttpSession session, Model model) {
    	if (session.getAttribute("gold") == null) {
    		session.setAttribute("gold", 0);
    		ArrayList<String> status = new ArrayList<String>();
    		session.setAttribute("status", status);
    	}
    
    	Integer gold = Integer.parseInt(session.getAttribute("gold").toString());
    	@SuppressWarnings("unchecked")
		ArrayList<String> status = (ArrayList<String>) session.getAttribute("status");
    	model.addAttribute("gold", gold);
    	model.addAttribute("status");

        return "index.jsp";
        
    }
    @RequestMapping(value="/action", method=RequestMethod.POST)
    public String farm(HttpSession session, @RequestParam(value="location") String location){
    	Integer gold = Integer.parseInt(session.getAttribute("gold").toString());
    	int randomNum = 1;
    	if (location.equals("farm")) {
//    		
    		randomNum = ThreadLocalRandom.current().nextInt(10, 20 + 1);
    	}
    	if (location.equals("cave")) {
    		
    		randomNum = ThreadLocalRandom.current().nextInt(5, 10 + 1);
    	}
    	if (location.equals("house")) {
    		
    		randomNum = ThreadLocalRandom.current().nextInt(2, 5 + 1);
    	}
    	if (location.equals("casino")) {
    		
    		randomNum = ThreadLocalRandom.current().nextInt(-50, 50 + 1);
    	}

    	gold += randomNum;  
    	String newMsg = "";
    	if (gold < 0) {
    		 newMsg = "You entered a " + location + " and lost " + randomNum + " gold."; 
    		
    	} else {
    		 newMsg = "You entered a " + location + " and earned " + randomNum + " gold."; 
    		
    	}
    	
    	@SuppressWarnings("unchecked")
		ArrayList<String> status = (ArrayList<String>) session.getAttribute("status");
    	session.setAttribute("gold", gold);
    	status.add(newMsg);
    	session.setAttribute("status", status);
    	return "redirect:/";
    	
    }
  
   
   


    
    


    //

}
