package net.openu.service;

import lombok.RequiredArgsConstructor;
import net.openu.api.v1.account.AccountDto;
import net.openu.core.common.exception.AccountNotFoundException;
import net.openu.core.domain.account.Account;
import net.openu.core.domain.account.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iopenu@gmail.com on 2020/05/03
 * Github : https://github.com/bnbaek
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;

  @Transactional
  public Account create(AccountDto.SignUpReq request) {
    return accountRepository.save(request.toEntity());
  }

  public Account getAccount(final String code) {
    return accountRepository.findByCode(code).orElseThrow(() -> new AccountNotFoundException(code));
  }

}
