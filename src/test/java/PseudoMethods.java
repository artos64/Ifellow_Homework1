public class PseudoMethods {
    /**
     * Статик псевдо-метод, который считает сумму значений
     * @param c означает количество итераций в цикле
     * @return сумма значений от 0 до c
     */
    public static int pseudoMethod(int c){
        int sum=0;
        for(int i=0;i<=c;i++){
            sum=sum+i;
        }
        return sum;
    }

    /**
     * Псевдо-метод, который считает сумму значений
     * @param c означает количество итераций в цикле
     * @return сумма значений от 0 до c
     */
    public int pseudoMethod2(int c){
        int sum=0;
        for(int i=0;i<=c;i++){
            sum=sum+i;
        }
        return sum;
    }
}
