package com.example.test3.service.serviceImpl;

import com.example.test3.entity.Login;
import com.example.test3.entity.Posting;
import com.example.test3.parser.Parser;
import com.example.test3.parser.ParserFactory;
import com.example.test3.repository.LoginRepository;
import com.example.test3.repository.PostingRepository;
import com.example.test3.service.LoginService;
import com.example.test3.service.PostingService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostingServiceImpl implements PostingService {
    private final PostingRepository postingRepository;
    private final LoginService loginService;

    @Override
    public void savePostingsFromFile(String filePath) {
        Parser parser = ParserFactory.getParser(new Posting());
        List<Posting> postings = (List<Posting>) parser.parse(filePath);

        processPostings(postings);
    }

    @Override
    public void processPostings(List<Posting> postings) {

        List<Login> logins = loginService.findLogins();
        Map<String, Login> loginMap = new HashMap<>();
        for (Login login : logins) {
            loginMap.put(login.getAppAccountName(), login);
        }

        for (Posting posting : postings) {
            Login login = loginMap.get(posting.getUserName());
            if (login != null && login.isActive()) {
                posting.setAuthorizedDelivery(true);
            } else {
                posting.setAuthorizedDelivery(false);
            }
        }

        postingRepository.saveAll(postings);
    }

    @Override
    public List<Posting> getPostingsByPeriod(LocalDate startDate, LocalDate endDate, Boolean authorizedDelivery) {

        return postingRepository.findByPeriodAndAuthorizedDelivery(startDate, endDate, authorizedDelivery);
    }

}
