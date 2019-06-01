package com.company.petagram.service;

import com.company.petagram.entity.Comment;
import com.company.petagram.entity.Post;
import com.company.petagram.entity.User;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.Metadata;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Calendar;

@Service(AddNewCommentService.NAME)
public class AddNewCommentServiceBean implements AddNewCommentService {

    @Inject
    private Persistence persistence;
    @Inject
    private Metadata metadata;

    public Comment addNewComment(Post post, User user, String text) {
        if (user  == null) {
            System.err.println("\n\n\n\n\n\n\n\ntddd\n");
        }
        Comment newComment = metadata.create(Comment.class);
        try (Transaction tx = persistence.createTransaction()) {
            Calendar now = Calendar.getInstance();
            newComment.setDate(now.getTime());
            newComment.setPost(post);
            newComment.setText(text);
            newComment.setUser(user);
            //newComment.setId(user.getId());
            persistence.getEntityManager().persist(newComment);
            tx.commit();
        }
        return newComment;
    }
}