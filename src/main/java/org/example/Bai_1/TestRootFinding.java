package org.example.Bai_1;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestRootFinding {
  public static void main(String[] args) {
    testRootSolver();
  }

  public static void testRootSolver() {
    AbstractFunction function = new UnivariateRealFunction() {
      @Override
      public double evaluate(double x) {
        return Math.sin(x) * x + 2 * x - 3;
      }

      @Override
      public double derivative(double x) {
        return Math.cos(x) * x + Math.sin(x);
      }
    };

    // Các đoạn thử nghiệm với dấu ngược
    double[][] intervals = {
          {2.0, 3.0},   // Đây là một đoạn có dấu ngược tại các điểm 2.0 và 3.0
          {0.0, 4.0},   // Một đoạn có thể có dấu ngược
          {-1.0, 2.5}   // Thử với đoạn âm và đoạn dương
    };

    // Tạo các phương pháp tìm nghiệm
    RootSolver bisectionSolver = new BisectionSolver(1e-6, 1000);
    UnivariateRealRootFinding rootFinding = new UnivariateRealRootFinding(function);

    // Thử các đoạn tìm nghiệm
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("NguyenVanA_123456_RootSolver.txt"))) {
      for (double[] interval : intervals) {
        double lower = interval[0];
        double upper = interval[1];

        // Kiểm tra điều kiện dấu ngược trước khi chạy BisectionSolver
        if (function.evaluate(lower) * function.evaluate(upper) > 0) {
          String message = "Hàm không có dấu ngược tại các điểm biên: [" + lower + ", " + upper + "].\n";
          writer.write(message); // Ghi thông báo lỗi vào file
          System.out.println(message); // Cũng hiển thị thông báo lỗi trên màn hình
          continue;  // Nếu không có dấu ngược, thử đoạn khác
        }

        // Thực hiện tìm nghiệm với BisectionSolver
        rootFinding.setRootSolver(bisectionSolver);
        writer.write("Phương pháp: Bisection\n");
        writer.write("Hàm: sin(x) * x + 2 * x - 3\n");
        writer.write("Khoảng: [" + lower + ", " + upper + "]\n");
        writer.write("Nghiệm: " + rootFinding.solve(lower, upper) + "\n\n");

        System.out.println("Đoạn [" + lower + ", " + upper + "] tìm thấy nghiệm!");
      }

      System.out.println("Test complete! Results saved to file: NguyenVanA_123456_RootSolver.txt");
    } catch (IOException e) {
      System.err.println("Lỗi khi ghi vào file: " + e.getMessage());
    }
  }
}
