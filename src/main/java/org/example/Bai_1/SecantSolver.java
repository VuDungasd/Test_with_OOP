package org.example.Bai_1;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp Secant
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm trong đoạn [lower, upper]
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        // Khởi tạo các giá trị ban đầu
        double x0 = lower;
        double x1 = upper;
        double fx0 = function.evaluate(x0);
        double fx1 = function.evaluate(x1);

        for (int i = 0; i < maxIterations; i++) {
            // Áp dụng công thức Secant để tính x2 (dự đoán tiếp theo)
            double denominator = fx1 - fx0;
            if (denominator == 0) {
                throw new ArithmeticException("Phép chia cho 0 trong phương pháp Secant");
            }

            // Công thức Secant
            double x2 = x1 - fx1 * (x1 - x0) / denominator;

            // Kiểm tra sự hội tụ (tức là sự thay đổi giữa các lần lặp đủ nhỏ)
            if (Math.abs(x2 - x1) < tolerance) {
                return x2;  // Nếu hội tụ, trả về nghiệm
            }

            // Cập nhật giá trị cho lần lặp tiếp theo
            x0 = x1;
            fx0 = fx1;
            x1 = x2;
            fx1 = function.evaluate(x1);
        }

        // Nếu không hội tụ sau tối đa số lần lặp, ném ra ngoại lệ
        throw new RuntimeException("Phương pháp Secant không hội tụ trong số lần lặp tối đa");
    }
}
