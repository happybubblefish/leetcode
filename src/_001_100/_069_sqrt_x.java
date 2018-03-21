package _001_100;

public class _069_sqrt_x {
    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    public static int mySqrt(int x) {
//        int result = 0;
//
//
//        for(int i = 0; i <= x; i++) {
//            long mul = i * i;
//            if(mul == x) {
//                result = i;
//                break;
//            } else if(mul < x && (long)(i + 1) * (i + 1) > x) {
//                result = i;
//                break;
//            }
//        }
//
//        return result;

        if(x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if((long)mid * mid == x) {
                return mid;
            } else if(mid > x / mid) {
                right = mid - 1;
            } else {
                if((long)(mid + 1) * (mid + 1) > x) {
                    return mid;
                }

                left = mid + 1;
            }
        }

        return 0;
    }
}
