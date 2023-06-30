package com.aap.splitbill.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean isProportional;
    private BigDecimal discount = BigDecimal.ZERO;
    private BigDecimal addFee = BigDecimal.ZERO;
    private BigDecimal serviceTax = BigDecimal.ZERO;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @CreationTimestamp
    private LocalDateTime updatedOn;
    private String bank;

    private String customer;

    @OneToMany(targetEntity = Friend.class,cascade=CascadeType.ALL)
    @JoinColumn(name = "bill_id",nullable = false)
    private List<Friend> friends = new ArrayList<>();

}
