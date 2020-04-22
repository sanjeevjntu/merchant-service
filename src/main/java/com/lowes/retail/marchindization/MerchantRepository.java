package com.lowes.retail.marchindization;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MerchantRepository extends MongoRepository<Merchant, String> {
}
