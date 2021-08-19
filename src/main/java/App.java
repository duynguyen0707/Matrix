import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int[][] a = generateMatrix(3, 3, 0, 5);
        printMatrix(a);
//        int s = sumElemement(a);
//        System.out.format("SUM %d\n", s);

//        int n = 20;
//
//        boolean xValue = isContainValueX(a, n);
//
//        if (xValue) {
//            System.out.println("Does Array contain number: " + n + "?" + " " + xValue);
//        } else {
//            System.out.println("Does Array contain number: " + n + "?" + " " + xValue);
//        }
//
//        int maxNumberinMatrix = findMaxvalueInMatrix(a);
//        System.out.println("Max value in the Matrix is: " + maxNumberinMatrix);

        int sumElemenRowColumninMatrix = sumElemenRowColumninMatrix(a, 2, 2);
        System.out.println("Sum elements at Rown n Column m: " + sumElemenRowColumninMatrix);

        int sumMainEle = sumMaindiagonal(a);
        System.out.println("Sum Main diagonal in Matrix: " + sumMainEle);
        int sumAuxiliaryEle = sumAuxiliarydiagonal(a);
        System.out.println("Sum Auxiliary diagonal in Matrix: " + sumAuxiliaryEle);
    }

    public static int[][] inputMatrix() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Số dòng: ");
        int r = sc.nextInt();
        System.out.print("Số cột: ");
        int c = sc.nextInt();

        int[][] ret = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.format("a[%d][%d]= ", i, j);
                ret[i][j] = sc.nextInt();

            }

        }
        return ret;
    }

    public static void printMatrix(int[][] a) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                System.out.format("%5d", a[i][j]);
            }
            System.out.println();

        }
    }

    public static int[][] generateMatrix(int r, int c, int min, int max) {
        int[][] ret = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[i][j] = (int) Math.floor(Math.random() * (max - min) + min);

            }

        }
        return ret;
    }

    //    Cho trước ma trận a, kích thước m x n. Tính tổng các phần tử trên: Dòng d, cột c
    public static int sumElemenRowColumninMatrix(int[][] a, int r, int c) {
        int sum = 0;
        int sumR = 0;
        int sumC = 0;

        for (int i = 0, r1 = a.length; i < r1; i++) {
            for (int j = 0, c1 = a[0].length; j < c1; j++) {
                if (i == r) {
                    sumR += a[i][j];
                }
                if (j == c) {
                    sumC += a[i][j];
                }
            }
        }
        sum = sumC + sumR;

        return sum;
    }

    //  Is Matrix is an square matrix?
    public static boolean isSquareMatrix(int[][] a) {
        boolean result = true;
        if (a.length == a[0].length) {
            return true;
        }
        return false;
    }
//Main diagonal
    public static int sumMaindiagonal(int[][] a) {
        int sum = 0;
        if (isSquareMatrix(a)) {
            for (int i = 0, r = a.length; i < r; i++) {
                for (int j = 0, c = a[0].length; j < c; j++) {
                    if (i == j) {
                        sum += a[i][j];
                    }

                }

            }
        }
        else
            System.out.println("This is not a square matrix");
        return sum;
    }
//auxiliary diagonal
public static int sumAuxiliarydiagonal(int[][] a) {
    int sum = 0;
    if (isSquareMatrix(a)) {
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (j+i==r-1) {
                    sum += a[i][j];
                }

            }

        }

    }
    else
        System.out.println("This is not a square matrix");
    return sum;

}


    public static int sumElemement(int[][] a) {
        int sum = 0;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                sum += a[i][j];

            }

        }
        return sum;
    }

    //    Viết chương trình tìm xem ma trận kích thước m x n có chứa phần tử có giá trị x hay không
    public static boolean isContainValueX(int[][] a, int x) {
        boolean result = true;
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (a[i][j] == x) {
                    System.out.println("Hàng: " + i + "\n" + "Cột: " + j);
                    return true;
                }

            }

        }
        return false;
    }

    public static boolean isPrimeNumber(int n) {
        int sqr = (int) Math.sqrt(n);
        if (n < 1) {
            System.out.println("Số bạn nhập ko phải là số nguyên tố");
        }
        for (int i = 2; i < sqr; i++) {
            if (n % i == 0) {
                return false;
            }

        }
        return true;

    }


    //    Cho trước ma trận a kích thước m x n. Ma trận a có phải là ma trận toàn các số nguyên tố hay không?
    public static boolean isContainPrimeNumberOnly(int[][] a) {

        for (int i = 2, r = a.length; i < r; i++) {
            for (int j = 2, c = a[0].length; j < c; j++) {

                if (!isPrimeNumber(a[i][j])) {
                    return false;
                }


            }

        }
        return true;
    }

    //Cho trước ma trận a, kích thước m x n. Tìm giá trị lớn nhất trong ma trận (gọi là max)
    public static int findMaxvalueInMatrix(int[][] a) {
        int max = a[0][0];
        for (int i = 0, r = a.length; i < r; i++) {
            for (int j = 0, c = a[0].length; j < c; j++) {
                if (max < a[i][j]) {
                    max = a[i][j];
                }

            }

        }
        return max;

    }


}
