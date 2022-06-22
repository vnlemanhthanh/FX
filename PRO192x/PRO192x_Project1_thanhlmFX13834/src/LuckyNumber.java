import java.util.Scanner;

public class LuckyNumber {
    public static final int MAXIMUM = 100;

    public static void main(String[] args) {
        System.out.println("Tôi đang nghĩ một số trong khoảng từ 0 đến 100...");

        int totalGames = 0;
        int totalGuess = 0;
        int bestGame = Integer.MAX_VALUE;
        boolean isPlay = true;

        do {
//            Thực hiện lượt chơi, trả về số lần đoán trong lượt chơi
            int numsGuess = play();
//            Tính tổng số lần chơi, tổng số lần dự đoán, số lần dự đoán trung bình mỗi lượt
            totalGames++;
            totalGuess += numsGuess;
//            Tính số lần dự đoán ít nhất
            if (bestGame > numsGuess) {
                bestGame = numsGuess;
            }
//            Kết thúc lượt chơi hỏi người chơi có muốn tiếp tục chơi không
            System.out.print("Bạn có muốn tiếp tục chơi không? ");
            Scanner playContinuous = new Scanner(System.in);
            String isContinuous = playContinuous.next().toLowerCase();
//            Nếu người chơi không muốn chơi tiếp, gán điều kiện lặp về false và thoát vòng lặp
            if (!(isContinuous.equals("y") || isContinuous.equals("yes"))) {
                isPlay = false;
            }

        } while (isPlay);

//        Hiển thị báo cáo
        report(totalGames, totalGuess, bestGame);
    }

    public static int play() {
//        Hệ thống sinh ra một số ngẫu nhiên trong khoảng từ 0 đến MAXIMUM
        int luckyNumber = (int) (Math.random() * (MAXIMUM + 1));
//        System.out.println(luckyNumber);

        Scanner guess = new Scanner(System.in);
        int numsPlayerGuess = 0;
        boolean isCorrect = false;
//        Người chơi sẽ được nhập vào một số bất kỳ mà họ cho là trùng với con số may mắn - lucky number.
//        Kiểm tra độ chênh để đưa ra thông báo phù hợp cho người chơi, nếu người chơi đoán đúng thì kết thúc lượt chơi
        while (!isCorrect)
        {
            System.out.print("Bạn đoán? ");
            int guessNumber = guess.nextInt();
            numsPlayerGuess++;
//            kiểm tra xem số người dùng nhập vào có trùng với luckyNumber hay không
            if (guessNumber != luckyNumber) {
                if (guessNumber > luckyNumber) {
                    System.out.println("Số may mắn nhỏ hơn số dự đoán của bạn.");
                } else { // guessNumber < luckyNumber
                    System.out.println("Số may mắn lớn hơn số dự đoán của bạn.");
                }
            } else { // guessNumber == luckyNumber
                isCorrect = true;
                System.out.println("Chúc mừng bạn đã đoán đúng con số may mắn sau " + numsPlayerGuess + " lần dự đoán");
            }
        }
//        return số lần người chơi dự đoán trong lượt chơi
        return numsPlayerGuess;
    }

    public static void report(int games, int guesses, int best) {
        double avgGuess = (double) guesses / games;
        System.out.println("Kết quả tổng quát của trò chơi: ");
        System.out.println("Tổng số lần chơi = " + games);
        System.out.println("Tổng số lần dự đoán = " + guesses);
        System.out.println("Số lần dự đoán trung bình mỗi lượt = " + avgGuess);
        System.out.println("Số lần dự đoán ít nhất = " + best);
    }
}
