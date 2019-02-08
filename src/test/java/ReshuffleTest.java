import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;
import java.util.stream.IntStream;

public class ReshuffleTest {
    @Test
    public void taskResultCountTest(){
        String word = "algoritm";
        Reshuffle reshuffle = new Reshuffle(word);

        int expected = IntStream.rangeClosed(1, (int)word.chars().distinct().count())
                .reduce(1, (x,y) -> x*y);

        Assert.assertEquals(expected, reshuffle.getShuffles().size());

    }

    //another comment
    @Test
    public void oneSymbolTest(){
       Reshuffle reshuffle = new Reshuffle("a");

        Set<String> expected = Sets.newHashSet("a");

        Assert.assertEquals(expected, reshuffle.getShuffles());
    }

    @Test
    public void twoSymbolTest(){
        Reshuffle reshuffle = new Reshuffle("bc");

        Set<String> expected = Sets.newHashSet("bc", "cb");

        Assert.assertEquals(expected, reshuffle.getShuffles());
    }


    @Test
    public void threeSymbolTest(){
        Reshuffle reshuffle = new Reshuffle("def");

        Set<String> expected = Sets.newHashSet("def", "dfe", "edf", "efd", "fde", "fed");

        Assert.assertEquals(expected, reshuffle.getShuffles());
    }

    @Test
    public void manySymbolsTest(){
        String word = "abcdefghi";
        Reshuffle reshuffle = new Reshuffle(word);

        int expected = IntStream.rangeClosed(1, (int)word.chars().distinct().count())
                .reduce(1, (x,y) -> x*y);

        Assert.assertEquals(expected, reshuffle.getShuffles().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyStringTest(){
        Reshuffle reshuffle = new Reshuffle("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullStringTest(){
        Reshuffle reshuffle = new Reshuffle(null);
    }
}
