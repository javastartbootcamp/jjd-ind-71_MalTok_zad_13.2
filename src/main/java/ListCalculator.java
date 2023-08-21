import java.math.BigInteger;
import java.util.List;

class ListCalculator {
    public BigInteger countSum(List<Integer> list) {
        BigInteger sum = BigInteger.ZERO;
        for (Integer integer : list) {
            sum = sum.add(BigInteger.valueOf(integer));
        }
        return sum;
    }

    public int getLowestNumber(List<Integer> list) {
        int lowestNumber = list.get(0);
        for (Integer integer : list) {
            if (integer < lowestNumber) {
                lowestNumber = integer;
            }
        }
        return lowestNumber;
    }

    public int getHighestNumber(List<Integer> list) {
        int highestNumber = list.get(0);
        for (Integer integer : list) {
            if (integer > highestNumber) {
                highestNumber = integer;
            }
        }
        return highestNumber;
    }
}
