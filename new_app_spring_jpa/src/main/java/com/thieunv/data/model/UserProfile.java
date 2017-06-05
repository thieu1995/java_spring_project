package com.thieunv.data.model;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thieunv on 05/06/2017.
 */
public class UserProfile {

    @OneToMany(mappedBy = "bookmark", cascade = CascadeType.ALL)
    private List<Bookmark> contacts = new ArrayList<Bookmark>();
}
