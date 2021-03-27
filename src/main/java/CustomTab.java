import org.primefaces.component.tabview.Tab;
import org.w3c.dom.Document;

public class CustomTab extends Tab {
    private RepoContent content;

    public CustomTab(String title, RepoContent content){
        super.setTitle(title);
        this.content = content;
    }

    public RepoContent getContent() {
        return content;
    }

    public String getTitle() {
        return super.getTitle();
    }

    public void setContent(RepoContent content) {
        this.content = content;
    }

    public void setTitle(String title) {
        super.setTitle(title);
    }
}
