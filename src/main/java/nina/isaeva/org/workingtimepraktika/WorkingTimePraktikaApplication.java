package nina.isaeva.org.workingtimepraktika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJpaRepositories
public class WorkingTimePraktikaApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkingTimePraktikaApplication.class, args);
    }

}
