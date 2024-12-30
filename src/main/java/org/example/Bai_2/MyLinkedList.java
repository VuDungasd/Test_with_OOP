package org.example.Bai_2;

public class MyLinkedList extends MyAbstractList {
  private Node head;

  /**
   * Khởi tạo dữ liệu mặc định.
   */
  public MyLinkedList() {
    head = null;
  }

  /**
   * Lấy kích thước của list.
   *
   * @return Số lượng phần tử trong danh sách.
   */
  @Override
  public int size() {
    int count = 0;
    Node current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  /**
   * Lấy phần tử ở vị trí index trong list.
   *
   * @param index Vị trí của phần tử cần lấy.
   * @return Giá trị của phần tử.
   * @throws IndexOutOfBoundsException nếu index không hợp lệ.
   */
  @Override
  public Number get(int index) {
    Node node = getNodeByIndex(index);
    return node.payload;
  }

  /**
   * Xóa phần tử của list ở vị trí index.
   *
   * @param index Vị trí của phần tử cần xóa.
   * @throws IndexOutOfBoundsException nếu index không hợp lệ.
   */
  @Override
  public void remove(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    if (index == 0) {
      head = head.next;
    } else {
      Node previous = getNodeByIndex(index - 1);
      previous.next = previous.next.next;
    }
  }

  /**
   * Thêm vào cuối list phần tử có dữ liệu payload.
   *
   * @param payload Giá trị cần thêm.
   */
  @Override
  public void append(Number payload) {
    Node newNode = new Node(payload);
    if (head == null) {
      head = newNode;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = newNode;
    }
  }

  /**
   * Thêm vào list phần tử có dữ liệu payload ở vị trí index.
   *
   * @param payload Giá trị cần thêm.
   * @param index   Vị trí cần thêm phần tử.
   * @throws IndexOutOfBoundsException nếu index không hợp lệ.
   */
  @Override
  public void insert(Number payload, int index) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    if (index == 0) {
      head = new Node(payload, head);
    } else {
      Node previous = getNodeByIndex(index - 1);
      previous.next = new Node(payload, previous.next);
    }
  }

  /**
   * Tạo iterator để cho phép duyệt qua các phần tử của list.
   *
   * @return Iterator cho MyLinkedList.
   */
  @Override
  public MyIterator iterator() {
    return new MyLinkedListIterator(0);
  }

  /**
   * Lấy node ở vị trí index.
   *
   * @param index Vị trí của node cần lấy.
   * @return Node tại vị trí index.
   * @throws IndexOutOfBoundsException nếu index không hợp lệ.
   */
  private Node getNodeByIndex(int index) {
    if (index < 0 || index >= size()) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    Node current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current;
  }

  private class MyLinkedListIterator implements MyIterator {
    private int currentPosition;

    /**
     * Khởi tạo cho iterator ở vị trí position trong MyLinkedList.
     *
     * @param position Vị trí bắt đầu của iterator.
     */
    public MyLinkedListIterator(int position) {
      this.currentPosition = position;
    }

    /**
     * Kiểm tra trong MyLinkedList có còn phần tử không.
     * Nếu còn thì trả về true, nếu không còn thì trả về false.
     *
     * @return true nếu còn phần tử, false nếu không.
     */
    @Override
    public boolean hasNext() {
      return currentPosition < size();
    }

    /**
     * Iterator dịch chuyển sang phần tử kế tiếp của MyLinkedList và trả ra dữ liệu (payload) của phần tử hiện tại của MyLinkedList.
     *
     * @return Payload của phần tử hiện tại.
     * @throws IllegalStateException nếu không còn phần tử để duyệt.
     */
    @Override
    public Number next() {
      if (!hasNext()) {
        throw new IllegalStateException("No more elements to iterate.");
      }
      return get(currentPosition++);
    }

    /**
     * Iterator xóa phần tử hiện tại của MyLinkedList.
     *
     * @throws IllegalStateException nếu không hợp lệ để xóa.
     */
    @Override
    public void remove() {
      if (currentPosition <= 0 || currentPosition > size()) {
        throw new IllegalStateException("Invalid state for remove operation.");
      }
      MyLinkedList.this.remove(--currentPosition);
    }
  }
}
