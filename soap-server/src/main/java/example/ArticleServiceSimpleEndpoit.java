package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by piotr on 10/01/16.
 */
@Component
@WebService(serviceName = "ArticleSimpleService")
public class ArticleServiceSimpleEndpoit {

  @Autowired
  ArticleService articleService;

  @WebMethod
  public Article getArticle(){
    return this.articleService.getArticle();
  }
}
