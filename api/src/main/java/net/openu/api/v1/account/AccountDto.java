package net.openu.api.v1.account;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.openu.core.domain.account.Account;

/**
 * Created by iopenu@gmail.com on 2020/05/03
 * Github : https://github.com/bnbaek
 */
public class AccountDto {

  @Getter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  public static class SignUpReq {

    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String address1;
    private String address2;
    private String zipCode;

    @Builder
    public SignUpReq(String email, String firstName, String lastName, String password, String address1, String address2,
        String zipCode) {
      this.email = email;
      this.firstName = firstName;
      this.lastName = lastName;
      this.password = password;
      this.address1 = address1;
      this.address2 = address2;
      this.zipCode = zipCode;
    }

    public Account toEntity() {
      return Account.builder()
          .email(this.email)
          .firstName(this.firstName)
          .lastName(this.lastName)
          .password(this.password)
          .address1(this.address1)
          .address2(this.address2)
          .zipCode(this.zipCode)
          .build();
    }
  }


  @Getter
  @JsonPropertyOrder(value = {"code","email"})
  public static class Response {

    private String code;
    private String email;
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String zipCode;

    public Response(Account account) {
      this.code = account.getCode();
      this.email = account.getEmail();
      this.firstName = account.getFirstName();
      this.lastName = account.getLastName();
      this.address1 = account.getAddress1();
      this.address2 = account.getAddress2();
      this.zipCode = account.getZipCode();

    }

    public static Response of(Account account) {
      return new Response(account);

    }
  }
}
