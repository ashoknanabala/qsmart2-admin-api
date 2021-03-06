package com.vm.qsmart2api;

import com.vm.qsmart2api.configuration.MssqlDataSource;
import com.vm.qsmart2api.configuration.PropertiesConfiguration;
import com.vm.qsmart2api.configuration.SwaggerConfiguration;
import com.vm.qsmart2api.configuration.WebServerConfig;
import com.vm.qsmart2api.contoller.AuthController;
import com.vm.qsmart2api.contoller.DepartmentController;
import com.vm.qsmart2api.contoller.LevelController;
import com.vm.qsmart2api.contoller.RolesController;
import com.vm.qsmart2api.contoller.ServiceController;
//import com.vm.qsmart2api.contoller.BranchController;
import com.vm.qsmart2api.contoller.UserController;
import com.vm.qsmart2api.contoller.MenuController;
import com.vm.qsmart2api.services.DepartmentService;
import com.vm.qsmart2api.services.LevelService;
import com.vm.qsmart2api.services.RolesService;
import com.vm.qsmart2api.services.ServiceService;
//import com.vm.qsmart2api.services.BranchService;
import com.vm.qsmart2api.utils.DBConstants;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

@Import({
    DispatcherServletAutoConfiguration.class,
    EmbeddedWebServerFactoryCustomizerAutoConfiguration.class,
    ErrorMvcAutoConfiguration.class,
    HttpEncodingAutoConfiguration.class,
    HttpMessageConvertersAutoConfiguration.class,
    JacksonAutoConfiguration.class,
    PropertyPlaceholderAutoConfiguration.class,
    ServletWebServerFactoryAutoConfiguration.class,
    PropertiesConfiguration.class,
    SwaggerConfiguration.class,
    Swagger2DocumentationConfiguration.class,
    WebServerConfig.class,
    WebMvcAutoConfiguration.class,
    UserController.class,
    MssqlDataSource.class,
    //BranchService.class,
    //BranchController.class,
    ServiceController.class,
    ServiceService.class,
    LevelController.class,
    LevelService.class,
    DepartmentController.class,
    DepartmentService.class,
    RolesController.class,
    RolesService.class
    
    })
//@SpringBootApplication
public class Qsmart2ApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Qsmart2ApiApplication.class, args);
        String[] beans = ctx.getBeanDefinitionNames();
        for (String s : beans) {
           // System.out.println("Bean Name : " + s);
        }
    }

    @Autowired
    @PersistenceContext(name = DBConstants.JPA_UNIT_NAME_QSMART)
    EntityManager entityManager;

    @Override
    public void run(String... args) throws Exception {
        //   System.out.println("----------->"+entityManager.toString());
    }
}
