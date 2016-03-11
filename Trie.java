import java.util.HashMap;
import java.util.Map;

public class Trie {

  private static class Node {
    final Map<Character, Node> children = new HashMap<Character, Node>();
    boolean isWord;

    public Node(boolean isWord) {
      this.isWord = isWord;
    }
  }

  private final Node root = new Node(true);

  public void add(final String value) {
    Node current = root;
    for (int i = 0; i < value.length(); i++) {
      final char character = value.charAt(i);
      if (current.children.get(character) == null) {
        current.children.put(character, new Node(false));
      }
      current = current.children.get(character);
    }
    current.isWord = true;
  }

  public boolean contains(final String value) {
    Node current = root;
    for (int i = 0; i < value.length(); i++) {
      if ((current = current.children.get(value.charAt(i))) == null) {
        return false;
      }
    }
    return current.isWord;
  }

  public boolean isPrefix(final String value) {
    Node current = root;
    for (int i = 0; i < value.length(); i++) {
      if ((current = current.children.get(value.charAt(i))) == null) {
        return false;
      }
    }
    return true;
  }
}
