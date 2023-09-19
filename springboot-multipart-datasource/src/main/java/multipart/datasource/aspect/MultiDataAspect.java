package multipart.datasource.aspect;

import multipart.datasource.annotate.TargetDataSource;
import multipart.datasource.base.DataSourceManagement;
import multipart.datasource.constant.MultiDataEnum;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 多数据源 切面
 *
 * @author lihh
 */
@Component
@Aspect
public class MultiDataAspect {
  
  
  /**
   * 表示AOP的 前置处理器
   *
   * @param joinPoint
   * @auther lihh
   */
  @Before("execution(* multipart.datasource.service.impl.*.*(..))")
  public void before(JoinPoint joinPoint) {
    Class<? extends JoinPoint> currClass = joinPoint.getClass();
    
    // 判断指定的注解 是否被标注到类上
    if (currClass.isAnnotationPresent(TargetDataSource.class)) {
      DataSourceManagement.currentDataSource.set(currClass.getAnnotation(TargetDataSource.class).value().name());
    } else {
      Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
      // 判断指定的注解 是否被准备在方法上
      if (method.isAnnotationPresent(TargetDataSource.class)) {
        DataSourceManagement.currentDataSource.set(method.getAnnotation(TargetDataSource.class).value().name());
      } else {
        
        // 默认就是选择注解1
        DataSourceManagement.currentDataSource.set(MultiDataEnum.DATA_SOURCE_ONE.name());
      }
    }
  }
}
