package com.fh.service;

import com.fh.comment.SerResponse;
import com.fh.model.User;

public interface UserService {

    SerResponse login(User user);

    SerResponse register(User user);
}
