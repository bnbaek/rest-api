package net.openu.test;


import net.openu.test.config.TestProfile;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;

@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles(TestProfile.TEST)
@Ignore
public class MockTest {

}