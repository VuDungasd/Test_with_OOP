package org.example.Bai_2;

public class Node {
  public Number payload;
  public Node next;

  /**
   * Constructor với payload.
   *
   * @param payload Giá trị của node.
   */
  public Node(Number payload) {
    this.payload = payload;
    this.next = null;
  }

  /**
   * Constructor với payload và next.
   *
   * @param payload Giá trị của node.
   * @param next Node tiếp theo trong danh sách.
   */
  public Node(Number payload, Node next) {
    this.payload = payload;
    this.next = next;
  }
}
