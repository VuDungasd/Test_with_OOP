package org.example.Bai_2;

public interface MyList extends MyIterable {
    /**
     * Lấy kích thước của list.
     * @return
     */
    int size();

    /**
     * Lấy dữ liệu của phần tử ở vị trí index.
     * @param index
     * @return
     */
    Number get(int index);

    /**
     * Thêm phần tử có dữ liệu payload váo cuối list.
     * @param payload
     */
    void append(Number payload);

    /**
     * Thêm phần tử có dữ liệu payload vào list ở vị trí index.
     * @param payload
     * @param index
     */
    void insert(Number payload, int index);

    /**
     * Xóa phần tử ở vị trí index.
     * @param index
     */
    void remove(int index);
}
