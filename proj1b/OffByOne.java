/**
 * @author Boyu Chen
 * @date 5/10/21
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return ( x - y == 1 || y - x == 1);
    }
}
