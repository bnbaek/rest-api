package net.openu.core.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.nullValue;

import org.junit.Test;


/**
 * Created by iopenu@gmail.com on 2020/05/01
 * Github : https://github.com/bnbaek
 */
public class EmailTest {

  @Test
  public void email_success(){
    final String value = "momo@test.com";
    final Email email = Email.of(value);

    assertThat(email.getValue(),is(value));
    assertThat(email.getId(),is("momo"));
    assertThat(email.getHost(),is("test.com"));
  }

  @Test
  public void Email_Invalidation_test() {
    final String value = "chees@e1gmailm";
    final Email email = Email.of(value);
    assertThat(email.getValue(), is(value));
    assertThat(email.getId(), is("chees"));
    assertThat(email.getHost(), is("e1gmailm"));
  }

  @Test
  public void Email_Invalidation() {
    final String value = "cheese1gmail.com";
    final Email email = Email.of(value);
    assertThat(email.getValue(), is(value));
    assertThat(email.getHost(), is(nullValue()));
    assertThat(email.getId(), is(nullValue()));
  }

  @Test
  public void Email_Invalidation_test_01() {
    final String value = "@asd.com";
    final Email email = Email.of(value);
    assertThat(email.getValue(), is(value));
    assertThat(email.getId(), is(""));
    assertThat(email.getHost(), is("asd.com"));
  }

}