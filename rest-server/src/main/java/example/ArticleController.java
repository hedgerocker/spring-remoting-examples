package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by piotr on 10/01/16.
 */
@RestController
public class ArticleController {

  @Autowired
  ArticleService articleService;

  @RequestMapping("/article")
  public Article getArticle(){
    return articleService.getArticle();
  }
}
