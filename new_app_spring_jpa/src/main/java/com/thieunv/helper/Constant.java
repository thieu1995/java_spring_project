package com.thieunv.helper;

/**
 * Created by thieunv on 06/06/2017.
 */

/* https://codex.wordpress.org/Roles_and_Capabilities   */
/* https://thachpham.com/wordpress/wordpress-tutorials/vai-tro-nhom-user.html */
public class Constant {

    public class Common {
        public static final String VIEW_404_PAGE = "common/404";
    }

    public class User {
        public static final short USER_INACTIVATED = 0;
        public static final short USER_ACTIVATED = 1;
        public static final short USER_BLOCKED = 2;
        public static final short USER_DELETED = 3;
    }

    public class Role {
        public static final String ROLE_SUPER_ADMIN = "SUPER_AMIN";
        public static final String ROLE_ADMIN = "ADMIN";
        public static final String ROLE_EDITOR = "EDITOR";
        public static final String ROLE_AUTHOR = "AUTHOR";
        public static final String ROLE_CONTRIBUTOR = "CONTRIBUTOR";
        public static final String ROLE_MEMBER = "MEMBER";
        public static final String ROLE_SUBSCRIBER = "SUBSCRIBER";
    }

    public class Capability {
        public static final String CATY_READ_QUOTES = "READ";               // guess
        public static final String CATY_READ_PUBLISHED_POSTS = "READ";
        public static final String CATY_READ_PUBLISHED_WALLS = "READ";

        public static final String CATY_CREATE_PROFILE = "READ";        // subscriber
        public static final String CATY_READ_PROFILE = "READ";
        public static final String CATY_UPDATE_PROFILE = "READ";

        public static final String CATY_CREATE_CONTACTS = "READ";        // member
        public static final String CATY_READ_CONTACTS = "READ";
        public static final String CATY_UPDATE_CONTACTS = "READ";
        public static final String CATY_DELETE_CONTACTS = "READ";

        public static final String CATY_CREATE_BOOKMARKS = "READ";
        public static final String CATY_READ_BOOKMARKS = "READ";
        public static final String CATY_UPDATE_BOOKMARKS = "READ";
        public static final String CATY_DELETE_BOOKMARKS = "READ";

        public static final String CATY_CREATE_QUOTES = "READ";             // contributor
        public static final String CATY_UPDATE_QUOTES = "READ";
        public static final String CATY_DELETE_QUOTES = "READ";

        public static final String CATY_CREATE_POSTS = "READ";
        public static final String CATY_EDIT_DRAFT_POSTS = "READ";
        public static final String CATY_DRAFT_POSTS = "READ";
        public static final String CATY_DELETE_DRAFT_POSTS = "READ";

        public static final String CATY_UPLOAD_FILES = "READ";

        public static final String CATY_PUBLISHED_POSTS = "READ";             // author
        public static final String CATY_DELETE_PUBLISHED_POSTS = "READ";
        public static final String CATY_EDIT_PUBLISHED_POSTS = "READ";

        public static final String CATY_CREATE_DRAFT_WALLS = "READ";
        public static final String CATY_READ_DRAFT_WALLS = "READ";
        public static final String CATY_EDIT_DRAFT_WALLS = "READ";
        public static final String CATY_DELETE_DRAFT_WALLS = "READ";

        public static final String CATY_PUBLISHED_WALLS = "READ";               // editor
        public static final String CATY_EDIT_PUBLISHED_WALLS = "READ";
        public static final String CATY_DELETE_PUBLISHED_WALLS = "READ";

        public static final String CATY_REMOVE_USERS = "READ";              // admin
        public static final String CATY_PROMOTE_USERS = "READ";
        public static final String CATY_LIST_USERS = "READ";
        public static final String CATY_DELETE_USERS = "READ";
        public static final String CATY_EDIT_USERS = "READ";


        public static final String CATY_MANAGER_ADMIN = "READ";              // super admin
        public static final String CATY_MANAGER_THEMES = "READ";
        public static final String CATY_MANAGER_WEBSITE_SETTINGS = "READ";

    }

    public class ContactController {
        public static final String VIEW_CONTACT_LIST_PAGE = "pages/contact/contact_list";
        public static final String VIEW_CONTACT_FORM_PAGE  = "pages/contact/contact_form";


        public static final String MODEL_CONTACT_NAME  = "contact";
        public static final String MODEL_CONTACTS_NAME = "contacts";

        public static final String REDIRECT_TO_CONTACT_LIST  = "redirect:/contact/all";
        public static final String REDIRECT_TO_CONTACT_FORM  = "redirect:/contact/add";
    }

    public class MainController {
        public static final String VIEW_INDEX_PAGE = "index";
        public static final String VIEW_SIGN_IN_PAGE = "auth/sign_in";
        public static final String VIEW_SIGN_UP_PAGE  = "auth/sign_up";
        public static final String VIEW_DASHBOARD_PAGE  = "pages/home/dashboard";

        public static final String REDIRECT_SIGN_IN_PAGE  = "redirect:/login";
        public static final String REDIRECT_SIGN_UP_PAGE  = "redirect:/registration";

    }

}
