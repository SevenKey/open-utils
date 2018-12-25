package sevenkey.open.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author weijianyu
 */
@SpringBootApplication(scanBasePackages = "sevenkey.open.utils")
public class ApplicationLoader {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationLoader.class);
        application.run(args);
    }
}


