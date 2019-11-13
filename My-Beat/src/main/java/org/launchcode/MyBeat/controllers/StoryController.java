package org.launchcode.MyBeat.controllers;

import org.launchcode.MyBeat.models.Story;
import org.launchcode.MyBeat.models.StoryData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
@RequestMapping("main")
public class StoryController {

    //Request path: /main
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("stories", StoryData.getAll());
        model.addAttribute("title", "Home Page");
        return "main/index";

    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddNewStoryForm(Model model) {
        model.addAttribute("title", "Add Story");
        model.addAttribute(new Story());
        return "main/add";
    }
    
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddStoryForm(@ModelAttribute @Valid Story newStory, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Story");
            return "main/add";
        }

        StoryData.add(newStory);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveStoryForm(Model model) {
        model.addAttribute("stories", StoryData.getAll());
        model.addAttribute("title", "Remove Story");
        return "main/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveStoryForm(@RequestParam int[] storyIds) {

        for (int storyId : storyIds) {
            StoryData.remove(storyId);
        }

        return "redirect:";

    }

}
