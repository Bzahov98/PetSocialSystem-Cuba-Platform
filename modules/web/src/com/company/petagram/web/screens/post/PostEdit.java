package com.company.petagram.web.screens.post;

import com.company.petagram.entity.Post;
import com.haulmont.cuba.gui.screen.*;

@UiController("petagram_Post.edit")
@UiDescriptor("post-edit.xml")
@EditedEntityContainer("postDc")
@LoadDataBeforeShow
public class PostEdit extends StandardEditor<Post> {
}