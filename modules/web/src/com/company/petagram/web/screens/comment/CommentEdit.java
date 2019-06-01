package com.company.petagram.web.screens.comment;

import com.company.petagram.entity.Comment;
import com.haulmont.cuba.gui.screen.*;

@UiController("petagram_Comment.edit")
@UiDescriptor("comment-edit.xml")
@EditedEntityContainer("commentDc")
@LoadDataBeforeShow
public class CommentEdit extends StandardEditor<Comment> {
}