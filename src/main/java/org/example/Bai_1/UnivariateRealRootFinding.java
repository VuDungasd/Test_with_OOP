package org.example.Bai_1;

public class UnivariateRealRootFinding {
    private AbstractFunction function;
    private RootSolver rootSolver;

    /**
     * Khởi tạo hàm.
     * @param function
     */
    public UnivariateRealRootFinding(AbstractFunction function) {
        this.function = function;
        this.rootSolver = null;  // Mặc định chưa chọn phương pháp giải nghiệm
    }
    /**
     * Khởi tạo hàm và phương pháp tìm nghiệm.
     * @param function
     * @param rootSolver
     */
    public UnivariateRealRootFinding(AbstractFunction function, RootSolver rootSolver) {
        this.function = function;
        this.rootSolver = rootSolver;
    }

    public void setFunction(AbstractFunction function) {
        this.function = function;
    }

    public void setRootSolver(RootSolver rootSolver) {
        this.rootSolver = rootSolver;
    }

    /**
     * Tìm nghiệm của hàm trong đoạn [lower, upper].
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    public double solve(double lower, double upper) {
        if (rootSolver == null) {
            throw new IllegalArgumentException("Phương pháp giải nghiệm chưa được chọn.");
        }
        // Sử dụng phương pháp giải nghiệm đã được thiết lập
        return rootSolver.solve(function, lower, upper);
    }
}
