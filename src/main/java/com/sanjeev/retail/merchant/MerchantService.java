package com.sanjeev.retail.merchant;

import java.util.List;

public interface MerchantService {

    Merchant create(Merchant merchant);

    List<Merchant> findAllMerchants();

    Merchant getMerchant(String merchantId);

    Merchant updateMerchant(Merchant merchant);

}
