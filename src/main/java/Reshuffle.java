
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reshuffle {
    private List<Character> letters;

    public Reshuffle(String word) {
        if(word == null || word.isEmpty()) throw new IllegalArgumentException("Wrong input parameter");
        letters = IntStream.range(0,word.length())
                .boxed()
                .map(word::charAt)
                .collect(Collectors.toList());
    }

    public Set<String> getShuffles() {
        Set<String> result = new HashSet<>();
        LinkedList<Integer> charOrder = new LinkedList<>();
        Map<Integer, Boolean> isBooked = new HashMap<>();
        isBooked.putAll(
            IntStream.range(0,letters.size())
                .boxed()
                .collect(Collectors.toMap(x->x, x->false))
        );
        int place = 0;
        int toSkip = 0;
        while (true){
            //if full variant
            if(place == letters.size()){
                //add result
                result.add(
                        IntStream.range(0, place)
                            .map(charOrder::get)
                            .mapToObj(letters::get)
                            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                            .toString()
                );
            }
            //try to get next step variant
            if(isBooked
                    .entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getKey))
                    .skip(toSkip)
                    .anyMatch(x->!x.getValue()))
            {
                //if it possible fix step
                int next = isBooked
                        .entrySet()
                        .stream()
                        .sorted(Comparator.comparingInt(Map.Entry::getKey))
                        .skip(toSkip)
                        .filter(x->!x.getValue())
                        .findFirst()
                        .get()
                        .getKey();
                charOrder.add(next);
                isBooked.put(next, true);
                toSkip = 0;
                place++;
            } else {
                //else rollback step
                place--;
                if (place < 0) break;
                isBooked.put(charOrder.getLast(), false);
                toSkip = charOrder.removeLast() + 1;
            }
        }
        return result;
    }
}
