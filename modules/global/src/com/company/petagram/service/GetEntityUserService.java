package com.company.petagram.service;

import com.company.petagram.entity.User;

public interface GetEntityUserService {
    String NAME = "petagram_GetEntityUserService";

    User getEntityUser(com.haulmont.cuba.security.entity.User user);
}