package com.example.test3.parser.parserImpl;

import com.example.test3.entity.Login;
import com.example.test3.entity.Posting;
import com.example.test3.parser.Parser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PostingParser implements Parser {
    @Override
    public List<Posting> parse(String filePath) {
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            List<Posting> postings = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            List<String[]> records = reader.readAll();
            records.remove(0);
            records.remove(0);

            for (String[] record : records) {
                Posting posting = Posting.builder()
                        .matDoc(record[0].trim())
                        .item(Integer.parseInt(record[1].trim()))
                        .docDate(dateFormat.parse(record[2].trim()))
                        .pstngDate(dateFormat.parse(record[3].trim()))
                        .materialDescription(record[4].trim())
                        .quantity(Integer.parseInt(record[5].trim()))
                        .bun(record[6].trim())
                        .amountLc(Double.parseDouble(record[7].trim().replace(',', '.')))
                        .crcy(record[8].trim())
                        .userName(record[9].trim())
                        .build();

                postings.add(posting);
            }

            return postings;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return null;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
