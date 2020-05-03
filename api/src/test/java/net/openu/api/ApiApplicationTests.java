package net.openu.api;

import net.openu.ApiApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApiApplicationTests {

  @Test
  public void contextLoads() {
    ApiApplication.main(new String[] {});
  }

}
