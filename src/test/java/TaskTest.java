import org.junit.Test;

//comment
//comment3
public class TaskTest {
    @Test
    public void taskTest(){
        Reshuffle reshuffle = new Reshuffle("algoritm");
        for (String variant : reshuffle.getShuffles()) {
            System.out.println(variant);
        }
    }
}
