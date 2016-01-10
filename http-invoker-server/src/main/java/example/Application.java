package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    };

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servlet = new ServletRegistrationBean(dispatcherServlet(), "*.service");
        return servlet;
    }

    @Bean(name = "/article.service")
    public HttpInvokerServiceExporter httpInvokerServiceExporter(ArticleService articleService){
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(ArticleService.class);
        exporter.setService(articleService);
        return exporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
