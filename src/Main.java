import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Function<String, List<String>> getVocabulary = message -> Arrays.stream(message.split(" "))
                .parallel()
                .distinct()
                .map(word -> word.replaceAll("[,.]",""))
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());

        List<String> vocabulary = getVocabulary.apply(getText());

        System.out.println(vocabulary);
    }

    public static String getText() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras euismod egestas tempus. " +
                "Vivamus dictum maximus lacus vel sollicitudin. Orci varius natoque penatibus et magnis dis " +
                "parturient montes, nascetur ridiculus mus. Donec mollis velit ac augue gravida molestie. Sed a enim " +
                "sed dui bibendum vestibulum volutpat vitae sem. Duis iaculis, odio sit amet rutrum sodales, magna" +
                " diam sagittis orci, ut convallis augue felis ut magna. Aenean pharetra egestas suscipit. Vivamus" +
                " pellentesque metus vel diam iaculis maximus. Etiam congue lacus nunc, vel mollis neque hendrerit" +
                " sed. Morbi iaculis elit sed arcu suscipit, a ultrices nisl posuere. Ut scelerisque tempor nunc," +
                " nec consectetur mauris semper et. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices" +
                " posuere cubilia curae; Aliquam erat volutpat. Etiam eleifend augue feugiat bibendum tristique." +
                " Maecenas libero ipsum, sollicitudin eget libero sit amet, interdum vestibulum orci.";
    }
}