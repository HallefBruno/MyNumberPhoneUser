
package com.mynumber.phone.user.annotation;

import java.util.List;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.ObjectUtils;


public class NotEmptyListValidator implements ConstraintValidator<NotEmptyList, List> {

  @Override
  public boolean isValid(List t, ConstraintValidatorContext cvc) {
    return !ObjectUtils.isEmpty(t);
  }
  
}
