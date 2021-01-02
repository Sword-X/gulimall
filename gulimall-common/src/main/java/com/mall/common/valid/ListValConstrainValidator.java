package com.mall.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * 校验器
 * 自定义注解必须实现ConstraintValidator接口，参数1为自定义注解，参数2为待验证的参数类型
 */
public class ListValConstrainValidator implements ConstraintValidator<ListVal, Integer> {

    private Set<Integer> set = new HashSet();
    /**
     * 初始化方法
     * @param constraintAnnotation
     */
    @Override
    public void initialize(ListVal constraintAnnotation) {
        for (int val : constraintAnnotation.vals()) {
            set.add(val);
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
