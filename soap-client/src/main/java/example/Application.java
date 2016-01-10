package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication
public class Application{

    @Autowired
    ArticleService articleService;

    @PostConstruct
    public void init(){
        System.out.println(articleService.getArticle().getName());
    }

    @Bean
    public JaxWsPortProxyFactoryBean httpInvokerProxyFactoryBean() throws MalformedURLException {
        JaxWsPortProxyFactoryBean proxy = new JaxWsPortProxyFactoryBean();
        proxy.setServiceInterface(ArticleService.class);
        proxy.setWsdlDocumentUrl(new URL("http://localhost:8888/article.service/ArticleSimpleService?wsdl"));
        proxy.setServiceName("ArticleSimpleService");
        proxy.setNamespaceUri("http://example/");
        proxy.setPortName("ArticleServiceSimpleEndpoitPort");
        return proxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
