package com.sapient.creditcardprovider.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardProviderRequest {
    @ApiModelProperty(required = true, value = "Credit Card Account Name")
    private String name;
    @ApiModelProperty(required = true, value = "Credit Card Account Number")
    @Pattern(regexp = "^\\d{1,19}$")
    private String cardNumber;
    @ApiModelProperty(required = true, value = "Credit Card Limit")
    private BigDecimal limit;
}
