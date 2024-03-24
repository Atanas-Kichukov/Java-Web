package bg.softuni.cloudinary.config;

import com.cloudinary.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AppConfig {

    private final CloudinaryConfig config;

    public AppConfig(CloudinaryConfig config) {
        this.config = config;
    }

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(
                Map.of(
                        "cloud_name", config.getCloudMame(),
                        "api_key",config.getApiKey(),
                        "api_secret",config.getApiSecret()
                )


        );
    }
}
