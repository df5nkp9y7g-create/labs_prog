public class labProg1 {
    public static void main(String[] args) {

        short[] e = arr_odd_from_to(5, 17);
        double[] x = arr_random_from_to(15, -3.0, 8.0);
        double[][] e_new = make_matrix(7, 15, e, x);

        print_matrix(e_new);
    }



    // ===========================================
    //   helper methods
    // ===========================================

    // for the first point
    static short[] arr_odd_from_to(int from, int to) {
        int len_arr = (to - from) / 2 + 1;
        short[] arr = new short[len_arr];
        for (int i = 0; i < len_arr; i++) {
            arr[i] = (short)(from + 2*i);
        }
        return arr;
    }

    //for the second point
    static double[] arr_random_from_to(int len, double from, double to){
        double[] arr = new double[len];
        for (int i = 0; i < len; i++) {
            arr[i] = from + Math.random() * (to - from);
        }
        return arr;
    }

    // for the third point
    static double[][] make_matrix(int size_x, int size_y, short[] arr_e, double[] arr_x) {

        double[][] goal_arr = new double[size_x][size_y];
        for (int i = 0; i < size_x; i++) {
            for (int j = 0; j < size_y; j++) {

                if (arr_e[i] == 7) {
                    goal_arr[i][j] = Math.sin(Math.cbrt(Math.cbrt(arr_x[j])));

                } else if (arr_e[i] == 9 || arr_e[i] == 13 || arr_e[i] == 17) {
                    double exponent = Math.exp(-2*Math.abs(arr_x[j]));
                    goal_arr[i][j] = Math.asin(exponent);

                } else {
                    double in_cos = 8 * Math.pow(Math.sin(arr_x[j]), 3);
                    double in_arccos = Math.cos(in_cos);
                    double in_log = Math.acos(in_arccos);
                    goal_arr[i][j] = Math.log(in_log);
                }
            }
        }
        return goal_arr;
    }

    // for the fourth point
    static void print_matrix(double[][] arr) {
        for (double[] i : arr) {
            for (double j : i)
                System.out.printf("%7.2f", j);
            System.out.println();
        }
    }
}
