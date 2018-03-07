package user;

import java.util.ArrayList;
import java.util.List;

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

    String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\blacklist.txt";
//    Scanner in = new Scanner(new File(filePath));

//    public List<String> getBlackList( String filePath) {
//        File file = new File(filePath);
//    }

}
