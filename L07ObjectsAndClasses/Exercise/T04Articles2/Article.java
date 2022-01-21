package L07ObjectsAndClasses.Exercise.T04Articles2;

public class Article {
    private String title, content, author;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

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
