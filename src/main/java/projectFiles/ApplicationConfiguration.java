package projectFiles;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"projectFiles.dao", "projectFiles.service"})
public class ApplicationConfiguration {

//    @Bean
//    public DataSource getDataSource(){
//        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
//        pgSimpleDataSource.setUser();
//        pgSimpleDataSource.setUrl();
//        pgSimpleDataSource.setPassword();
//
//        return null;
//    } 1 37 55
}
