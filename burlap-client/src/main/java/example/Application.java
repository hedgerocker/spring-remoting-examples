package example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.BurlapProxyFactoryBean;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application{

    @Autowired
    ArticleService articleService;

    @Bean
    public InitializingBean init(final ArticleService articleService){
        return () -> System.out.println(articleService.getArticle().getName());
    }

    @Bean
    public BurlapProxyFactoryBean hessianProxyFactory(){
        BurlapProxyFactoryBean proxy = new BurlapProxyFactoryBean();
        proxy.setServiceInterface(ArticleService.class);
        proxy.setServiceUrl("http://localhost:8080/article.service");
        return proxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
