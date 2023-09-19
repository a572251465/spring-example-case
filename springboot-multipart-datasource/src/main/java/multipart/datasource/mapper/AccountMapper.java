package multipart.datasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import multipart.datasource.entity.Account;
import org.apache.ibatis.annotations.Mapper;


/**
 * 表示account 持久层
 *
 * @author lihh
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
