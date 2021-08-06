package projectFiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import projectFiles.entity.spring.User;
import projectFiles.repository.UserRepository;

import java.util.List;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        try(ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class)) {
            final UserRepository bean = ctx.getBean(UserRepository.class);
            List<User> all = bean.testQuery2(17);
            all.forEach(e -> System.out.println(e.toString()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
