package com.sanjeev.retail.merchant;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Document(collection = "merchants")
@Setter
@Getter
public class Merchant {

    //@MongoId
    @Id
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    @Size(min = 10, max = 20)
    private String phone;
    @Email
    private String email;
    @NotBlank
    private String address;
}
