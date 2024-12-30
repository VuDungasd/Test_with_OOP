package org.example.Bai_1;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance độ chính xác
     * @param maxIterations số lần lặp tối đa
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function hàm số cần tìm nghiệm
     * @param lower cận dưới của đoạn (sử dụng để chọn giá trị khởi tạo)
     * @param upper cận trên của đoạn (sử dụng để chọn giá trị khởi tạo)
     * @return nghiệm của hàm.
     * @throws IllegalArgumentException nếu đạo hàm bằng 0 hoặc không tìm được nghiệm trong số lần lặp tối đa.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        // Sử dụng giá trị khởi tạo là trung điểm của đoạn [lower, upper]
        double x0 = (lower + upper) / 2.0;
        double x1;

        for (int i = 0; i < maxIterations; i++) {
            double fX0 = function.evaluate(x0);
            double fPrimeX0 = function.derivative(x0);

            // Kiểm tra nếu đạo hàm gần 0
            if (Math.abs(fPrimeX0) < 1e-10) {
                throw new IllegalArgumentException("Derivative is too small. Method fails.");
            }

            // Tính giá trị tiếp theo theo công thức Newton-Raphson
            x1 = x0 - fX0 / fPrimeX0;

            // Kiểm tra độ chính xác
            if (Math.abs(x1 - x0) < tolerance) {
                return x1;
            }

            // Cập nhật x0
            x0 = x1;
        }

        // Nếu không hội tụ sau maxIterations lần lặp, ném ngoại lệ
        throw new IllegalArgumentException("Newton-Raphson method did not converge within the maximum iterations.");
    }
}
