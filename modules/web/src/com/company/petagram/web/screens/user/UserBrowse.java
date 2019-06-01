package com.company.petagram.web.screens.user;

import com.company.petagram.entity.User;
import com.haulmont.cuba.gui.screen.*;

@UiController("petagram_User.browse")
@UiDescriptor("user-browse.xml")
@LookupComponent("usersTable")
@LoadDataBeforeShow
public class UserBrowse extends StandardLookup<User> {
}