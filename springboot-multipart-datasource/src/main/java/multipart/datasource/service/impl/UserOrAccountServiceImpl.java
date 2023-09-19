package multipart.datasource.service.impl;

import multipart.datasource.annotate.TargetDataSource;
import multipart.datasource.constant.MultiDataEnum;
import multipart.datasource.entity.Account;
import multipart.datasource.entity.User;
import multipart.datasource.mapper.AccountMapper;
import multipart.datasource.mapper.UserMapper;
import multipart.datasource.service.UserOrAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOrAccountServiceImpl implements UserOrAccountService {
  
  
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private AccountMapper accountMapper;
  
  
  @Override
  @TargetDataSource(MultiDataEnum.DATA_SOURCE_TWO)
  public List<User> getUserList() {
    return userMapper.selectList(null);
  }
  
  @TargetDataSource(MultiDataEnum.DATA_SOURCE_ONE)
  @Override
  public List<Account> getAccountList() {
    return accountMapper.selectList(null);
  }
}
