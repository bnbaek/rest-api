package net.openu.api.v1.account;

import net.openu.core.domain.account.Account;
import org.springframework.http.HttpStatus;
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
public class AccountController {

  @RequestMapping(method = RequestMethod.POST)
  @ResponseStatus(value = HttpStatus.CREATED)
  public AccountDto.Response signUp(@RequestBody final AccountDto.SignUpReq request) {
    return AccountDto.Response.of(null);
  }
}
