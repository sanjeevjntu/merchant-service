package com.sanjeev.retail.merchant.repository;

import com.sanjeev.retail.merchant.domain.Merchant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantRepository extends MongoRepository<Merchant, String> {
}
