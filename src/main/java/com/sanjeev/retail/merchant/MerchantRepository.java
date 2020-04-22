package com.sanjeev.retail.merchant;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantRepository extends MongoRepository<Merchant, String> {
}
