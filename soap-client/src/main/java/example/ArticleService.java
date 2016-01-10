package example;

import javax.jws.WebService;

/**
 * Created by piotr on 10/01/16.
 */
@WebService
public interface ArticleService {
  Article getArticle();
}
