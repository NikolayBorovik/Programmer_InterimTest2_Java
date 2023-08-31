package MVP;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class ConsoleView implements View {
    Scanner in = new Scanner(System.in);

    @Override
    public String getMessage(String str) {
        System.out.print("\033[H\033[J");// ru.stackoverflow.com/questions/1315049/Как-очистить-консоль-в-java-во-время-действия-программы
        System.out.println(str);
        return in.nextLine();
    }

    @Override
    public void printMessage(String str) {
        System.out.println(str);
    }
    @Override
    public int getCollectedToyID(){
        Scanner in = new Scanner(System.in);
        this.printMessage("Please, enter id of the toy collected: ");
        return Integer.parseInt(in.nextLine());
    }


}
