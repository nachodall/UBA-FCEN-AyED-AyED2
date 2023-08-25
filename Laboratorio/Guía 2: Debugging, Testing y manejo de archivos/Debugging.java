package aed;

class Debugging {
    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        if (xs.length != ys.length){
            return false;
        }

        for (int i = 0; i < xs.length; i++) {
            System.out.println(xs[i]);
            System.out.println(ys[i]);
            if (xs[i] != ys[i]) {
                res = false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0; i < xs.length-1; i++) {
            if (xs[i] > xs [i+1]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = -9999;
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] > res) res = xs[i];
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        if (xs.length == 0){
            System.out.println("entre");
            return true;
        }
        for (int i = 0; i<xs.length; i++){
            if (xs[i]<=0){
                return false;
            }
        }
        return res;
    }
}
