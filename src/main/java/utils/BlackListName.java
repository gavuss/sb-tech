package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Alexander Silaev on 07.03.2018.
 */
public class BlackListName {

    private List<String> blackList;

    private void initList() {
        blackList = new ArrayList<>();
        blackList.add("root");
    }

    public List<String> getBlackList() {
        initList();
        return blackList;
    }


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
