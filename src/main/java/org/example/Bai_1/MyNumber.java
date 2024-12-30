package org.example.Bai_1;

import java.util.ArrayList;
import java.util.List;

public class MyNumber {
  private String numberPresentation; // Biểu diễn số ban đầu
  private int radix;                // Cơ số của số ban đầu
  private List<NumberConverter> converters; // Danh sách các converter theo observer pattern

  public MyNumber(String originalNumber, int radix) {
    this.numberPresentation = originalNumber;
    this.radix = radix;
    this.converters = new ArrayList<>();
  }

  /*
   * Thêm vào converter để quan sát số ban đầu.
   * @param converter
   */
  public void addConverter(NumberConverter converter) {
    if (!converters.contains(converter)) {
      converters.add(converter);
    }
  }

  /*
   * Hủy quan sát số ban đầu của converter.
   * @param converter
   */
  public void removeConverter(NumberConverter converter) {
    converters.remove(converter);
  }

  /*
   * Khi có sự thay đổi trạng thái (biểu diễn số hoặc cơ số), thông báo cho tất cả
   * các converter đăng ký quan sát để cập nhật lại trạng thái theo dữ liệu mới.
   */
  public void notifyConverters() {
    for (NumberConverter converter : converters) {
      converter.update();
    }
  }

  public String getNumberPresentation() {
    return numberPresentation;
  }

  public void setNumberPresentation(String numberPresentation) {
    this.numberPresentation = numberPresentation;
    onStateChanged();
  }

  public int getRadix() {
    return radix;
  }

  public void setRadix(int radix) {
    this.radix = radix;
    onStateChanged();
  }

  /*
   * Cập nhật biểu diễn số và cơ số.
   * @param numberPresentation
   * @param radix
   */
  public void setNumber(String numberPresentation, int radix) {
    this.numberPresentation = numberPresentation;
    this.radix = radix;
    onStateChanged();
  }

  /*
   * Hiển thị số ra terminal theo định dạng a1a2...an(radix)
   */
  public void display() {
    System.out.println(numberPresentation + "(" + radix + ")");
  }

  /*
   * Được gọi khi có sự thay đổi về trạng thái (biểu diễn số hoặc cơ số),
   * hàm này sẽ gọi hàm để thông báo cho tất cả các observer đăng ký quan sát
   * cập nhật lại trạng thái.
   */
  private void onStateChanged() {
    notifyConverters();
  }
}
