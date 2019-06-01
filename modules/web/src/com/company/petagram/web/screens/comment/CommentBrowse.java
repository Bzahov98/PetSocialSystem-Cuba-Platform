package com.company.petagram.web.screens.comment;

import com.company.petagram.entity.Comment;
import com.haulmont.cuba.gui.screen.*;

@UiController("petagram_Comment.browse")
@UiDescriptor("comment-browse.xml")
@LookupComponent("commentsTable")
@LoadDataBeforeShow
public class CommentBrowse extends StandardLookup<Comment> {
}