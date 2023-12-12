package product.star.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:scores.properties")
public class PropertyConfiguration {
}
