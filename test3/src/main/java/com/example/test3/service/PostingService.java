package com.example.test3.service;

import com.example.test3.entity.Posting;

import java.time.LocalDate;
import java.util.List;

public interface PostingService {
    void savePostingsFromFile(String filePath);
    void processPostings(List<Posting> postings);
    List<Posting> getPostingsByPeriod(LocalDate startDate, LocalDate endDate, Boolean authorizedDelivery);
}
