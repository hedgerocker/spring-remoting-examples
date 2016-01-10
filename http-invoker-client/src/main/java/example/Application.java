package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

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
    public HttpInvokerProxyFactoryBean httpInvokerProxyFactoryBean(){
        HttpInvokerProxyFactoryBean proxy = new HttpInvokerProxyFactoryBean();
        proxy.setServiceInterface(ArticleService.class);
        proxy.setServiceUrl("http://localhost:8080/article.service");
        return proxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
