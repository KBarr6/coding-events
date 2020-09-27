package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
@RequestMapping("events")
public class EventController {

    //private static List<String> events = new ArrayList<>();

//    @GetMapping
//    public String displayAllEvents(Model model) {
//        model.addAttribute("events", events);
//          return "events/index";
//    }


    private static HashMap<String, String> events = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model){
        model.addAttribute("events", events);
        return "events/index";
    }

    @PostMapping("create")
    public String createAllEvents(@RequestParam String eventName, @RequestParam String eventDescription){
        events.put(eventName, eventDescription);
           return "redirect:";
    }

    @GetMapping("create") //lives at /events/create
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

//    @PostMapping("create") //lives at /events/create
//    public String createEvent(@RequestParam String eventName){
//        events.add(eventName);
//        return "redirect:"; //will redirect to /events
//    }

    }


