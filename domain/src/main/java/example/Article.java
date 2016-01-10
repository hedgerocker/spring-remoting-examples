package example;

import java.io.Serializable;

/**
 * Created by piotr on 10/01/16.
 */
public class Article implements Serializable {

  private String name;

  public Article() {
  }

  public Article(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
