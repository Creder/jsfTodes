import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RepoService {
    public static RepoElement getRepoElement(int repoElementId) throws IOException {
        RepoElement repoElement = new RepoElement();
        URL url;
        if (repoElementId == 0) {
            url = new URL("https://a.todes.by:13201/reposService/api/v1/repository/root");
        }
        else{
            url = new URL("https://a.todes.by:13201/reposService/api/v1/repository/"+repoElementId);
        }
        JSONObject JSONRepoElemet = Utils.getOneJSONObject(url);
        repoElement.setId(JSONRepoElemet.getInt("id"));
        repoElement.setName(JSONRepoElemet.getString("name"));
        repoElement.setContent(JSONRepoElemet.get("content").equals(null) ? null :JSONRepoElemet.getString("content") );
        repoElement.setFolder(JSONRepoElemet.getBoolean("folder"));
        repoElement.setParent(JSONRepoElemet.get("parent").equals(null)? 0 : JSONRepoElemet.getInt("parent") );

        return repoElement;
    }

    public static List<RepoElement> getRepoElements(int repoElementId) throws IOException{
        URL url = new URL("https://a.todes.by:13201/reposService/api/v1/repository/"+repoElementId+"/children");
        List<RepoElement> repoElements = new ArrayList<>();
        JSONArray JSONRepoElemets = Utils.getJSONArray(url);
        for(int i = 0; i < JSONRepoElemets.length(); i++) {
            JSONObject JSONRepoElemet = JSONRepoElemets.getJSONObject(i);
            RepoElement repoElement = new RepoElement();
            repoElement.setId(JSONRepoElemet.getInt("id"));
            repoElement.setName(JSONRepoElemet.getString("name"));
            repoElement.setContent(JSONRepoElemet.get("content").equals(null) ? null : JSONRepoElemet.getString("content"));
            repoElement.setFolder(JSONRepoElemet.getBoolean("folder"));
            repoElement.setParent(JSONRepoElemet.getInt("parent"));
            repoElements.add(repoElement);
        }
        return repoElements;
    }
}
