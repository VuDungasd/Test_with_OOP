package org.example.Bai_2;

/**
 * Lớp trừu tượng đại diện cho danh sách.
 */
public abstract class MyAbstractList implements MyList {
  /**
   * Mô tả dữ liệu của list.
   *
   * @return mô tả list theo định dạng [a1 a2 a3 ... an]
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < size(); i++) {
      sb.append(get(i)); // Lấy phần tử tại vị trí i
      if (i < size() - 1) {
        sb.append(" "); // Thêm dấu cách giữa các phần tử
      }
    }
    sb.append("]");
    return sb.toString();
  }
}

