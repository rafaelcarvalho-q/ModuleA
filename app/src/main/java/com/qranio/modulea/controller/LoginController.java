package com.qranio.modulea.controller;

import com.qranio.modulea.R;
import com.qranio.modulea.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael C. Almeida on 07/07/16.
 */
public class LoginController {

    public LoginController() {
    }

    public List<User> loadUsers() {

        List<User> users = new ArrayList(0);
        int count = 50;

        while (count-- >= 0) {

            User user = new User("Nome usuário " + count, "Sobrenome usuário " + count, R.drawable.img_user, "email@" + count + ".com.br", "07/07/2007");
            users.add(user);
        }

        return users;
    }
}
