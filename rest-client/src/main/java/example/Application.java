package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @PostConstruct
    public void init(){
        RestTemplate restTemplate = new RestTemplate();
        Article article = restTemplate.getForObject("http://localhost:8080/article", Article.class);
        System.out.println(article.getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
