import org.junit.Test;

//comment
//comment3.11
public class TaskTest {
    @Test
    public void taskTest(){
        Reshuffle reshuffle = new Reshuffle("algoritm");
        for (String variant : reshuffle.getShuffles()) {
            System.out.println(variant);
        }
    }
}
