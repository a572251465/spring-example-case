package multipart.datasource.annotate;

import multipart.datasource.constant.MultiDataEnum;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDataSource {
  MultiDataEnum value() default MultiDataEnum.DATA_SOURCE_ONE;
}
