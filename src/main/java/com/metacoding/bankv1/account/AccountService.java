package com.metacoding.bankv1.account;

import com.metacoding.bankv1.account.histroy.HistoryRepository;
import com.metacoding.bankv1.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final HistoryRepository historyRepository;

    @Transactional
    public void 계좌생성(AccountRequest.SaveDTO saveDTO, int userId) {
        accountRepository.save(saveDTO.getNumber(), saveDTO.getPassword(), saveDTO.getBalance(), userId);

    }

    public List<Account> 나의계좌목록(Integer userId) {
        return accountRepository.findAllByUserId(userId);
    }

    @Transactional
    public void 계좌이체(AccountRequest.TransferDTO transferDTO, int userId) {
        //
        //1. 출금계좌 조회
        Account withdrawAccount = accountRepository.findByNumber(transferDTO.getWithdrawNumber());
        if (withdrawAccount == null) throw new RuntimeException("출금계좌가 존재하지 않습니다.");
        //2. 입급계좌 조회
        Account depositAccount = accountRepository.findByNumber(transferDTO.getDepositNumber());
        if (depositAccount == null) throw new RuntimeException("입금계좌가 존재하지 않습니다.");
        //3. 출금계좌 없으면 RuntimeException
        if (!(withdrawAccount.getBalance() >= transferDTO.getAmount())) {
            throw new RuntimeException("출금 계좌의 잔액 : " + withdrawAccount.getBalance() + ", 이체하려는 금액 : " + transferDTO.getAmount());
        }
        //4. 출금 비밀번호 확인해서 동일한지 체크
        if ((withdrawAccount.getPassword().equals(transferDTO.getWithdrawPassword()))) {
            throw new RuntimeException("출금 계좌 비밀번호가 틀렸습니다.");
        }
        //5. 로그인한 유저가 출금계좌 주인과 동일한 인물인지 권한 체크
        if (!(withdrawAccount.getUserId().equals(userId))) {
            throw new RuntimeException("출금계좌의 권한이 없습니다.");
        }
        //6. Account Update 출금계좌
        int withrawBalance = withdrawAccount.getBalance();
        withrawBalance = withrawBalance - transferDTO.getAmount();
        accountRepository.updateByNumber(withrawBalance, withdrawAccount.getPassword(), withdrawAccount.getNumber());
        //7. Account Update 출금계좌
        int depositBalance = withdrawAccount.getBalance();
        depositBalance = depositBalance + transferDTO.getAmount();
        accountRepository.updateByNumber(depositBalance, depositAccount.getPassword(), depositAccount.getNumber());

        //10 Histroy Save
        historyRepository.save(transferDTO.getWithdrawNumber(), transferDTO.getDepositNumber(), transferDTO.getAmount(), withrawBalance, depositBalance);

    }

    public void 계좌상세보기(int number, String type, User sessionUser) {
        // 1. 계좌 존재 확인
        Account account = accountRepository.findByNumber(number);
        if (account == null) throw new RuntimeException("계좌가 존재하지 않습니다");

        // 2. 계좌 주인 확인
        AccountResponse.HistoryDTO historyDTO =  historyRepository.findAllByNUmber(Account account, );
        account. (sessionUser));
        sessionUser,

        // 3. 조회해서 주면 됨
Account
        HistoryDTO
        AccountReponse.DetailDTO()
        );
    }
}

