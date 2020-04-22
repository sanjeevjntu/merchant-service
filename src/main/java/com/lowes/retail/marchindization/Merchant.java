package com.lowes.retail.marchindization;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "merchants")
@Setter
@Getter
public class Merchant {

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
