package multipart.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan("multipart.datasource.mapper")
@EnableAspectJAutoProxy
public class SpringbootMultipartDatasourceApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringbootMultipartDatasourceApplication.class, args);
  }
}
