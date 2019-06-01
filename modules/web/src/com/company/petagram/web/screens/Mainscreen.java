package com.company.petagram.web.screens;

import com.company.petagram.entity.Comment;
import com.company.petagram.entity.Post;
import com.company.petagram.entity.User;
import com.company.petagram.service.AddNewCommentService;
import com.company.petagram.service.GetEntityUserService;
import com.haulmont.cuba.core.global.AppBeans;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.List;

@UiController("petagram_Mainscreen")
@UiDescriptor("MainScreen.xml")
public class Mainscreen extends Screen {
    @Inject
    private Image postImage;
    @Inject
    private TextField<String> postField;
    @Inject
    private TextArea<String> newCommTextArea;
    @Inject
    private UserSession userSession;
    @Inject
    private Button sendCM;
    @Inject
    private DataManager dataManager;
    @Inject
    private CollectionContainer<Comment> commentDc;
    @Inject
    private InstanceContainer<Post> postDC;
    @Inject
    private CollectionLoader<Comment> commentDl;
    @Inject
    private InstanceLoader<Post> postL;
    private int newPosition = 0;
    @Inject
    private Table<Comment> commentTable;
    @Inject
    private UiComponents uiComponents;
    private int commentsSize = 0;
    @Inject
    private AddNewCommentService addNewCommentService;
    @Inject
    private GetEntityUserService getEntityUserService;

    @Subscribe
    private void onInit(InitEvent event) {
        commentTable.addGeneratedColumn("user.pic", comment ->{
            if (comment.getUser().getPic() != null){
                Image pic = uiComponents.create(Image.class);
                pic.setAlignment(Component.Alignment.MIDDLE_CENTER);
                pic.setValueSource(new ContainerValueSource<>(commentTable.getInstanceContainer(comment),"user.pic"));
                return pic;
            }return null;
        });
    }

    @Subscribe("previousPost")
    private void onPreviousPostClick(Button.ClickEvent event) {
        newPosition--;
        changePost();
    }

    @Subscribe("nextPost")
    private void onNextPostClick1(Button.ClickEvent event) {
        newPosition++;
        changePost();

    }

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        changePost();
    }

    @Subscribe("sendCM")
    private void onSendCMClick(Button.ClickEvent event) {
        User entityUser = getEntityUserService.getEntityUser( AppBeans.get(UserSessionSource.class).getUserSession().getUser());
        addNewCommentService.addNewComment(postDC.getItem(), entityUser, newCommTextArea.getRawValue());
        //commentTable.refresh();
        commentDl.load();
    }
    private void changePost() {
        List<Post> list = dataManager.load(Post.class).view("post-view").list();

        commentsSize = list.size() - 1;
        if ( (commentsSize < newPosition) || (newPosition < 0)) {
            newPosition = 0;
        }

        postDC.setItem(list.get(newPosition));

        commentDl.setParameter("postId", postDC.getItem().getId());
        commentDl.load();
    }
}