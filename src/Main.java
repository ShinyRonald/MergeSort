import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int []vetor = {1,8,7,2,3,4,5,6,10,10,10};
        int []auxiliar = new int[vetor.length];

        mergeSort(vetor,auxiliar,0,vetor.length-1);

        System.out.println(Arrays.toString(vetor));
    }

    private static void mergeSort(int[] vetor, int[] auxiliar, int ini, int fim) {
        if(ini < fim){
            int meio = (ini + fim)/2;
            mergeSort(vetor,auxiliar,ini,meio);
            mergeSort(vetor,auxiliar,meio+1,fim);
            intercarlar(vetor,auxiliar,ini,meio,fim);
        }
    }

    private static void intercarlar(int[] vetor, int[] auxiliar, int ini, int meio, int fim) {
        for(int i = ini; i <= fim; i++){
            auxiliar[i] = vetor[i];
        }
        int esq = ini;
        int dir = meio+1;

        for(int i = ini; i<=fim;i++){
            if(esq > meio) vetor[i] = auxiliar[dir++];
            else if(dir > fim) vetor[i] = auxiliar[esq++];
            else if(auxiliar[esq] < auxiliar[dir]) vetor[i] = auxiliar[esq++];
            else vetor[i] = auxiliar[dir++];
        }
    }
}