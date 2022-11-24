public class MemoVO {
    public static void read() {
        for(int i = 0; i < MemoList.dataBase.size(); i++) {
            System.out.println(MemoList.dataBase.get(i));
        }
    }
}
