import MVP.ConsoleView;
import MVP.Presenter;
import MVP.View;

public class App {
    public static void start(){
        View view = new ConsoleView();
        Presenter presenter = new Presenter(view);
        while(true){
            String key = view.getMessage("\n1 - Hold a lottery\n2 - Mark a toy as received" +
                    "\n3 - Show toys added to the lottery\n4 - Show toys pending awarding\n5 - Show collected toys" +
                    "\n6 - Exit");
            view.printMessage("\033[H\033[J");
            switch (key) {
                case "1" -> {
                    if (presenter.noToysInLottery()) {
                        view.printMessage("There are no toys in lottery. Please, add some toys.");
                        presenter.addToyToLottery();
                    }
                    presenter.holdLottery();
                }
                case "2" -> {
                    int id = view.getCollectedToyID();

                    try {
                        presenter.awardCollected(presenter.findInPending(id));
                    } catch (RuntimeException e) {
                        view.printMessage("You've entered an invalid ID or the toy does not exist.");
                    }
                }
                case "3" -> presenter.showToysInLottery();
                case "4" -> presenter.showToysPendingAwarding();
                case "5" -> presenter.showToysCollected();
                case "6" -> {
                    view.printMessage("Good bye!");
                    System.exit(0);
                }
                default -> System.out.println("Wrong command. Please, try again.");
            }
        }
    }

}
