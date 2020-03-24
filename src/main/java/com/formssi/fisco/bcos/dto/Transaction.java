package com.formssi.fisco.bcos.dto;

import lombok.Data;

@Data
public class Transaction {
    private String hash;
    private String receiptData;
    private String receiptInfo;

}
