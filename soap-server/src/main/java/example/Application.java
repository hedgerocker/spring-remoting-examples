package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;
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

    @Bean
    public SimpleJaxWsServiceExporter httpInvokerServiceExporter(){
        SimpleJaxWsServiceExporter simpleJaxWsServiceExporter = new SimpleJaxWsServiceExporter();
        simpleJaxWsServiceExporter.setBaseAddress("http://localhost:8888/article.service/");
        return simpleJaxWsServiceExporter;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
