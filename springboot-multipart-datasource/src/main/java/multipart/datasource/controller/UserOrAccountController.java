package multipart.datasource.controller;

import multipart.datasource.entity.Account;
import multipart.datasource.entity.User;
import multipart.datasource.service.UserOrAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/select")

public class UserOrAccountController {
  
  
  @Autowired
  private UserOrAccountService userOrAccountService;
  
  @GetMapping("/user")
  public List<User> getUserList() {
    return userOrAccountService.getUserList();
  }
  
  @GetMapping("/account")
  public List<Account> getAccountList() {
    return userOrAccountService.getAccountList();
  }
}
