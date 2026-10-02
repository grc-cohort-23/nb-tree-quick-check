import java.util.List;
import java.util.Map;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    if(!tree.containsKey(root)) {
       return;
    }
    //we visit current node first for preorder 
    System.out.println(root);

    //get children for each current node 
    for(int child : tree.get(root)){
      //then recusre through for each child and it's extended children
      preOrder(tree, child);
    }

  }

  /**
   * Returns the minimum value in the tree.
   * Returns Integer.MAX_VALUE if the root is null.
   *
   * @param root the root node of the tree
   * @return the minimum value in the tree or Integer.MAX_VALUE if root is null
   */
  public static int minVal(Node<Integer> root) {
    // if root is null return Integer.Max_Value as stated above
    if(root == null){
      return Integer.MAX_VALUE;
    }
    //find minimum in left subtree and store as an integer
    // int leftTree = minVal(root.left);
    // //find minimum in right 
    // int rightTree = minVal(root.right);
    
    //restart
    // assume root is minimum, then we compare all children to min 0
    int min = root.value;
    //check each child
    for(Node<Integer> child : root.children){

      //save the minimum child to compare back to min
      int childMin = minVal(child);

      if(childMin<min){
        min = childMin;
      }
    }
    return min;
  }

}
