package com.lowes.retail.marchindization;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping(value = "/merchants",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant> createMerchant(@RequestBody Merchant merchant) {
        return ResponseEntity.ok(merchantService.create(merchant));
    }

    @GetMapping(value = "/merchants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Merchant>> getAllMerchants() {
        List<Merchant> allMerchants = merchantService.findAllMerchants();
        return ResponseEntity.ok(allMerchants);
    }
}