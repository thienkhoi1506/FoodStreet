//package com.streetfood.validator;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.validation.Errors;
//import org.springframework.validation.Validator;
//
//import javax.validation.ConstraintViolation;
//import java.util.Set;
//
//@Component
//public class WebAppValidator implements Validator {
//    @Autowired
//    private javax.validation.Validator beanValidator;
//    private Set<Validator> springValidators;
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return false;
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Set<ConstraintViolation<Object>> beans = this.beanValidator.validate(target);
//        for (ConstraintViolation<Object> obj : beans)
//            errors.rejectValue(obj.getPropertyPath().toString(), obj.getMessageTemplate(), obj.getMessage());
//        for (Validator v : this.springValidators)
//            v.validate(target, errors);
//    }
//
//    public void setSpringValidators(Set<Validator> springValidators) {
//        this.springValidators = springValidators;
//    }
//}
