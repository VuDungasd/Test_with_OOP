package org.example.Bai_2;

public class BasicStatistic {
  private MyList data;

  /**
   * Khởi tạo dữ liệu cho BasicStatistic.
   *
   * @param data Danh sách số liệu đầu vào.
   */
  public BasicStatistic(MyList data) {
    this.data = data;
  }

  /**
   * Lấy giá trị lớn nhất trong list.
   *
   * @return Giá trị lớn nhất.
   */
  public double max() {
    if (data.size() == 0) {
      throw new IllegalStateException("List is empty.");
    }
    double maxValue = data.get(0).doubleValue();
    for (MyIterator it = data.iterator(); it.hasNext(); ) {
      double currentValue = it.next().doubleValue();
      if (currentValue > maxValue) {
        maxValue = currentValue;
      }
    }
    return maxValue;
  }

  /**
   * Lấy giá trị nhỏ nhất trong list.
   *
   * @return Giá trị nhỏ nhất.
   */
  public double min() {
    if (data.size() == 0) {
      throw new IllegalStateException("List is empty.");
    }
    double minValue = data.get(0).doubleValue();
    for (MyIterator it = data.iterator(); it.hasNext(); ) {
      double currentValue = it.next().doubleValue();
      if (currentValue < minValue) {
        minValue = currentValue;
      }
    }
    return minValue;
  }

  /**
   * Tính kỳ vọng (trung bình) của mẫu lưu trong list.
   *
   * @return Giá trị trung bình.
   */
  public double mean() {
    if (data.size() == 0) {
      throw new IllegalStateException("List is empty.");
    }
    double sum = 0;
    for (MyIterator it = data.iterator(); it.hasNext(); ) {
      sum += it.next().doubleValue();
    }
    return sum / data.size();
  }

  /**
   * Tính phương sai của mẫu lưu trong list.
   *
   * @return Giá trị phương sai.
   */
  public double variance() {
    if (data.size() == 0) {
      throw new IllegalStateException("List is empty.");
    }
    double mean = mean();
    double sumSquaredDiff = 0;
    for (MyIterator it = data.iterator(); it.hasNext(); ) {
      double value = it.next().doubleValue();
      sumSquaredDiff += Math.pow(value - mean, 2);
    }
    return sumSquaredDiff / data.size();
  }
}
