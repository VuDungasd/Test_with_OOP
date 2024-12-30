package org.example.Bai_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestNumberSystem {
  public static void main(String[] args) {
    // Tên sinh viên và mã sinh viên (cần thay đổi cho phù hợp)
    String studentName = "NguyenVanA";
    String studentID = "123456";

    // Tên file kết quả
    String outputFileName = studentName + "_" + studentID + "_NumberSystemConverter.txt";

    try (FileWriter writer = new FileWriter(outputFileName)) {
      // Sinh 3 số ngẫu nhiên
      for (int i = 0; i < 3; i++) {
        // Sinh ngẫu nhiên cơ số
        int radix = getRandomNumber(2, 16);

        // Sinh ngẫu nhiên số ban đầu
        String originalNumber = generateRandomNumber(radix);

        // Tạo đối tượng MyNumber
        MyNumber myNumber = new MyNumber(originalNumber, radix);

        // Tạo các converter
        BinaryConverter binaryConverter = new BinaryConverter(myNumber);
        OctalConverter octalConverter = new OctalConverter(myNumber);
        HexadecimalConverter hexadecimalConverter = new HexadecimalConverter(myNumber);

        // Thêm các converter vào MyNumber
        myNumber.addConverter(binaryConverter);
        myNumber.addConverter(octalConverter);
        myNumber.addConverter(hexadecimalConverter);

        // Hiển thị và ghi thông tin vào file
        StringBuilder output = new StringBuilder();
        output.append("Original number: ").append(originalNumber).append("\n");
        output.append("Radix: ").append(radix).append("\n");
        output.append("Binary: ");
        binaryConverter.display();
//        output.append(binaryConverter.getConvertedNumber()).append("\n");
        output.append("Octal: ");
        octalConverter.display();
//        output.append(octalConverter.getConvertedNumber()).append("\n");
        output.append("Hexadecimal: ");
        hexadecimalConverter.display();
//        output.append(hexadecimalConverter.getConvertedNumber()).append("\n\n");

        System.out.print(output); // In ra màn hình terminal
        writer.write(output.toString()); // Ghi vào file
      }
    } catch (IOException e) {
      System.err.println("Lỗi khi ghi file: " + e.getMessage());
    }
  }

  // Hàm sinh số ngẫu nhiên trong khoảng [min, max]
  private static int getRandomNumber(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  // Hàm sinh ngẫu nhiên một xâu ký tự biểu diễn số trong hệ cơ số radix
  private static String generateRandomNumber(int radix) {
    Random random = new Random();
    int length = getRandomNumber(10, 30); // Độ dài số từ 10 đến 30
    StringBuilder number = new StringBuilder();

    String digits = "0123456789ABCDEF";
    for (int i = 0; i < length; i++) {
      int index = random.nextInt(radix); // Chỉ số trong khoảng [0, radix - 1]
      number.append(digits.charAt(index));
    }

    return number.toString();
  }
}

