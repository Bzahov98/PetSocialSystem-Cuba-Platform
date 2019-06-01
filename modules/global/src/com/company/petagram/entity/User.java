package com.company.petagram.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import java.util.List;

@NamePattern("%s %s|user,status")
@Table(name = "PETAGRAM_USER")
@Entity(name = "petagram_User")
public class User extends StandardEntity {
    private static final long serialVersionUID = -4561193893676852969L;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected com.haulmont.cuba.security.entity.User user;

    @Column(name = "STATUS")
    protected String status;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PIC_ID")
    protected FileDescriptor pic;

    @OneToMany(mappedBy = "user")
    protected List<Comment> comment;

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public FileDescriptor getPic() {
        return pic;
    }

    public void setPic(FileDescriptor pic) {
        this.pic = pic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public com.haulmont.cuba.security.entity.User getUser() {
        return user;
    }

    public void setUser(com.haulmont.cuba.security.entity.User user) {
        this.user = user;
    }
    /*@PostConstruct
    protected void init() {
        setUser(AppBeans.get(UserSessionSource.class).getUserSession().getUser());
    }*/
}