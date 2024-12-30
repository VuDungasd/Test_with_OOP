package org.example.Bai_1;

public class MyMath {

  // Hàm tính sin(x) bằng chuỗi Taylor
  public static double sin(double x) {
    // Chuỗi Taylor của sin(x): x - x^3/3! + x^5/5! - x^7/7! + ...
    double result = 0;
    double term = x;  // Bắt đầu với x^1 / 1!
    int n = 1;
    while (Math.abs(term) > 1e-10) {  // Tiếp tục tính đến khi độ chính xác đủ cao
      result += term;
      term *= -x * x / ((2 * n) * (2 * n + 1));  // Tính toán các hạng tử tiếp theo
      n++;
    }
    return result;
  }

  // Hàm tính cos(x) bằng chuỗi Taylor
  public static double cos(double x) {
    // Chuỗi Taylor của cos(x): 1 - x^2/2! + x^4/4! - x^6/6! + ...
    double result = 1;
    double term = 1;  // Bắt đầu với 1 (x^0 / 0!)
    int n = 1;
    while (Math.abs(term) > 1e-10) {  // Tiếp tục tính đến khi độ chính xác đủ cao
      term *= -x * x / ((2 * n - 1) * (2 * n));  // Tính toán các hạng tử tiếp theo
      result += term;
      n++;
    }
    return result;
  }

  // Hàm tính exp(x) bằng chuỗi Taylor
  public double exp(double x) {
    // Chuỗi Taylor của exp(x): 1 + x/1! + x^2/2! + x^3/3! + ...
    double result = 1;
    double term = 1;  // Bắt đầu với x^0 / 0!
    int n = 1;
    while (Math.abs(term) > 1e-10) {  // Tiếp tục tính đến khi độ chính xác đủ cao
      term *= x / n;  // Tính toán các hạng tử tiếp theo
      result += term;
      n++;
    }
    return result;
  }

  // Hàm tính ln(x) bằng công thức xấp xỉ (cần x > 0)
  public double ln(double x) {
    if (x <= 0) {
      throw new IllegalArgumentException("Logarithm undefined for x <= 0");
    }
    // Sử dụng chuỗi Taylor của ln(1 + y) với y = x - 1: ln(x) = ln(1 + (x - 1))
    double y = x - 1;
    double result = 0;
    double term = y;
    int n = 1;
    while (Math.abs(term) > 1e-10) {  // Tiếp tục tính đến khi độ chính xác đủ cao
      result += term / n;  // Công thức chuỗi Taylor
      term *= -y;  // Tính toán các hạng tử tiếp theo
      n++;
    }
    return result;
  }
}
