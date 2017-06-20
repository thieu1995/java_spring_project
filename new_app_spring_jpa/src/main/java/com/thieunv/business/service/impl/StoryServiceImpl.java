package com.thieunv.business.service.impl;

import com.thieunv.business.service.StoryService;
import com.thieunv.business.service.entity.ServiceResult;
import com.thieunv.data.model.Story;
import com.thieunv.data.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Created by thieunv on 05/06/2017.
 */
@Service
public class StoryServiceImpl implements StoryService {

    private final StoryRepository storyRepository;
    private final MessageSource messageSource;
    private Locale locale = LocaleContextHolder.getLocale();


    @Autowired
    public StoryServiceImpl(StoryRepository storyRepository, MessageSource messageSource) {
        this.storyRepository = storyRepository;
        this.messageSource = messageSource;
    }


    @Override
    public ServiceResult<Story> saveNewStory(Story story) {
        ServiceResult<Story> serviceResult = new ServiceResult<Story>();
        storyRepository.save(story);
        // if (add successful)
        // else (log for debug)

        serviceResult.setSuccessful(true);
        return serviceResult;
    }

    @Override
    public ServiceResult<List<Story>> getAllStories() {
        ServiceResult<List<Story>> serviceResult = new ServiceResult<List<Story>>();
        List<Story> storyList = storyRepository.findAll();
        if(storyList == null || storyList.size() == 0) {
            serviceResult.setSuccessful(false);
        } else {
            serviceResult.setSuccessful(true);
            serviceResult.setData(storyList);
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<Story> getStoryById(int storyId) {
        ServiceResult<Story> serviceResult = new ServiceResult<Story>();
        Story story = storyRepository.findOneByStoryId(storyId);
        if(story == null) {
            serviceResult.setSuccessful(false);
        } else {
            serviceResult.setSuccessful(true);
            serviceResult.setData(story);
        }
        return serviceResult;
    }

    @Override
    public ServiceResult<Story> deleteStoryById(int storyId) {
        ServiceResult<Story> serviceResult = new ServiceResult<Story>();
        Story story = storyRepository.findOneByStoryId(storyId);
        if(story == null) {
            serviceResult.setSuccessful(false);
        } else {
            storyRepository.delete(story);
            // if (delete successful)
            // else (log for debug)
            serviceResult.setSuccessful(true);
        }
        return serviceResult;
    }
}
