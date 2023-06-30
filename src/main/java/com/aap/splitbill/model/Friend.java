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
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private BigDecimal percent;
    private BigDecimal totalOrder;
    private String url;
    private BigDecimal discount;

    private BigDecimal totalPay;

    private BigDecimal addFee;

    private BigDecimal serviceTax;

    @CreationTimestamp
    private LocalDateTime createdOn;
    @CreationTimestamp
    private LocalDateTime updatedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="bill_id", nullable=false , insertable=false, updatable=false)
    private Bill bill;

    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "friend_id",nullable = false)
    private List<Item> items = new ArrayList<>();

}