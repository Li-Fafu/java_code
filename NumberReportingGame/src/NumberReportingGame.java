public class NumberReportingGame {
    public static void main(String[] args) {
        long n = 202420242024l;
        long num = findnumber(n);
        System.out.println("第 " + n + " 个被报出的数是: " + num);
    }

    private static long findnumber(long n) {
        //每120个数中有多少个符合条件的数
        int count = 120/20 + 120/24 - 120/120;
        //在 n 中有多少组
        long fullGroups  = n / 10;
        //余数多少个数
        long remainingIndex = n % 10;
        long d = fullGroups  * 120;
        long dcount= 0;
        for (int i = 1; i <= 120; i++) {
            if(i%20==0 || i % 24 == 0){
                dcount++;
                if(dcount == remainingIndex){
                    return i + d;
                }
            }
        }
        return -1;
    }
}
