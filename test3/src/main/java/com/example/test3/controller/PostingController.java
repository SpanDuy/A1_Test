package com.example.test3.controller;

import com.example.test3.entity.Posting;
import com.example.test3.service.LoginService;
import com.example.test3.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/postings")
@RequiredArgsConstructor
public class PostingController {
    private final PostingService postingService;

    @GetMapping("/getByPeriod")
    public ResponseEntity<List<Posting>> getPostingsByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam Boolean authorizedDelivery) {
        List<Posting> postings = postingService.getPostingsByPeriod(startDate, endDate, authorizedDelivery);
        return ResponseEntity.ok(postings);
    }

    @PostMapping("/parse")
    public ResponseEntity<?> getPostingsByPeriod() {
        postingService.savePostingsFromFile("D:\\Java\\A1_Test\\test3\\src\\main\\resources\\files\\postings.csv");
        return ResponseEntity.ok(null);
    }
}