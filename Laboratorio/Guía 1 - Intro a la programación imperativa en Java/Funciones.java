package aed;

class Funciones {
    int cuadrado(int x) {
        return x * x;
    }

    double distancia(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }

    boolean esPar(int n) {
        return (n % 2 == 0);
    }

    boolean divideA(int x, int n) {
        return (n % x == 0);
    }

    boolean esBisiesto(int n) {
        return ((divideA(4, n) & !divideA(100, n)) || divideA(400, n));
    }

    int factorialIterativo(int n) {
        int res = 1;
        int act = 1;
        while (act <= n) {
            res = res * act;
            act++;
        }
        return res;
    }

    int factorialRecursivo(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * factorialRecursivo(n - 1);
    }

    boolean esPrimo(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        int act = 2;
        while (act < n) {
            if (divideA(act, n)) {
                return false;
            }
            act++;
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                return i;
            }
        }
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])) {
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (!esPar(numeros[i])) {
                return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s2.charAt(s2.length() - i - 1) != s1.charAt(s1.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}

