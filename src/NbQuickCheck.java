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
    for(int n : tree.get(root)){
      preOrder(tree, n);
      System.out.println(n);
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
    if(root == null) return Integer.MAX_VALUE;
    int lowest = Integer.MAX_VALUE;
    for(Node n : root.children){
      int result = minVal(n);
      if(lowest > n.value){
        lowest = n.value;
      }
    }
    return lowest;
  }


  
}
