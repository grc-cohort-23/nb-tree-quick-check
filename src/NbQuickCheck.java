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
    // print current node -> system.out.println(root)
    // call preOrder for each child of the current node -> int child : tree.get(root)
    // call preOrder(tree, child) for each child
    System.out.println(root);
    for (int child : tree.get(root)) {
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
    // root == null -> return Integer.MAX_VALUE
    if (root == null) {
      return Integer.MAX_VALUE;
    }
    // min to root.value
    // for each child of root -> Node<Integer> child : root.children
    // min = Math.min(min, minVal(child))
    // return min 
    int min = root.value;
    for (Node<Integer> child : root.children) {
      min = Math.min(min, minVal(child));
    }
    return min;
  }
}
