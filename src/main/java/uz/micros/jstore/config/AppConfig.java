package uz.micros.jstore.config;


import com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan(basePackages = "uz.micros.jstore")
@PropertySource("classpath:app.properties")
public class AppConfig {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(){
        PropertyPlaceholderConfigurer res = new PropertyPlaceholderConfigurer();

        res.setLocation(new ClassPathResource("app.properties"));
        res.setIgnoreUnresolvablePlaceholders(true);

        return res;
    }
}

