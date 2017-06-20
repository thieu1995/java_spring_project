package com.thieunv.data.repository.base;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thieunv on 20/06/2017.
 */
@NoRepositoryBean
public interface StoryRepositoryBase<Story, Integer extends Serializable> extends Repository<Story, Integer> {
    Story save(Story story);
    Story findOneById(int storyId);
    List<Story> findAll();
    void delete(Story story);
}
