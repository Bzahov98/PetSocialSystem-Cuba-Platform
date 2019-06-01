package com.company.petagram.web.screens.user;

import com.company.petagram.entity.User;
import com.haulmont.cuba.gui.screen.*;

@UiController("petagram_User.edit")
@UiDescriptor("user-edit.xml")
@EditedEntityContainer("userDc")
@LoadDataBeforeShow
public class UserEdit extends StandardEditor<User> {
}