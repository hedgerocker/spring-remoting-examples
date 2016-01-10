package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringRmiClientApplication {

	@Bean
	public RmiProxyFactoryBean articleService(){
		RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
		rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1199/ArticleService");
		rmiProxyFactoryBean.setServiceInterface(ArticleService.class);
		return rmiProxyFactoryBean;
	}

	@Autowired ArticleService articleService;

	@PostConstruct
	public void init(){
		System.out.println(articleService.getArticle().getName());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRmiClientApplication.class, args);
	}
}
