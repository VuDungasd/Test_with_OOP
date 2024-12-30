package org.example.Bai_1;

import java.math.BigInteger;

public class BinaryConverter extends AbstractNumberConverter {

  public BinaryConverter(MyNumber originalNumber) {
    super(originalNumber);
  }

  /*
   * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
   * sang số được biểu diễn trong hệ cơ số 2.
   * @param decimal
   * @return xâu ký tự biểu diễn số trong hệ cơ số 2.
   *
   * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
   * không sử dụng thư viện chuyển đổi số có sẵn của Java.
   */
  @Override
  public String decimalTo(String decimal) {
    BigInteger decimalValue = new BigInteger(decimal);
    BigInteger base = BigInteger.valueOf(2);
    StringBuilder binaryNumber = new StringBuilder();

    // Sử dụng thuật toán Euclid để chuyển đổi sang hệ cơ số 2
    while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
      BigInteger remainder = decimalValue.mod(base); // Lấy phần dư
      binaryNumber.insert(0, remainder); // Thêm phần dư vào đầu chuỗi
      decimalValue = decimalValue.divide(base); // Chia nguyên cho cơ số
    }

    return binaryNumber.length() > 0 ? binaryNumber.toString() : "0";
  }

  /*
   * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
   * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
   * số được chuyển đổi theo định dạng a1a2...an(2).
   */
  @Override
  public void update() {
    convert(); // Thực hiện chuyển đổi số
    display(); // Hiển thị số đã chuyển đổi
  }

  /*
   * Hiển thị số ra terminal theo định dạng a1a2...an(2).
   */
  @Override
  public void display() {
    System.out.println(convertedNumber + "(2)");
  }
}

