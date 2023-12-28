package configs;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class FileProperty {
    private String url;
    private String path;
}
