package multipart.datasource.base;

import multipart.datasource.constant.MultiDataEnum;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.concurrent.ConcurrentHashMap;

@Primary
@Component
public class DataSourceManagement extends AbstractRoutingDataSource {
  
  // 当前的数据源名称
  public static ThreadLocal currentDataSource = new ThreadLocal<String>();
  
  public DataSourceManagement() {
    currentDataSource.set(MultiDataEnum.DATA_SOURCE_ONE.name());
  }
  
  
  @Resource(name = "DATA_SOURCE_ONE")
  private DataSource dataSourceOne;
  @Resource(name = "DATA_SOURCE_TWO")
  private DataSource dataSourceTwo;
  
  @Override
  public void afterPropertiesSet() {
    ConcurrentHashMap<Object, Object> sourceConcurrentHashMap = new ConcurrentHashMap<Object, Object>() {{
      put(MultiDataEnum.DATA_SOURCE_ONE.name(), dataSourceOne);
      put(MultiDataEnum.DATA_SOURCE_TWO.name(), dataSourceTwo);
    }};
    super.setTargetDataSources(sourceConcurrentHashMap);
    super.setDefaultTargetDataSource(dataSourceOne);
    super.afterPropertiesSet();
  }
  
  @Override
  protected Object determineCurrentLookupKey() {
    return currentDataSource.get();
  }
}
