package net.openu.test.setup.model;

import net.openu.core.model.Name;

/**
 * Created by iopenu@gmail.com on 2020/05/01
 * Github : https://github.com/bnbaek
 */
public class NameBuilder {

  public static Name build() {
    return Name.builder()
        .first("first")
        .middle("middle")
        .last("last")
        .build();
  }

  public static Name build(String first, String middle, String last) {
    return Name.builder()
        .first(first)
        .middle(middle)
        .last(last)
        .build();
  }

}
