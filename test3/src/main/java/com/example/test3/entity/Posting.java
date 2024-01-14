package com.example.test3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "postings")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Posting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mat_doc")
    private String matDoc;

    @Column(name = "item")
    private Integer item;

    @Column(name = "doc_date")
    private Date docDate;

    @Column(name = "pstng_date")
    private Date pstngDate;

    @Column(name = "material_description")
    private String materialDescription;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "bun")
    private String bun;

    @Column(name = "amount_lc")
    private Double amountLc;

    @Column(name = "crcy")
    private String crcy;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "authorized_delivery")
    private Boolean authorizedDelivery;
}