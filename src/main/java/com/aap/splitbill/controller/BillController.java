package com.aap.splitbill.controller;

import com.aap.splitbill.dto.BillDto;
import com.aap.splitbill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
@CrossOrigin
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping("/save")
    public BillDto saveBill(@RequestBody BillDto billDto){
        return billService.saveBill(billDto);
    }

    @GetMapping("/all")
    public List<BillDto> getAllBills(){
        return billService.getAllBills();
    }
}
