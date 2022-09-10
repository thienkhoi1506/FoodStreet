package com.streetfood.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
//import com.streetfood.validator.WebAppValidator;
import com.streetfood.formatter.CategoryFormatter;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.swing.text.html.HTML;
import java.util.HashSet;
import java.util.Set;
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
        "com.streetfood.controller",
        "com.streetfood.service",
        "com.streetfood.repository",
})
public class WebAppContextConfig implements WebMvcConfigurer {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/js/**", "/css/**")
                .addResourceLocations("/resources/js/", "/resources/css/");
    }
    // default view resolver
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        resolver.setMaxUploadSize(150000);
        return resolver;
    }

    @Bean
    public StandardServletMultipartResolver servletMultipartResolver(){
        return new StandardServletMultipartResolver();
    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CategoryFormatter());
    }

//    @Override
//    public Validator getValidator() {
//        return validator();
//    }
//
//    @Bean
//    public Validator validator() {
//        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
//        v.setValidationMessageSource(messageSource());
//
//        return v;
//    }
//
//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
//        m.setBasenames("messages");
//
//        return m;
//    }

}
