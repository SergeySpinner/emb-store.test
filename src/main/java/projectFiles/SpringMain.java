package projectFiles;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try(final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext("projectFiles")){
            final String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
            System.out.println(Arrays.toString(beanDefinitionNames));

        }
    }
}
