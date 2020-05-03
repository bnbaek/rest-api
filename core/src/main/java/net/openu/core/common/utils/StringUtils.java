package net.openu.core.common.utils;

import java.util.UUID;

/**
 * Created by iopenu@gmail.com on 2020/05/03
 * Github : https://github.com/bnbaek
 */
public class StringUtils {

  /**
   * UUID를 반환한다.
   * @return String
   */
  public static String getUuidString() {
    return UUID.randomUUID().toString().toUpperCase().replace("-", "");
  }

}
