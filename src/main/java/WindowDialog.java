import org.primefaces.PrimeFaces;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class WindowDialog {
    private RepoContent repoContent;

    public RepoContent getRepoContent() {
        return repoContent;
    }

    public void setRepoContent(RepoContent repoContent) {
        this.repoContent = repoContent;
    }

    public void createDialogWindow(RepoContent repoContent){
        this.setRepoContent(repoContent);
        PrimeFaces.current().dialog().openDynamic("viewContent");
    }


}
