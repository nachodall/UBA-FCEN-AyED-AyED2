package aed;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IPv4Address {
    private int[] _octets;

    public IPv4Address(int[] octets) {
        _octets = new int[4];
        for(int i = 0; i < 4;i++){
            if(octets[i] > 255 || octets[i] < 0){
                _octets[i] = 0;
            }else{
                _octets[i] = octets[i];
            }
        }
    }

    public IPv4Address(String s) {
        String[] v = s.split("\\.");
        if (v.length == 4) {
            _octets = new int[4];
            for (int i = 0; i < 4; i++) {
                int n = Integer.parseInt(v[i]);
                if(n > 255 || n < 0){
                    _octets[i] = 0;
                }else{
                    _octets[i] = n;
                }
            }
        }
    }

    public int getOctet(int i) {
        return _octets[i];
    }

    public String toString() {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < _octets.length; i++) {
            if (s.length() > 0)
                s.append(".");
            s.append(_octets[i]);
        }
        return s.toString();
    }
}