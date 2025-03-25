package com.metacoding.bankv1.account;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Table(name = "account_tb")
@Entity
public class Account {
    @Id
    private Integer number; //계좌번호 Pk 사용자로부터 받아서 넣음 auto_increment 없음
    private String password;
    private Integer balance;
    private String userId; //FK
    private Timestamp createdAt;
}
