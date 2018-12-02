package NChooseK;

import java.util.ArrayList;
import java.util.List;

public class NChooseK {

    /**
     *
     * Input 5, 3
     *
     *                                 c(4, 2)        +       calcCombos(4, 3)
     *                               /
     *                  c(3, 1)
     *              /                      \
     *      c(2, 0)         +         c(3, 1)    c(2, 1)
     *   /                        /               \
     *  1        c(2, 0)  +  c(2, 1)
     *          /           /      \
     *         1       c(1, 0)     c(1, 1)
     *                  /         /
     *                 1         1
     *
     * @param n
     * @param k
     * @return
     */
    public long calcCombos(long n, long k){
        if (n == k || k == 0) {
            return 1;
        } else {
            return calcCombos(n-1,k-1) + calcCombos(n-1,k);
        }
    }

    public List<String> genCombos(String array, int k){
        List<String> result = new ArrayList<>();
        combinationUtil(array.toCharArray(), 0,  k, new char[k], 0, result);
        return result;
    }

    private void combinationUtil(char[] array, int arrayIndex, int k, char[] data, int dataIndex, List<String> result)
    {
        // Found k elements, add them to the list
        if (dataIndex == k)
        {
            result.add(new String(data));
            return;
        }

        // Reached the end of the array.
        if (arrayIndex >= array.length){
            return;
        }

        // current is included, put next at next location
        data[dataIndex] = array[arrayIndex];
        combinationUtil(array, arrayIndex + 1, k, data, dataIndex + 1, result);

        // current is excluded, replace it with next (Note that arrayIndex+1 is passed, but index is not changed)
        combinationUtil(array, arrayIndex + 1, k, data, dataIndex, result);
    }
}
