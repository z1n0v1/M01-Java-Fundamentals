package L07ObjectsAndClasses.Exercise.T02Articles;

public class Article {
    private String title, content, author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String content) {
        this.content = content;
    }

    public void changeAuthor(String author) {
        this.author = author;
    }

    public void rename(String title) {
        this.title = title;
    }

    public String toString() {
        return title + " -" + content + ":" + author;
    }
}
