package example;

import org.springframework.stereotype.Service;

/**
 * Created by piotr on 10/01/16.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  public Article getArticle() {

    return new Article("Sample Name");
  }
}
