package com.company.petagram.web.screens.post;

import com.company.petagram.entity.Post;
import com.haulmont.cuba.gui.screen.*;

@UiController("petagram_Post.browse")
@UiDescriptor("post-browse.xml")
@LookupComponent("postsTable")
@LoadDataBeforeShow
public class PostBrowse extends StandardLookup<Post> {
}