package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;

@SpringBootApplication
public class SpringRmiExampleApplication {

	@Bean
	public RmiServiceExporter rmiServiceExporter(ArticleService articleService){
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setService(articleService);
		rmiServiceExporter.setServiceName("ArticleService");
		rmiServiceExporter.setServiceInterface(ArticleService.class);
		rmiServiceExporter.setRegistryPort(1199);
		return rmiServiceExporter;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringRmiExampleApplication.class, args);
	}
}
