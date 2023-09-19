package multipart.datasource.service;

import multipart.datasource.entity.Account;
import multipart.datasource.entity.User;

import java.util.List;

public interface UserOrAccountService {
  List<User> getUserList();
  
  List<Account> getAccountList();
}
