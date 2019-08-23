package global.com;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ComApplication {

    public static void main(String[] args) {

        SpringApplication.run(ComApplication.class, args);
    }

}
