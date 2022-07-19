package bossbabies.com.a.controller;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertiesConfig {
    @Bean
    public PropertiesFactoryBean apiProperties() {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("properties/api.properties"));
        return bean;
    }
}
