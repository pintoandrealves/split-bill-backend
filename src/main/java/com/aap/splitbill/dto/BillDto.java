package com.aap.splitbill.dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class BillDto {
    private Long id;
    private Boolean isProportional;
    private BigDecimal discount = BigDecimal.ZERO;
    private BigDecimal addFee = BigDecimal.ZERO;
    private BigDecimal serviceTax = BigDecimal.ZERO;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @CreationTimestamp
    private LocalDateTime updatedOn;
    private List<FriendDto> friends;
    private String bank;
    private String customer;

}
