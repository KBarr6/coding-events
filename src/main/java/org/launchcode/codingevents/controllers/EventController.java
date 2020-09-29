package org.launchcode.codingevents.controllers;

import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
          return "events/index";
    }


   // private static HashMap<String, String> events = new HashMap<>();

//    @GetMapping
//    public String displayAllEvents(Model model){
//        model.addAttribute("events", events);
//        return "events/index";
//    }

    @PostMapping("create")
    public String processCreateEventsForm(@ModelAttribute Event newEvent){
        EventData.add(newEvent);
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


    @GetMapping("delete")
        public String displayDeleteEventForm(Model model) {
            model.addAttribute("title", "Delete Events");
            model.addAttribute("events", EventData.getAll());
            return "events/delete";
            }// lives at /events/delete

    @PostMapping("delete")
        public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds){
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
            return "redirect:";

    }
    }


