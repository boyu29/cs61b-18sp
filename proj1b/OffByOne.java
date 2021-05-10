/**
 * @author Boyu Chen
 * @date 5/10/21
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        x = Character.toLowerCase(x);
        y = Character.toLowerCase(y);
        return ( x - y == 1 || y - x == 1);
    }
}
