package com.company.petagram.service;

import com.company.petagram.entity.Comment;
import com.company.petagram.entity.Post;
import com.company.petagram.entity.User;

public interface AddNewCommentService {
    String NAME = "petagram_AddNewCommentService";

    Comment addNewComment(Post post, User user, String text);
}