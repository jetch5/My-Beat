package org.launchcode.MyBeat.controllers;

import org.launchcode.MyBeat.models.Story;
import org.launchcode.MyBeat.models.data.StoryDao;
import org.springframework.beans.factory.annotation.Autowired;
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

    // 2 pieces of Spring magic - no class needed to implement
    // Story Dao interface & autowired gives an instance of the
    // class by the framework (no constructor or passed in)
    @Autowired
    private StoryDao storyDao;

    //Request path: /main
    @RequestMapping(value = "")
    public String index(Model model) {
        // return an iterable
        model.addAttribute("stories", storyDao.findAll());
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

        storyDao.save(newStory);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveStoryForm(Model model) {
        model.addAttribute("stories", storyDao.findAll());
        model.addAttribute("title", "Remove Story");
        return "main/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveStoryForm(@RequestParam int[] storyIds) {

        for (int storyId : storyIds) {
            // delete would not work here
            // had to deleteById
            storyDao.deleteById(storyId);
        }

        return "redirect:";

    }

}
