package net.openu.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

import java.util.Optional;
import net.openu.api.v1.account.AccountDto;
import net.openu.api.v1.account.AccountDto.SignUpReq;
import net.openu.core.common.exception.AccountNotFoundException;
import net.openu.core.domain.account.Account;
import net.openu.core.domain.account.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;


/**
 * Created by iopenu@gmail.com on 2020/05/03
 * Github : https://github.com/bnbaek
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

  @InjectMocks
  private AccountService accountService;

  @Mock
  private AccountRepository accountRepository;

  @Test
  public void sign_회원가입_성공() {
    //given
    final AccountDto.SignUpReq request = buildSignUpRequest();
    given(accountRepository.save(any(Account.class))).willReturn(request.toEntity());

    //when
    final Account account = accountService.create(request);

    //then
    verify(accountRepository, atLeastOnce()).save(any(Account.class));
    assertThatEqual(request, account);
  }

  @Test
  public void findById_존재하는경우_회원리턴() {
    //given
    final AccountDto.SignUpReq request = buildSignUpRequest();

    given(accountRepository.findByCode(anyString())).willReturn(Optional.of(request.toEntity()));

    //when
    final Account account = accountService.getAccount(anyString());

    //then
    verify(accountRepository, atLeastOnce()).findByCode(anyString());
    assertThatEqual(request, account);
  }

  @Test(expected = AccountNotFoundException.class)
  public void findById_존재하지않는경우() {
    //given

    given(accountRepository.findByCode(anyString())).willReturn(Optional.empty());

    //when
    final Account account = accountService.getAccount(anyString());


  }


  private SignUpReq buildSignUpRequest() {
    return AccountDto.SignUpReq.builder()
        .email("email")
        .password("비밀번호")
        .firstName("이름")
        .lastName("성")
        .address1("주소1")
        .address2("주소2")
        .zipCode("우편번호")
        .build();
  }


  private void assertThatEqual(AccountDto.SignUpReq signUpReq, Account account) {
    assertThat(signUpReq.getAddress1(), is(account.getAddress1()));
    assertThat(signUpReq.getAddress2(), is(account.getAddress2()));
    assertThat(signUpReq.getZipCode(), is(account.getZipCode()));
    assertThat(signUpReq.getEmail(), is(account.getEmail()));
    assertThat(signUpReq.getFirstName(), is(account.getFirstName()));
    assertThat(signUpReq.getLastName(), is(account.getLastName()));
    assertThat(signUpReq.getPassword(), is(account.getPassword()));
  }


}