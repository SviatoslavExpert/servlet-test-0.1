package com.akhambir.factory;

import com.akhambir.controller.UserController;
import com.akhambir.dao.UserDao;
import com.akhambir.dao.UserDaoImpl;
import com.akhambir.service.UserService;
import com.akhambir.service.UserServiceImpl;

public class Factory {

    public static UserController getUserController() {
        return new UserController(Factory.getUserService());
    }

    private static UserService getUserService() {
        return new UserServiceImpl(Factory.getUserDao());
    }

    private static UserDao getUserDao() {
        return new UserDaoImpl();
    }

}
