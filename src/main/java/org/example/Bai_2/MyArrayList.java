package org.example.Bai_2;

import java.util.NoSuchElementException;

public class MyArrayList extends MyAbstractList {
  private static final int DEFAULT_CAPACITY = 8;
  private Number[] data;
  private int size;

  /**
   * Khởi tạo dữ liệu mặc định.
   */
  public MyArrayList() {
    data = new Number[DEFAULT_CAPACITY];
    size = 0;
  }

  /**
   * Lấy kích thước của list.
   *
   * @return Số lượng phần tử trong danh sách.
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Lấy phần tử ở vị trí index trong list.
   *
   * @param index Vị trí cần lấy phần tử.
   * @return Phần tử tại vị trí index.
   * @throws IndexOutOfBoundsException nếu index không hợp lệ.
   */
  @Override
  public Number get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    return data[index];
  }

  /**
   * Xóa phần tử ở vị trí index trong list.
   *
   * @param index Vị trí của phần tử cần xóa.
   * @throws IndexOutOfBoundsException nếu index không hợp lệ.
   */
  @Override
  public void remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    for (int i = index; i < size - 1; i++) {
      data[i] = data[i + 1];
    }
    data[--size] = null; // Giải phóng phần tử cuối cùng
  }

  /**
   * Thêm phần tử có dữ liệu payload vào cuối list.
   * Nếu danh sách hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
   *
   * @param payload Giá trị cần thêm.
   */
  @Override
  public void append(Number payload) {
    if (size == data.length) {
      enlarge();
    }
    data[size++] = payload;
  }

  /**
   * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
   * Nếu list hết chỗ, cấp phát thêm gấp đôi chỗ cho list.
   *
   * @param payload Giá trị cần thêm.
   * @param index   Vị trí cần thêm phần tử.
   * @throws IndexOutOfBoundsException nếu index không hợp lệ.
   */
  @Override
  public void insert(Number payload, int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    if (size == data.length) {
      enlarge();
    }
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    data[index] = payload;
    size++;
  }

  /**
   * Tạo iterator để có thể duyệt qua các phần tử của list.
   *
   * @return Iterator cho MyArrayList.
   */
  @Override
  public MyIterator iterator() {
    return new MyArrayListIterator(0);
  }

  /**
   * Cấp phát gấp đôi chỗ cho danh sách khi cần thiết.
   */
  private void enlarge() {
    Number[] newData = new Number[data.length * 2];
    System.arraycopy(data, 0, newData, 0, size);
    data = newData;
  }

  private class MyArrayListIterator implements MyIterator {
    private int currentPosition;

    /**
     * Khởi tạo dữ liệu cho iterator tại vị trí position của list.
     */
    public MyArrayListIterator(int position) {
      this.currentPosition = position;
    }

    /**
     * Kiểm tra trong MyArrayList có còn phần tử không.
     *
     * @return true nếu còn phần tử, false nếu không.
     */
    @Override
    public boolean hasNext() {
      return currentPosition < size;
    }

    /**
     * Iterator dịch chuyển sang phần tử kế tiếp của MyArrayList và trả ra dữ liệu
     * của phần tử hiện tại của MyArrayList.
     *
     * @return Dữ liệu phần tử hiện tại.
     * @throws NoSuchElementException nếu không còn phần tử nào.
     */
    @Override
    public Number next() {
      if (!hasNext()) {
        throw new NoSuchElementException("No more elements to iterate.");
      }
      return data[currentPosition++];
    }

    /**
     * Iterator xóa phần tử hiện tại của MyArrayList.
     */
    @Override
    public void remove() {
      if (currentPosition <= 0 || currentPosition > size) {
        throw new IllegalStateException("Invalid state for remove operation.");
      }
      MyArrayList.this.remove(--currentPosition);
    }
  }
}
