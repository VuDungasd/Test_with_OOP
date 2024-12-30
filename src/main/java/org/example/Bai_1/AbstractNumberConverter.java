package org.example.Bai_1;

import java.math.BigInteger;

public abstract class AbstractNumberConverter implements NumberConverter {
  protected MyNumber originalNumber;  // Số gốc
  protected String convertedNumber;   // Số được chuyển đổi theo cơ số nào đó từ số gốc

  public AbstractNumberConverter(MyNumber originalNumber) {
    this.originalNumber = originalNumber;
    this.convertedNumber = ""; // Khởi tạo rỗng
  }

  /*
   * Chuyển đổi số decimal từ hệ cơ số 10 thành số có hệ cơ số nào đó.
   * @param decimal
   * @return xâu ký tự biểu diễn một số trong hệ cơ số nào đó.
   *
   * Yêu cầu: sử dụng thuật toán Euclid để chuyển đổi,
   * không sử dụng thư viện chuyển đổi số có sẵn của Java.
   */
  public abstract String decimalTo(String decimal);

  /*
   * Chuyển đổi số được biểu diễn trong originalNumber sang biểu diễn số trong hệ cơ số 10.
   * @return xâu ký tự biểu diễn một số trong hệ cơ số 10.
   *
   * Yêu cầu: sử dụng thuật toán Horner để chuyển đổi,
   * không sử dụng thư viện chuyển đổi số có sẵn của Java.
   */
  public String toDecimal() {
    String number = originalNumber.getNumberPresentation();
    int radix = originalNumber.getRadix();
    BigInteger decimalValue = BigInteger.ZERO;
    BigInteger base = BigInteger.valueOf(radix);

    for (int i = 0; i < number.length(); i++) {
      char digit = number.charAt(i);
      int digitValue;

      // Xử lý ký tự, hỗ trợ cả chữ cái (ví dụ: A-F trong hệ cơ số 16)
      if (Character.isDigit(digit)) {
        digitValue = digit - '0';
      } else {
        digitValue = Character.toUpperCase(digit) - 'A' + 10;
      }

      decimalValue = decimalValue.multiply(base).add(BigInteger.valueOf(digitValue));
    }

    return decimalValue.toString(); // Trả về dạng chuỗi của giá trị thập phân
  }

  /**
   * Thực hiện chuyển đổi số từ biểu diễn số và hệ cơ số ban đầu trong originalNumber
   * sang số có hệ cơ số nào đó. Kết quả số được chuyển đổi được lưu trong biến
   * thành viên convertedNumber.
   */
  public void convert() {
    String decimalValue = toDecimal();
    this.convertedNumber = decimalTo(decimalValue);
  }

  /**
   * Cập nhật giá trị khi số gốc thay đổi.
   */
  @Override
  public void update() {
    convert();
  }

  /**
   * Hiển thị số đã được chuyển đổi ra màn hình.
   */
  @Override
  public void display() {
    System.out.println(convertedNumber);
  }
}
