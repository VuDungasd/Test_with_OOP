package org.example.Bai_3;

import java.math.BigInteger;

public class OctalConverter extends AbstractNumberConverter {

  public OctalConverter(MyNumber originalNumber) {
    super(originalNumber);
  }

  /*
   * Chuyển đổi một số được biểu diễn trong hệ cơ số 10
   * sang số được biểu diễn trong hệ cơ số 8.
   * @param decimal
   * @return xâu ký tự biểu diễn số trong hệ cơ số 8.
   *
   * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
   * không sử dụng thư viện chuyển đổi số có sẵn của Java.
   */
  @Override
  public String decimalTo(String decimal) {
    BigInteger decimalValue = new BigInteger(decimal);
    BigInteger base = BigInteger.valueOf(8);
    StringBuilder octalNumber = new StringBuilder();

    // Sử dụng thuật toán Euclid để chuyển đổi sang hệ cơ số 8
    while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
      BigInteger remainder = decimalValue.mod(base);
      octalNumber.insert(0, remainder.toString()); // Chèn vào đầu
      decimalValue = decimalValue.divide(base);
    }

    return octalNumber.length() > 0 ? octalNumber.toString() : "0";
  }

  /*
   * Cập nhật số được chuyển đổi khi số ban đầu thay đổi
   * hoặc cơ số của số ban đầu thay đổi. Sau đó in ra terminal
   * số được chuyển đổi theo định dạng a1a2...an(8).
   */
  @Override
  public void update() {
    convert(); // Gọi phương thức chuyển đổi
    display(); // Hiển thị số đã chuyển đổi
  }

  /*
   * Hiển thị số ra terminal theo định dạng a1a2...an(8).
   */
  @Override
  public void display() {
    System.out.println(convertedNumber + "(8)");
  }
}
