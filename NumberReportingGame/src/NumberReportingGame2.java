public class NumberReportingGame2 {
    public static void main(String[] args) {
        long targetIndex = 202420242024L;
        long num = findNumber(targetIndex);
        System.out.println("第 " + targetIndex + " 个被报出的数是: " + num);
    }

    public static long findNumber(long index) {
        // 20和24的最小公倍数
        long lcm = 120;
        // 每120个数中，是20或24倍数的数的个数
        long countIn120 = 120 / 20 + 120 / 24 - 120 / lcm;

        // 计算完整的120组的数量
        long fullGroups = index / countIn120;
        // 计算剩余的数的个数
        long remainingIndex = index % countIn120;

        // 先计算前面完整组对应的数
        long base = fullGroups * 120;

        // 遍历120以内是20或24倍数的数，找到剩余索引对应的数
        long count = 0;
        for (long i = 1; i <= 120; i++) {
            if (i % 20 == 0 || i % 24 == 0) {
                count++;
                if (count == remainingIndex) {
                    return base + i;
                }
            }
        }
        return -1; // 理论上不会执行到这里
    }
}