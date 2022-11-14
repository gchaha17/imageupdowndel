package com.example.getmesocialservice.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = ValidNameValidator.class)
public @interface ValidName {
    String message() default "NOT a proper valid name format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}