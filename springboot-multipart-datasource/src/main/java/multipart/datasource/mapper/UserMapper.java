package multipart.datasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import multipart.datasource.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 表示 user的持久层
 *
 * @author lihh
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
