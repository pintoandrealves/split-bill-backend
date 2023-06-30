package com.aap.splitbill.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class FriendDto {
    private Long id;
    private String name;
    private String phone;

    private String url;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @CreationTimestamp
    private LocalDateTime updatedOn;
    private BillDto bill;
    private List<ItemDto> items;
    private BigDecimal percent;
    private BigDecimal totalOrder;
    private BigDecimal discount;
    private BigDecimal totalPay;
    private BigDecimal addFee;
    private BigDecimal serviceTax;

}