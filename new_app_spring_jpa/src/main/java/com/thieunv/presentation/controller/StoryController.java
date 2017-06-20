package com.thieunv.presentation.controller;

import com.thieunv.business.service.StoryService;
import com.thieunv.business.service.entity.ServiceResult;
import com.thieunv.data.model.Contact;
import com.thieunv.data.model.Story;
import com.thieunv.helper.Constant;
import com.thieunv.helper.MessageConstant;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by thieunv on 04/06/2017.
 */
@Controller
@RequestMapping("story")
public class StoryController {

    private final StoryService storyService;
    private final MessageSource messageSource;

    public StoryController(StoryService storyService, MessageSource messageSource) {
        this.storyService = storyService;
        this.messageSource = messageSource;
    }

    @RequestMapping(value={ "", "/", " "}, method = RequestMethod.GET)
    public String redirectToContactListPage(Model model, Locale locale) {
        return Constant.StoryController.REDIRECT_TO_STORY_LIST;
    }

    @RequestMapping(value="/all", method = RequestMethod.GET)
    public String viewListContactPage(Model model, Locale locale) {
        model.addAttribute(Constant.StoryController.MODEL_STORIES_NAME, storyService.getAllStories());
        return Constant.StoryController.VIEW_STORY_LIST_PAGE;
    }

    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String viewFromCreateNewContact(Model model, Locale locale) {
        model.addAttribute(Constant.StoryController.MODEL_STORY_NAME, new Story());
        return Constant.StoryController.VIEW_STORY_FORM_PAGE;
    }

    @RequestMapping(value="/add/save", method = RequestMethod.POST)
    public String processFromCreateNewContact(@Valid @ModelAttribute("story") Story story, BindingResult result, Locale locale, RedirectAttributes redirect, Model model) {
        if(result.hasErrors()) {
            redirect.addFlashAttribute(MessageConstant.Error.MESSAGE_ERROR, messageSource.getMessage(MessageConstant.Error.MESSAGE_SAVE_STORY, null, locale));
            return Constant.StoryController.REDIRECT_TO_STORY_FORM;
        }
        ServiceResult<Story> serviceResult = storyService.saveNewStory(story);
        if(serviceResult.isSuccessful()) {
            redirect.addFlashAttribute(MessageConstant.Success.MESSAGE_SUCCESS, messageSource.getMessage(MessageConstant.Success.MESSAGE_SAVE_STORY, null, locale));
            return Constant.StoryController.REDIRECT_TO_STORY_LIST;
        }
        model.addAttribute(MessageConstant.Error.MESSAGE_ERROR, messageSource.getMessage(MessageConstant.Error.MESSAGE_SAVE_STORY, null, locale));
        return Constant.Common.VIEW_404_PAGE;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String viewEditContactPage(@PathVariable int id, Model model, RedirectAttributes redirect, Locale locale) {
        ServiceResult<Story> serviceResult = storyService.getStoryById(id);
        if(serviceResult.isSuccessful()) {
            Story story = serviceResult.getData();
            if(story == null) {
                redirect.addFlashAttribute(MessageConstant.Error.MESSAGE_ERROR, messageSource.getMessage(MessageConstant.Error.MESSAGE_STORY_NOT_FOUND, null, locale));
                return Constant.StoryController.REDIRECT_TO_STORY_LIST;
            }
            model.addAttribute(Constant.StoryController.MODEL_STORY_NAME, story);
            return Constant.StoryController.VIEW_STORY_FORM_PAGE;
        }
        model.addAttribute(MessageConstant.Error.MESSAGE_ERROR, messageSource.getMessage(MessageConstant.Error.MESSAGE_STORY_NOT_FOUND, null, locale));
        return Constant.Common.VIEW_404_PAGE;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String processDeleteContact(@PathVariable int id, Model model, RedirectAttributes redirect, Locale locale) {
        ServiceResult<Story> serviceResult = storyService.deleteStoryById(id);
        if(serviceResult.isSuccessful()) {
            redirect.addFlashAttribute(MessageConstant.Success.MESSAGE_SUCCESS, messageSource.getMessage(MessageConstant.Success.MESSAGE_STORY_DELETE, null, locale));
            return Constant.StoryController.REDIRECT_TO_STORY_LIST;
        }
        model.addAttribute(MessageConstant.Error.MESSAGE_ERROR, messageSource.getMessage(MessageConstant.Error.MESSAGE_STORY_NOT_FOUND, null, locale));
        return Constant.Common.VIEW_404_PAGE;
    }

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String view404Page(Locale locale) {
        return Constant.Common.VIEW_404_PAGE;
    }
}
