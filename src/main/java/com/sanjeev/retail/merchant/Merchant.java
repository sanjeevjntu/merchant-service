package com.sanjeev.retail.merchant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "merchants")
@Setter
@Getter
public class Merchant {

    @MongoId
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
}