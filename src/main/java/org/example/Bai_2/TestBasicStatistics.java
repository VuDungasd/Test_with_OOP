package org.example.Bai_2;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class TestBasicStatistics {
  public static void main(String[] args) {
    // Tên file kết quả
    String resultFileName = "NguyenVanLam_123456_BasicStatistics.txt"; // Thay tên và mã sinh viên của bạn

    try (PrintWriter writer = new PrintWriter(new FileWriter(resultFileName))) {
      writer.println("Testing MyArrayList:");
      testMyArrayList(writer);

      writer.println("\nTesting MyLinkedList:");
      testMyLinkedList(writer);

      System.out.println("Kết quả đã được ghi vào file: " + resultFileName);
    } catch (IOException e) {
      System.err.println("Lỗi khi ghi file: " + e.getMessage());
    }
  }

  /**
   * Test chức năng với MyArrayList và ghi kết quả vào file.
   */
  public static void testMyArrayList(PrintWriter writer) {
    Random random = new Random();

    // Sinh ngẫu nhiên độ dài của danh sách [30, 50]
    int length = 30 + random.nextInt(21);

    // Tạo danh sách MyArrayList
    MyArrayList myArrayList = new MyArrayList();

    // Sinh ngẫu nhiên các giá trị Double trong đoạn [1, 20]
    for (int i = 0; i < length; i++) {
      double value = 1 + (19 * random.nextDouble());
      myArrayList.append(value);
    }

    // In dữ liệu trong danh sách
    writer.println("Data in MyArrayList: " + myArrayList);

    // Tính toán các thống kê cơ bản
    BasicStatistic stats = new BasicStatistic(myArrayList);
    writer.println("Max: " + stats.max());
    writer.println("Min: " + stats.min());
    writer.println("Mean: " + stats.mean());
    writer.println("Variance: " + stats.variance());
  }

  /**
   * Test chức năng với MyLinkedList và ghi kết quả vào file.
   */
  public static void testMyLinkedList(PrintWriter writer) {
    Random random = new Random();

    // Sinh ngẫu nhiên độ dài của danh sách [30, 50]
    int length = 30 + random.nextInt(21);

    // Tạo danh sách MyLinkedList
    MyLinkedList myLinkedList = new MyLinkedList();

    // Sinh ngẫu nhiên các giá trị Double trong đoạn [1, 20]
    for (int i = 0; i < length; i++) {
      double value = 1 + (19 * random.nextDouble());
      myLinkedList.append(value);
    }

    // In dữ liệu trong danh sách
    writer.println("Data in MyLinkedList: " + myLinkedList);

    // Tính toán các thống kê cơ bản
    BasicStatistic stats = new BasicStatistic(myLinkedList);
    writer.println("Max: " + stats.max());
    writer.println("Min: " + stats.min());
    writer.println("Mean: " + stats.mean());
    writer.println("Variance: " + stats.variance());
  }

}
