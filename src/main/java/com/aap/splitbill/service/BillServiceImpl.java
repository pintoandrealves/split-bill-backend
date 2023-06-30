package com.aap.splitbill.service;

import com.aap.splitbill.dto.BillDto;
import com.aap.splitbill.mapper.Mapper;
import com.aap.splitbill.model.Bill;
import com.aap.splitbill.model.Item;
import com.aap.splitbill.repository.BillRepository;
import com.aap.splitbill.strategy.BankService;
import com.aap.splitbill.strategy.StrategyNameEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private BankService someService;

    @Override
    public BillDto saveBill(BillDto billDto) {
        Bill bill = Mapper.mapToBill(billDto);
        processBill(bill);
        return Mapper.mapToBillDto(billRepository.save(bill));
    }

    public void processBill(Bill bill){
        BigDecimal totalValue = BigDecimal.valueOf(bill.getFriends().stream()
                .flatMap(company -> company.getItems().stream())
                .map(Item::getPrice).mapToDouble(it-> it.doubleValue()).sum());

        String url = someService.getUrlBank(StrategyNameEnum.valueOf(bill.getBank()));

        bill.getFriends().forEach(it -> {

            BigDecimal totalFriend = BigDecimal.valueOf(it.getItems().stream().mapToDouble(it2 -> it2.getPrice().doubleValue()).sum());
            it.setTotalOrder(totalFriend.setScale(2, RoundingMode.HALF_UP));

            BigDecimal percent = (it.getTotalOrder().multiply(new BigDecimal(100))).divide(totalValue, 2, RoundingMode.HALF_UP);
            it.setPercent(percent.setScale(2, RoundingMode.HALF_UP));

            BigDecimal discount = bill.getDiscount().multiply(percent).divide(new BigDecimal(100));
            it.setDiscount(discount.setScale(2, RoundingMode.HALF_UP));

            BigDecimal addFee = bill.getAddFee().multiply(percent).divide(new BigDecimal(100));
            it.setAddFee(addFee.setScale(2, RoundingMode.HALF_UP));

            BigDecimal serviceTax = bill.getServiceTax().multiply(percent).divide(new BigDecimal(100));
            it.setServiceTax(serviceTax.setScale(2, RoundingMode.HALF_UP));

            BigDecimal sumTotalFriend = totalFriend.add(addFee).subtract(discount);
            BigDecimal serviceTaxValue = sumTotalFriend.multiply(serviceTax).divide(new BigDecimal(100));

            BigDecimal totalPay = sumTotalFriend.add(serviceTaxValue);
            it.setTotalPay(totalPay.setScale(2, RoundingMode.HALF_UP));

            it.setUrl(url+bill.getCustomer()+"/value/"+it.getTotalPay());

        });
    }

    @Override
    public List<BillDto> getAllBills() {
        List<Bill> bills = billRepository.findAll();
        return bills.stream().map(bill -> Mapper.mapToBillDto(bill)).toList();
    }

}
