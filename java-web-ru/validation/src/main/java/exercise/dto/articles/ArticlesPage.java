package exercise.dto.articles;

import java.util.List;
import exercise.model.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ArticlesPage {
    private List<Article> articles;

    public ArticlesPage(List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        return articles;
    }
}
