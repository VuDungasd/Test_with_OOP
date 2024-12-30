package org.example.Bai_1;

import java.math.BigInteger;

public class HexadecimalConverter extends AbstractNumberConverter {

  public HexadecimalConverter(MyNumber originalNumber) {
    super(originalNumber);
  }

  /*
   * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
   * sang số được biểu diễn trong hệ cơ số 16.
   * @param decimal
   * @return xâu ký tự biểu diễn số trong hệ cơ số 16.
   *
   * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
   * không sử dụng thư viện chuyển đổi số có sẵn của Java.
   */
  @Override
  public String decimalTo(String decimal) {
    BigInteger decimalValue = new BigInteger(decimal);
    BigInteger base = BigInteger.valueOf(16);
    StringBuilder hexNumber = new StringBuilder();

    // Sử dụng thuật toán Euclid để chuyển đổi sang hệ cơ số 16
    String hexCharacters = "0123456789ABCDEF";

    while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
      BigInteger remainder = decimalValue.mod(base);
      hexNumber.insert(0, hexCharacters.charAt(remainder.intValue())); // Thêm vào đầu chuỗi
      decimalValue = decimalValue.divide(base);
    }

    return hexNumber.length() > 0 ? hexNumber.toString() : "0";
  }

  /*
   * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
   * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
   * số được chuyển đổi theo định dạng a1a2...an(16).
   */
  @Override
  public void update() {
    convert(); // Thực hiện chuyển đổi số
    display(); // Hiển thị số đã chuyển đổi
  }

  /*
   * Hiển thị số ra terminal theo định dạng a1a2...an(16).
   */
  @Override
  public void display() {
    System.out.println(convertedNumber + "(16)");
  }
}
