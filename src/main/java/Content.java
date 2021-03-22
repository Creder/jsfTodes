import org.primefaces.component.tabview.Tab;
import org.primefaces.event.TabCloseEvent;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class Content {
    private List<Tab> tabs = new ArrayList<>();
    private String content;

    public void createTab(int repoId) throws IOException {
        Tab tab = new Tab();
        RepoElement element = RepoService.getRepoElement(repoId);
        tab.setTitle(element.getName());
        content = element.getContent();
        tab.setClosable(true);
        tabs.add(tab);
    }

    public void closeTab(TabCloseEvent event){
        tabs.remove(event.getTab());
    }

    public String getContent(){
        return content;
    }

    public List<Tab> getTabs() {
        return tabs;
    }

    public void setTabs(ArrayList<Tab> tabs){
        this.tabs = tabs;
    }


}
