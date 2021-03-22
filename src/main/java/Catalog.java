
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.faces.bean.ManagedBean;
import java.io.IOException;
import java.util.List;

@ManagedBean
public class Catalog {

    public TreeNode getRoot() throws IOException {
        RepoElement repoRoot = RepoService.getRepoElement(0);
        TreeNode root = new DefaultTreeNode(repoRoot, null);
        getTreeNodes(root);
        return root;
    }

    public void getTreeNodes(TreeNode root) throws IOException {
        RepoElement repoRoot = (RepoElement)root.getData();
        List<RepoElement> repoElementList = RepoService.getRepoElements(repoRoot.getId());
        for (RepoElement element : repoElementList){
            TreeNode childNode = new DefaultTreeNode(element,root);
            if(element.isFolder()){
                getTreeNodes(childNode);
            }
            root.getChildren().add(childNode);
        }

    }

}

