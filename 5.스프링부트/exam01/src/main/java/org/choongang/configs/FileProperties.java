package org.choongang.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix="file")  //부트에만 있는 기능
public class FileProperties {   //알아서 설정 중에서 file.url, file.path쪽이 주입된다.
    private String url;
    private String path;
}
