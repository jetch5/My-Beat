package org.launchcode.MyBeat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;


@Controller
@RequestMapping("main")
public class StoryController {

    static ArrayList<String> stories = new ArrayList<>();

    //Request path: /main
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("stories", stories);
        model.addAttribute("title", "Home Page");
        return "main/index";

    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddNewStoryForm(Model model) {
        model.addAttribute("title", "Add Story");
        return "main/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddStoryForm(@RequestParam String storyName) {
        stories.add(storyName);
        // Redirect to / main
        return "redirect:";
    }

}
