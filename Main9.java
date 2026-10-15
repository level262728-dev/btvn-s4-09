import java.util.Scanner;

public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Nhập kích thước của mảng
        System.out.print("Nhập số phần tử của mảng: ");
        int n;
        try {
            n = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            n = -1;
        }

        // 2. Kiểm tra điều kiện hợp lệ của n
        if (n <= 0) {
            System.out.println("Mảng không hợp lệ");
            scanner.close();
            return;
        }

        // 3. Nhập các phần tử cho mảng
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng (cách nhau bằng khoảng trắng):");
        String[] line = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }

        // 4. Áp dụng thuật toán Kadane để tìm tổng lớn nhất của dãy con liên tiếp
        int maxSoFar = arr[n - 1]; // Lưu tổng lớn nhất toàn cục
        int currentSum = arr[0];   // Lưu tổng tạm thời của dãy con hiện tại

        // Trường hợp tất cả phần tử đều âm hoặc mảng có từ 2 phần tử trở lên
        maxSoFar = arr[0];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                currentSum = arr[0];
                maxSoFar = arr[0];
                continue;
            }

            // Nếu tổng hiện tại nhỏ hơn 0, đặt lại bằng 0 để bắt đầu dãy con mới
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += arr[i];

            if (currentSum > maxSoFar) {
                maxSoFar = currentSum;
            }
        }

        // Xử lý riêng trường hợp mảng toàn số âm: chọn phần tử lớn nhất làm kết quả
        int maxElement = arr[0];
        boolean allNegative = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                allNegative = false;
            }
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }

        if (allNegative) {
            maxSoFar = maxElement;
        }

        // 5. In kết quả
        System.out.println("Tổng lớn nhất của dãy con liên tiếp là: " + maxSoFar);

        scanner.close();
    }
}