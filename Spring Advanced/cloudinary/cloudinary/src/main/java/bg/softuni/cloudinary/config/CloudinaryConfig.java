package bg.softuni.cloudinary.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "cloudinary")
public class CloudinaryConfig {


    private String cloudMame;
    private String apiKey;
    private String apiSecret;

    public String getCloudMame() {
        return cloudMame;
    }

    public CloudinaryConfig setCloudMame(String cloudMame) {
        this.cloudMame = cloudMame;
        return this;
    }

    public String getApiKey() {
        return apiKey;
    }

    public CloudinaryConfig setApiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    public String getApiSecret() {
        return apiSecret;
    }

    public CloudinaryConfig setApiSecret(String apiSecret) {
        this.apiSecret = apiSecret;
        return this;
    }
}
