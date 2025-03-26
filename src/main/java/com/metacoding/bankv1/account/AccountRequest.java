package com.metacoding.bankv1.account;

import lombok.Data;

public class AccountRequest {


//    public record TransferDTO(
//        Integer withdrawNumber,
//        Integer depositNumber,
//        Integer amount,
//        String withdrawPassword
//    ){}

    @Data
    public static class TransferDTO{
        private Integer withdrawNumber;
        private Integer depositNumber;
        private Integer amount;
        private Integer withdrawPassword;
    }

    @Data
    public static class SaveDTO{
        private Integer number;
        private String password;
        private Integer balance;
    }
}
