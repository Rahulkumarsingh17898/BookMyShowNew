package com.rkstech.bookyourshow.models;

import com.rkstech.bookyourshow.enums.PaymentMode;
import com.rkstech.bookyourshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Payment extends BaseModel {
    @Enumerated
    private PaymentMode mode;

    @Enumerated
    private PaymentStatus status;
    private Double amount;
    private String reference;
}
