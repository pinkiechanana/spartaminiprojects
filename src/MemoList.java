import java.util.HashMap;

public class MemoList {
    static HashMap<Integer, String> dataBase = new HashMap<>();
    static int i = 0;
    public static void input(String input) {

        dataBase.put(i , input);

        i++;
    }

    public static void read() {
            System.out.println(MemoList.dataBase);
    }

    public static void delete(int n) {
        dataBase.remove(n);
    }

    public static void update(int updateNum, String updateValue) {
        dataBase.replace(updateNum, updateValue);
    }

}
