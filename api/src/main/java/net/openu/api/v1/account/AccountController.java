package net.openu.api.v1.account;

import lombok.RequiredArgsConstructor;
import net.openu.core.domain.account.AccountDto;
import net.openu.core.domain.account.AccountDto.UpdateAddressReq;
import net.openu.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by iopenu@gmail.com on 2020/05/03
 * Github : https://github.com/bnbaek
 */

@RestController
@RequestMapping(value = {"/api/accounts"})

@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public AccountDto.Response signUp(@RequestBody final AccountDto.SignUpReq request) {
    return AccountDto.Response.of(accountService.create(request));
  }

  @RequestMapping(value = "/{code}", method = RequestMethod.GET)
  @ResponseStatus(value = HttpStatus.OK)
  public AccountDto.Response getUser(@PathVariable final String code) {
    return AccountDto.Response.of(accountService.getAccount(code));
  }

  @RequestMapping(value = "/{code}/address", method = RequestMethod.PUT)
  @ResponseStatus(value = HttpStatus.OK)
  public AccountDto.Response updateMyAccount(@PathVariable final String code, @RequestBody final UpdateAddressReq request) {
    return AccountDto.Response.of(accountService.updateAddress(code,request));
  }
}
