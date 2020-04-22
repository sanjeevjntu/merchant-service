package com.sanjeev.retail.merchant;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping(path = "/merchants",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant> createMerchant(@RequestBody Merchant merchant) {
        return ResponseEntity.ok(merchantService.create(merchant));
    }

    @GetMapping(path = "/merchants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Merchant>> getAllMerchants() {
        List<Merchant> allMerchants = merchantService.findAllMerchants();
        return ResponseEntity.ok(allMerchants);
    }

    @GetMapping(path = "/merchants/{merchantId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant> getMerchant(@PathVariable String merchantId) {
        return ResponseEntity.ok( merchantService.getMerchant(merchantId));
    }

    @PutMapping(path = "/merchants/{merchantId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant> updateMerchant(@RequestBody Merchant merchant, @PathVariable String merchantId) {
        merchant.setId(merchantId);
        Merchant updatedMerchant = merchantService.updateMerchant(merchant);
        return ResponseEntity.ok(updatedMerchant);
    }
}