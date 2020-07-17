package com.developia.bookstrore.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   private String comment;
   private BigDecimal rating;
   @ManyToOne
   @ToString.Exclude
    private Book book;
   @ManyToOne
    private User user;




}
