package com.sanjeev.retail.merchant;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Merchant-Service", description = "The merchant service API")
public class MerchantController {

    private final MerchantService merchantService;

    @Operation(summary = "Add a new merchant", description = "Add a new merchant")
    @PostMapping(path = "/merchants",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant> createMerchant(@Valid @RequestBody Merchant merchant) {
        return ResponseEntity.ok(merchantService.create(merchant));
    }

    @Operation(summary = "Get all merchants", description = "Get all merchants")
    @GetMapping(path = "/merchants", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Merchant>> getAllMerchants() {
        List<Merchant> allMerchants = merchantService.findAllMerchants();
        return ResponseEntity.ok(allMerchants);
    }

    @Operation(summary = "Get merchant", description = "Get merchant")
    @GetMapping(path = "/merchants/{merchantId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant> getMerchant(@PathVariable String merchantId) {
        return ResponseEntity.ok( merchantService.getMerchant(merchantId));
    }

    @Operation(summary = "Update a new merchant", description = "Update a new merchant")
    @PutMapping(path = "/merchants/{merchantId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Merchant> updateMerchant(@Valid @RequestBody Merchant merchant, @PathVariable String merchantId) {
        merchant.setId(merchantId);
        Merchant updatedMerchant = merchantService.updateMerchant(merchant);
        return ResponseEntity.ok(updatedMerchant);
    }
}