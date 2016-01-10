package example;

import com.caucho.hessian.client.HessianProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application{

    @Autowired
    ArticleService articleService;

    @PostConstruct
    public void init(){
        System.out.println(articleService.getArticle().getName());
    }

    @Bean
    public HessianProxyFactoryBean hessianProxyFactory(){
        HessianProxyFactoryBean proxy = new HessianProxyFactoryBean();
        proxy.setServiceInterface(ArticleService.class);
        proxy.setServiceUrl("http://localhost:8080/article.service");
        return proxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
