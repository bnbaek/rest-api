package net.openu.api.v1.account;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.openu.core.domain.account.AccountDto;
import net.openu.core.domain.account.AccountDto.SignUpReq;
import net.openu.core.domain.account.Account;
import net.openu.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;


/**
 * Created by iopenu@gmail.com on 2020/05/03
 * Github : https://github.com/bnbaek
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {

  @InjectMocks
  private AccountController accountController;

  @Mock
  private AccountService accountService;

  private ObjectMapper objectMapper = new ObjectMapper();

  private MockMvc mockMvc;


  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(accountController)
        .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 필터 추가
        .alwaysDo(print())
        .build();

  }

  @Test
  public void signUp() throws Exception {
    //given
    final AccountDto.SignUpReq request = buildSignUpRequest();
    given(accountService.create(any())).willReturn(request.toEntity());
    //when
    final ResultActions resultActions = requestSignUp(request);
    //then
    resultActions
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.address1", is(request.getAddress1())))
        .andExpect(jsonPath("$.address2", is(request.getAddress2())))
        .andExpect(jsonPath("$.zipCode", is(request.getZipCode())))
        .andExpect(jsonPath("$.email", is(request.getEmail())))
        .andExpect(jsonPath("$.firstName", is(request.getFirstName())))
        .andExpect(jsonPath("$.lastName", is(request.getLastName())))
    ;

  }

  @Test
  public void getAccount() throws Exception {
    //given
    final AccountDto.SignUpReq request = buildSignUpRequest();
    Account account = request.toEntity();
    given(accountService.getAccount(anyString())).willReturn(account);
    //when
    final ResultActions resultActions = requestGetAccount(account.getCode());

    //then
    //then
    resultActions
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.address1", is(request.getAddress1())))
        .andExpect(jsonPath("$.address2", is(request.getAddress2())))
        .andExpect(jsonPath("$.email", is(request.getEmail())))
        .andExpect(jsonPath("$.firstName", is(request.getFirstName())))
        .andExpect(jsonPath("$.lastName", is(request.getLastName())));
  }

  private ResultActions requestGetAccount(String code) throws Exception {
    return mockMvc.perform(get("/api/accounts/" + code)
        .contentType(MediaType.APPLICATION_JSON))
        .andDo(print());
  }


  private ResultActions requestSignUp(SignUpReq request) throws Exception {
    return mockMvc.perform(post("/api/accounts")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(request)))
        .andDo(print());
  }

  private SignUpReq buildSignUpRequest() {
    return AccountDto.SignUpReq.builder()
        .email("email")
        .password("비밀번호")
        .firstName("이름")
        .lastName("성")
        .address1("주소1")
        .address2("주소2")
        .zipCode("우편번호")
        .build();
  }

}