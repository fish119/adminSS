package site.fish119.adminss;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = "site.fish119.adminss")
@SpringBootApplication
//@EnableCaching
@EnableSwagger2
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
@EnableAdminServer
public class AdminssApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminssApplication.class, args);
    }
}
