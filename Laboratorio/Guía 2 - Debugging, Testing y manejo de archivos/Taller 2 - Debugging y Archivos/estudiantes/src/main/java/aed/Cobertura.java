package aed;

class Cobertura {
    String fizzBuzz(int i) {
        if (i % 3 == 0) {
            if (i % 5 == 0) {
                return "FizzBuzz";
            } else {
                return "Fizz";
            }
        }else if (i % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(i);
        }
    }

    int numeroCombinatorio(int n, int k) {
        if (k == 0) {
            return 1;
        } else if (n == k) {
            return 1;
        } else if (k > n) {
            return 0;
        } else {
            return numeroCombinatorio(n-1, k-1) + numeroCombinatorio(n-1, k);
        }
    }

    int repeticionesConsecutivas(int[] xs) {
        int res = 0;
        int consecutivos = 1;

        for (int i = 1; i < xs.length; i++) {
            if (xs[i] == xs[i-1]) {
                consecutivos++;
            } else {
                consecutivos = 1;
            }
            res = Math.max(res, consecutivos);
        }

        return res;
    }
}
