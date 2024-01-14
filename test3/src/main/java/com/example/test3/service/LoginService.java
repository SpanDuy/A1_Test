package com.example.test3.service;

import com.example.test3.entity.Login;

import java.util.List;

public interface LoginService {
    void saveLoginsFromFile(String filePath);
    List<Login> findLogins();
}
