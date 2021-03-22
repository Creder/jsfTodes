import org.primefaces.shaded.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class RepoElement{
    int id;
    String name;
    String content;
    boolean folder;
    int parent;

    public RepoElement(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFolder() {
        return folder;
    }

    public void setFolder(boolean folder) {
        this.folder = folder;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }



}
