package com.example.test3.service.serviceImpl;

import com.example.test3.entity.Login;
import com.example.test3.parser.Parser;
import com.example.test3.parser.ParserFactory;
import com.example.test3.repository.LoginRepository;
import com.example.test3.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final LoginRepository loginRepository;

    @Override
    public void saveLoginsFromFile(String filePath) {
        Parser parser = ParserFactory.getParser(new Login());
        List<Login> logins = (List<Login>) parser.parse(filePath);

        loginRepository.saveAll(logins);
    }

    @Override
    public List<Login> findLogins() {
        return loginRepository.findAll();
    }
}
