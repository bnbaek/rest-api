package net.openu.core.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;


public class AddressTest {

  @Test
  public void address() {
    final Address address = Address.builder()
        .detail1("detail1")
        .detail2("detail2")
        .city("city")
        .zipCode("zipcode")
        .build();

    assertThat(address.getCity(), is("city"));
    assertThat(address.getDetail1(), is("detail1"));
    assertThat(address.getDetail2(), is("detail2"));
    assertThat(address.getZipCode(), is("zipcode"));
    assertThat(address.getFullAddress(), is("detail1 detail2 zipcode"));
  }

}