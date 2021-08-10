package projectFiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import projectFiles.entity.spring.Product;
import projectFiles.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class ApplicationStarter {
    public static void main(String[] args) {
        try(ConfigurableApplicationContext ctx = SpringApplication.run(ApplicationStarter.class)) {
            final ProductRepository bean = ctx.getBean(ProductRepository.class);
            List<Product> all = bean.getAllByIdNot(0);
            all.forEach(e -> System.out.println(e.toString()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
