package aed;

public class InternetToolkit {
    public InternetToolkit() {}

    private void insertionSort(Fragment[] arr) {  
        int n = arr.length;  
          
        for(int i=0; i < n; i++){  
            int j = i-1;    
            Fragment elem = arr[i];
            while(j>=0 && arr[j].compareTo(elem) == 1){
                arr[j+1] = arr[j];
                j = j-1;
            }

            arr[j+1] = elem;
        }  
    }  

    public Fragment[] tcpReorder(Fragment[] fragments) {
        insertionSort(fragments); 
        //Use insertionSort porque yo se que los errores suelen estar adelante de todo
        return fragments;
    }


    public Router[] kTopRouters(Router[] routers, int k, int umbral){
        Heap routs = new Heap(routers); //ya me hace el sort
        Router[] res = new Router[k];
        //ordeno los routers de mayor a menor con un max heap ya que me ayuda a sacar los k elementos logaritmicamente
        int j = 0;
        for(int i=0; i<k; i++){
            Router elem = routs.desencolar();
            if(elem.getTrafico() >= umbral){
                res[j] = elem;
                j++;
            }
        }        

        return res;
    }

   

    public IPv4Address[] sortIPv4(String[] ipv4) {
        // Crear un array de buckets (arreglos)
        IPv4Address[][] buckets = new IPv4Address[256][ipv4.length];
        int[] bucketIndividual = new int[256];
    
        // pongo las direcciones en los buckets según el primer octeto
        for (String addressStr : ipv4) {
            IPv4Address address = new IPv4Address(addressStr);
            int firstOctet = address.getOctet(0);
            buckets[firstOctet][bucketIndividual[firstOctet]++] = address;
        }
    
        // ordeno individualmente cada bucket. 
        int index = 0;
        for (int i = 0; i < 256; i++) {
            OrdenarBucket(buckets[i], bucketIndividual[i]);
            for (int j = 0; j < bucketIndividual[i]; j++) {
                ipv4[index++] = buckets[i][j].toString();
            }
        }
    
        // convierto los elementos a Ipv4address.
        IPv4Address[] sortedIPv4Addresses = new IPv4Address[ipv4.length];
        for (int i = 0; i < ipv4.length; i++) {
            sortedIPv4Addresses[i] = new IPv4Address(ipv4[i]);
        }
    
        return sortedIPv4Addresses;
    }

     // funcion para ordenar los buckets
     private static void OrdenarBucket(IPv4Address[] bucket, int size) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (CompararIpv4(bucket[j], bucket[j + 1]) > 0) {
                    // Intercambiar elementos si están en el orden incorrecto
                    IPv4Address temp = bucket[j];
                    bucket[j] = bucket[j + 1];
                    bucket[j + 1] = temp;
                }
            }
        }
    }

    //para comparar dos direcciones IPv4
    private static int CompararIpv4(IPv4Address a, IPv4Address b) {
        for (int i = 0; i < 4; i++) {
            int octetComparison = Integer.compare(a.getOctet(i), b.getOctet(i));
            if (octetComparison != 0) {
                return octetComparison;
            }
        }
        return 0;
    }

}
