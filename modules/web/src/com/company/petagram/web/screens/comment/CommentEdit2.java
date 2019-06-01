package com.company.petagram.web.screens.comment;

import com.company.petagram.entity.Comment;
import com.haulmont.cuba.gui.screen.*;

@UiController("petagram_Comment.edit2")
@UiDescriptor("comment-edit2.xml")
@EditedEntityContainer("commentDc")
@LoadDataBeforeShow
public class CommentEdit2 extends StandardEditor<Comment> {
}