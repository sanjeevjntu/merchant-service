package com.sanjeev.retail.merchant.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
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

    @Schema(description = "Name of the Merchant.", example = "Sanjeev", required = true)
    @NotBlank
    @Indexed(unique = true, useGeneratedName = true)
    private String name;

    @Schema(description = "Phone number of the Merchant.", example = "123-2345-456", required = true)
    @NotBlank
    @Size(min = 10, max = 20)
    private String phone;

    @Schema(description = "Email of the Merchant.", example = "test@test.com", required = true)
    @Email
    private String email;

    @Schema(description = "Address of the Merchant.", example = "3245 XYZ street, XXX dr, MI, USA", required = true)
    @NotBlank
    private String address;
}
