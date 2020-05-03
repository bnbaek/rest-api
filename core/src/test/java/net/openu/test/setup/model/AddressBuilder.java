package net.openu.test.setup.model;

import net.openu.core.model.Address;

public class AddressBuilder {

  public static Address build() {
    return Address.builder()
        .city("city")
        .detail1("주소1")
        .detail2("주소2")
        .zipCode("zipCode")
        .build();
  }

  public static Address build(String city, String detail1, String detail2, String zipCode) {
    return Address.builder()
        .city(city)
        .detail1(detail1)
        .detail2(detail2)
        .zipCode(zipCode)
        .build();
  }

}
