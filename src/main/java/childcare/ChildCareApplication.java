package childcare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
//those 3 will get replaced by SpringBootApplication
@SpringBootApplication
public class ChildCareApplication {

    public static void main(String ... args){
        SpringApplication.run(ChildCareApplication.class, args);
    }

}
