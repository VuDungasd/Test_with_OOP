package org.example.Bai_1;

public class BisectionSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance độ chính xác
     * @param maxIterations số lần lặp tối đa
     */
    public BisectionSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp chia đôi (Bisection).
     * @param function hàm số cần tìm nghiệm
     * @param lower cận dưới của đoạn
     * @param upper cận trên của đoạn
     * @return nghiệm của hàm.
     * @throws IllegalArgumentException nếu hàm không đổi dấu trong đoạn [lower, upper].
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        // Kiểm tra điều kiện dấu ngược
        if (function.evaluate(lower) * function.evaluate(upper) > 0) {
            throw new IllegalArgumentException("Function must have opposite signs at the endpoints.");
        }

        double mid = lower;
        for (int i = 0; i < maxIterations; i++) {
            mid = (lower + upper) / 2;
            double fMid = function.evaluate(mid);

            // Kiểm tra điều kiện dừng
            if (Math.abs(fMid) < tolerance) {
                return mid;
            }

            // Cập nhật lại đoạn
            if (function.evaluate(lower) * fMid < 0) {
                upper = mid;
            } else {
                lower = mid;
            }
        }
        return mid;
    }
}
