package org.example.Bai_1;

public class UnivariateRealFunction implements AbstractFunction {

    // Ví dụ về hàm f(x) = x^2 - 4
    @Override
    public double evaluate(double x) {
        // Hàm cần tính giá trị tại x (ví dụ: f(x) = x^2 - 4)
        return x * x - 4;
    }

    // Đạo hàm của hàm f(x) = x^2 - 4 là f'(x) = 2x
    @Override
    public double derivative(double x) {
        // Đạo hàm của hàm f(x) = x^2 - 4 (f'(x) = 2x)
        return 2 * x;
    }
}

