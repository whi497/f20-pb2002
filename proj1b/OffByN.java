/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/8
 * @Description:
 * @Version: 1.0
 */
public class OffByN implements CharacterComparator {
    private final int n;
    OffByN(int offset) {n = offset;}
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == n;
    }
}
