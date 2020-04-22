package com.lowes.retail.marchindization;

import java.util.List;

public interface MerchantService {

    Merchant create(Merchant merchant);

    List<Merchant> findAllMerchants();
}
