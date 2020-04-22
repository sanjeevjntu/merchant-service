package com.sanjeev.retail.merchant;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {
    private final MerchantRepository merchantRepository;

    @Override
    public Merchant create(Merchant merchant) {
        Merchant merchant1 = merchantRepository.save(merchant);
        return merchant1;
    }

    @Override
    public List<Merchant> findAllMerchants() {
        return merchantRepository.findAll();
    }

    @Override
    public Merchant getMerchant(String merchantId) {
        return merchantRepository.findById(merchantId).orElseThrow();
    }

    @Override
    public Merchant updateMerchant(Merchant merchant) {
        Merchant merchantToUpdate = getMerchant(merchant.getId());
        merchantToUpdate.setName(merchant.getName());
        merchantToUpdate.setPhone(merchant.getPhone());
        merchantToUpdate.setEmail(merchant.getEmail());
        merchantToUpdate.setAddress(merchant.getAddress());

        return merchantRepository.save(merchantToUpdate);
    }
}
