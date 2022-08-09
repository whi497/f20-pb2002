/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/8
 * @Description:
 * @Version: 1.0
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
