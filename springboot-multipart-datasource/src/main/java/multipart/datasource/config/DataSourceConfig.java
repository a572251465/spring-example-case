package multipart.datasource.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
  
  @Bean(name = "DATA_SOURCE_ONE")
  @ConfigurationProperties(prefix = "spring.datasource.data-source-one")
  public DataSource dataSourceOne() {
    DruidDataSource druidDataSource = new DruidDataSource();
    return druidDataSource;
  }
  
  
  @Bean(name = "DATA_SOURCE_TWO")
  @ConfigurationProperties(prefix = "spring.datasource.data-source-two")
  public DataSource dataSourceTwo() {
    DruidDataSource druidDataSource = new DruidDataSource();
    return druidDataSource;
  }
}
