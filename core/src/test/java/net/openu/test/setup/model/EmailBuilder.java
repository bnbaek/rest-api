package net.openu.test.setup.model;

import net.openu.core.model.Email;

/**
 * Created by iopenu@gmail.com on 2020/05/01
 * Github : https://github.com/bnbaek
 */
public class EmailBuilder {

  public static Email build() {
    return Email.of("momo@test.com");
  }

  public static Email build(final String email) {
    return Email.of(email);
  }

}
