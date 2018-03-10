package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BlackListName {

    public static List<String> getBlackList(String filePath) {
        List<String> list;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            list = br.lines().collect(Collectors.toList());

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
}
