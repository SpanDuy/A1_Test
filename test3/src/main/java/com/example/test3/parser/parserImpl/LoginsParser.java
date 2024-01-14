package com.example.test3.parser.parserImpl;

import com.example.test3.entity.Login;
import com.example.test3.parser.Parser;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginsParser implements Parser {
    @Override
    public List<Login> parse(String filePath) {
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {

            List<Login> logins = new ArrayList<>();
            List<String[]> records = reader.readAll();
            records.remove(0);

            for (String[] record : records) {
                Login login = Login.builder()
                        .appAccountName(record[1])
                        .isActive("\tTrue".equals(record[2]))
                        .build();

                logins.add(login);
            }

            return logins;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return null;
        }
    }
}
