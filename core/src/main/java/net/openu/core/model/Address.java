package net.openu.core.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Address {

  @NotEmpty
  @Column(name = "detail1")
  private String detail1;

  @NotEmpty
  @Column(name = "detail2")
  private String detail2;

  @NotEmpty
  @Column(name = "city")
  private String city;

  @NotEmpty
  @Column(name = "zip_code")
  private String zipCode;

  @Builder
  public Address(final String city, final String detail1, final String detail2, final String zipCode) {
    this.city = city;
    this.detail1 = detail1;
    this.detail2 = detail2;
    this.zipCode = zipCode;
  }

  public String getFullAddress() {
    return String.format("%s %s %s", this.detail1, this.detail2, this.zipCode);
  }
}
