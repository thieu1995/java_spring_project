package com.thieunv.business.service;

import com.thieunv.business.service.entity.ServiceResult;
import com.thieunv.data.model.Contact;
import com.thieunv.data.model.Story;

import java.util.List;

/**
 * Created by thieunv on 05/06/2017.
 */
public interface StoryService {
    ServiceResult<Story> saveNewStory(Story story);
    ServiceResult<List<Story>> getAllStories();
    ServiceResult<Story> getStoryById(int storyId);
    ServiceResult<Story> deleteStoryById(int storyId);
}
