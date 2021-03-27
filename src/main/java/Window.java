import org.primefaces.PrimeFaces;
import org.primefaces.component.tabview.Tab;
import org.primefaces.event.TabCloseEvent;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class Window {
    private List<CustomTab> tabs = new ArrayList<>();

    public void createTab(RepoElement repoElement) {

        Document content = StringToXml.convert(repoElement.getContent());
        RepoContent repoContent = new RepoContent();

        if (content != null) {
            repoContent.setField1(content.getDocumentElement()
                    .getChildNodes().item(0)
                    .getChildNodes().item(0).getNodeValue());

            repoContent.setField2(content.getDocumentElement()
                    .getChildNodes().item(1)
                    .getChildNodes().item(0).getNodeValue());
        }

        CustomTab tab = new CustomTab(repoElement.getName(), repoContent);
        tab.setClosable(true);
        tabs.add(tab);
    }

    public void closeTab(CustomTab tab){
        tabs.remove(tab);
    }
    public List<CustomTab> getTabs() {
        return tabs;
    }

    public void setTabs(ArrayList<CustomTab> tabs){
        this.tabs = tabs;
    }



}
