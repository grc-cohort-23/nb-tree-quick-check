import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NbQuickCheck {

  /**
   * Performs a pre-order traversal of the tree, printing each node on a separate line.
   * Does nothing if the root is not present in the tree.
   *
   * @param tree the tree represented as a map of parent nodes to child lists
   * @param root the root node to start traversal from
   */
  public static void preOrder(Map<Integer, List<Integer>> tree, int root) {
    if(!tree.containsKey(root)) return;
    Stack<Integer> stack = new Stack<>();
    
    stack.add(root);
    while (!stack.isEmpty()) {
      Integer node = stack.pop();
      // Print pre-order
      System.out.println(node);
      // Get the children of the current node
      List<Integer> children = tree.getOrDefault(node, new ArrayList<>());
      // For each child, in reverse order
      for (int i=children.size()-1;i>=0; i--) {
        // Add it to the stack
        stack.add(children.get(i));
      }
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
    int minimumValue = Integer.MAX_VALUE;
    if (root == null) return minimumValue;
    // Compare the root's value with the largest possible number.
    minimumValue = Math.min(minimumValue,root.value);

    // If this root has no children, return only its value compared.
    if (root.children == null) return minimumValue;
    // For each child, check the smallest value its children have, and compare it with this node's smallest value.
    for (Node<Integer> child : root.children) minimumValue = Math.min(minimumValue,minVal(child));

    // Return the smallest value among itself and its children.
    return minimumValue;
  }
  
}
