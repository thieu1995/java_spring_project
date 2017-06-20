package com.thieunv.data.repository;

import com.thieunv.data.model.Story;
import com.thieunv.data.repository.base.StoryRepositoryBase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by thieunv on 20/06/2017.
 */
public interface StoryRepository extends CrudRepository<Story, Integer>{

    @SuppressWarnings("unchecked")
    Story save(Story story);
    Story findOneByStoryId(int id);
    List<Story> findAll();
    void delete(Story story);

}
