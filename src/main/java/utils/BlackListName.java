package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BlackListName {

    public static List<String> getBlackList(String filePath) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            List<String> list;
            list = br.lines().collect(Collectors.toList());
            return list;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
