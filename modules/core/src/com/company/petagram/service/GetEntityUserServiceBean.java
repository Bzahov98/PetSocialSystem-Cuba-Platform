package com.company.petagram.service;

import com.company.petagram.entity.User;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(GetEntityUserService.NAME)
public class GetEntityUserServiceBean implements GetEntityUserService {

    @Inject
    private Persistence persistence;

    @Override
    public User getEntityUser(com.haulmont.cuba.security.entity.User user) {
        User firstResult;
        //TODO query doesnt return entity user so now gets first!!!
        //if(user != null){System.err.println("\n\n\n nema    "+ user.getId() +"\n\n\n");}
        try (Transaction tx = persistence.createTransaction()) {
            TypedQuery<User> query = persistence.getEntityManager()
                    .createQuery("select u from petagram_User u "/* +
                            "             where u.user = :sysUser"*/, User.class);
            //query.setParameter("sysUser", user);
            List<User> resultList = query.getResultList();
            //System.err.println("\n\n\n" + resultList.size() + "\n\n\n");
            firstResult = resultList.get(0);
            tx.commit();
        }

        return firstResult;
        /*"select u from petagram_User u" +
                            " where u.user.id = :sysUserID "*/
    }
}