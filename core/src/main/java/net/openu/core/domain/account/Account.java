package net.openu.core.domain.account;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.openu.core.common.utils.StringUtils;
import net.openu.core.domain.account.AccountDto.UpdateAddressReq;

@Entity
@Table(name = "account")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "account_id", updatable = false, unique = true)
  private Long id;

  @Column(name = "account_code", updatable = false, unique = true)
  private String code;

  @Column(name = "email", nullable = false, unique = true)
  private String email;
  @Column(name = "first_name", nullable = false)
  private String firstName;
  @Column(name = "last_name", nullable = false)
  private String lastName;
  @Column(name = "password", nullable = false)
  private String password;
  @Column(name = "address1", nullable = false)
  private String address1;
  @Column(name = "address2", nullable = false)
  private String address2;
  @Column(name = "zip_code", nullable = false)
  private String zipCode;

  @Column(name = "created_at")
  private LocalDateTime createdAt;
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Builder
  public Account(Long id, String email, String firstName, String lastName, String password, String address1, String address2,
      String zipCode) {
    this.id = id;
    this.email = email;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.address1 = address1;
    this.address2 = address2;
    this.zipCode = zipCode;
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
    this.code = StringUtils.getUuidString();
  }

  public Account updateAddress(UpdateAddressReq request) {
    this.zipCode = request.getZipCode();
    this.address1 = request.getAddress1();
    this.address2 = request.getAddress2();
    this.updatedAt = LocalDateTime.now();
    return this;

  }

}