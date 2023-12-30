package io.matheusVictor.infra.mercadopago.dto;

import jakarta.json.bind.annotation.JsonbProperty;

import java.math.BigDecimal;

public class MpPixDTO {
    private String description;

    @JsonbProperty("payment_method_id")
    private String paymentMethodId;

    @JsonbProperty("transaction_amount")
    private BigDecimal amount;

    private MpPixPayerDTO payer;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public MpPixPayerDTO getPayer() {
        return payer;
    }

    public void setPayer(MpPixPayerDTO payer) {
        this.payer = payer;
    }
}
