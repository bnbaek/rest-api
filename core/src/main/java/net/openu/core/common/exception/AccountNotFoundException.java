package net.openu.core.common.exception;

import lombok.Getter;

/**
 * Created by iopenu@gmail.com on 2020/05/03
 * Github : https://github.com/bnbaek
 */
@Getter
public class AccountNotFoundException extends RuntimeException {

  private String code;

  public AccountNotFoundException(String code) {
    super("사용자 정보를 확인를 찾을 수 없습니다.");
    this.code = code;
  }

  public AccountNotFoundException() {
    super("사용자 정보를 확인를 찾을 수 없습니다.");
  }


}
