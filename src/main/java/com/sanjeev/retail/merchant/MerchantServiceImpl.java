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
}
