import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInterface {
    public void User() {
        int menu = 0;
        Scanner scanner = new Scanner(System.in);



        while (true) {
            System.out.println("1. 입력");
            System.out.println("2. 목록 보기");
            System.out.println("3. 수정");
            System.out.println("4. 삭제");
            System.out.println("5. 종료");
            System.out.print("원하는 메뉴(1~5)를 선택하세요.>");

            String tmp1 = scanner.nextLine(); // 메뉴를 입력 받는다.
            menu = Integer.parseInt(tmp1);

            if (menu == 5) {
                System.out.println("메모장을 종료합니다.");
                break;
            } else if (!(1 <= menu && menu <= 5)) {
                System.out.println("메뉴를 잘못 선택하였습니다.");
                continue;
            }

            while (true) {

                switch (menu) {
                    case 1:
                        System.out.println("이름을 입력해주세요.");// Scanner 클래스의 입력 메소드 호출
                        String tmpName = scanner.nextLine();

                        System.out.println("비밀번호를 입력해주세요.");
                        String tmpPassword = scanner.nextLine();

                        System.out.println("메모을 입력해주세요.");
                        String tmpMemo = scanner.nextLine();

                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date date = new Date();
                        String save = " 이름 " + tmpName + " 비밀번호 " + tmpPassword + " 메모 " + tmpMemo + " " + formatter.format(date);

                        while (true) {
                            System.out.println("저장하시겠습니까? (Y/N)");
                            String tmpSave = scanner.nextLine();

                            if (tmpSave.equalsIgnoreCase("Y")) {
                                MemoList.input(save);
                                System.out.println("저장하였습니다."); // MemoList에 저장하는 메소드 호출
                                break;
                            } else if (tmpSave.equalsIgnoreCase("N")) {
                                System.out.println("저장하지않았습니다.");
                                break;
                            } else {
                                System.out.println("잘못된 입력입니다.");
                            }
                        }
                        break;
                    case 2:
                        System.out.println("목록을 조회합니다."); // 목록을 조회하는 메소드 호출
                        MemoList.read();
                        while (true) {

                            System.out.println("메인메뉴로 돌아가기 (0)");
                            String tmp2 = scanner.nextLine();
                            if (tmp2.equalsIgnoreCase("0")) {
                                System.out.println("메인메뉴로 돌아갑니다.");
                                break;
                            } else {
                                System.out.println("잘못된 입력입니다.");
                            }
                        }
                        break;
                    case 3:

                        MemoList.read();
                        System.out.println("수정할 글 번호을 입력하세요.");
                        int tmpUpdate = Integer.parseInt(scanner.nextLine());

                        System.out.println("비밀번호를 입력해주세요.");
                        String tmpPasswordCheck = scanner.nextLine();
                        String passwordcheck = MemoList.dataBase.get(tmpUpdate).split(" ")[4].trim();
                        if( !(passwordcheck.equals(tmpPasswordCheck))) {
                            System.out.println("비밀번호가 틀렸습니다.");
                            break;
                        }

                        System.out.println("이름을 입력해주세요.");// Scanner 클래스의 입력 메소드 호출
                        String tmpNameUpdate = scanner.nextLine();

                        System.out.println("비밀번호를 입력해주세요.");
                        String tmpPasswordUpdate = scanner.nextLine();

                        System.out.println("메모을 입력해주세요.");
                        String tmpMemoUpdate = scanner.nextLine();

                        SimpleDateFormat formatterUpdate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                        Date dateUpdate = new Date();
                        String saveUpdate = " 이름 " + tmpNameUpdate + " 비밀번호 " + tmpPasswordUpdate + " 메모 " + tmpMemoUpdate + " " + formatterUpdate.format(dateUpdate);

                        while (true) {
                            System.out.println("수정하시겠습니까? (Y/N)");
                            String tmp3 = scanner.nextLine();

                            if (tmp3.equalsIgnoreCase("Y")) {
                                MemoList.update(tmpUpdate, saveUpdate);
                                System.out.println("수정되었습니다."); // 글을 수정하는 메서드 호출
                                break;
                            } else if (tmp3.equalsIgnoreCase("N")) {
                                System.out.println("수정되지않았습니다.");
                                break;
                            } else {
                                System.out.println("잘못된 입력입니다.");
                            }
                        }
                        break;
                    case 4:

                        System.out.println("삭제할 글 번호을 입력하세요.");
                        int tmpDelete = Integer.parseInt(scanner.nextLine());

                        System.out.println("비밀번호를 입력해주세요.");
                        String tmpPasswordCheckDelete = scanner.nextLine();
                        String passwordcheckDelete= MemoList.dataBase.get(tmpDelete).split(" ")[4].trim();
                        if( !(passwordcheckDelete.equals(tmpPasswordCheckDelete))) {
                            System.out.println("비밀번호가 틀렸습니다.");
                            break;
                        }

                        while (true) {
                            System.out.println(MemoList.dataBase.get(tmpDelete));
                            System.out.println("삭제하시겠습니까? (Y/N)");
                            String tmp2 = scanner.nextLine();



                            if (tmp2.equalsIgnoreCase("Y")) {
                                MemoList.delete(tmpDelete);
                                System.out.println("삭제되었습니다."); // 글을 삭제하는 메서드 호출
                                break;
                            } else if (tmp2.equalsIgnoreCase("N")) {
                                System.out.println("삭제되지않았습니다.");
                                break;
                            } else {
                                System.out.println("잘못된 입력입니다.");
                            }
                        }
                        break;


                }
                break;
            }

        }

    }

}
