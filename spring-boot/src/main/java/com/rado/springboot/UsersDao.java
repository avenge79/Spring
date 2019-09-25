package com.rado.springboot;

import java.util.UUID;

public interface UsersDao {

    int insertUser(UUID id, Users user);

    default int insertUser(Users user) {

        return insertUser(user);
    }
}
