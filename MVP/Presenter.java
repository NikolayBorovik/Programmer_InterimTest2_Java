package MVP;

import Mapper.UserMapper;
import Toy.Toy;
import Toy.TeddyBear;
import Toy.WoodenCar;
import Toy.Barbie;


import java.util.List;

public class Presenter {
    View view;
    Lottery lottery;

    Awarding awarding;

    private final UserMapper mapper;

    public Presenter(View view) {
        this.view = view;
        this.lottery = new Lottery();
        this.awarding = new Awarding(lottery);
        this.mapper = new UserMapper();
    }

    public void holdLottery(){
        Toy winToy = lottery.hold(lottery.repository.getToys());
        view.printMessage("The winning toy this time is: " + winToy);
        awarding.addWonToy(winToy);
        try {
            lottery.repository.setToyQty(winToy, lottery.repository.getToyQty(winToy)-1);
        } catch (IllegalArgumentException e) {
            lottery.repository.getToys().remove(winToy);
            view.printMessage("You've run out of the toy " + winToy.getName() + ", id: " + winToy.getId() +
                    ".\nIt has been removed from the lottery");
        }
    }

    public void addToyToLottery(){
        String answer = view.getMessage("Enter toy id, name, count, weight (all separated by commas with " +
                "no spaces): ");
        boolean done = false;
        while(!done){
            if(checkFields(answer)) done = true;
            else{
                System.out.println("Wrong entry");
                answer = view.getMessage("Enter toy id, name, count, weight (all separated by commas with " +
                        "no spaces): ");
            }
        }
        String[] lines = answer.split(",");
        int id = Integer.parseInt(lines[0]);
        String name = lines[1];
        int weight = Integer.parseInt(lines[2]);
        int count = Integer.parseInt(lines[3]);

        String toyType = view.getMessage("Enter a type of the toy you'd like to create (1 - teddybear, " +
                "2 - woodencar, 3 - barbie): ");

        done = false;
        while(!done){
            if(mapper.isDigit(toyType)){
                switch (Integer.parseInt(toyType)) {
                    case 1 -> {
                        TeddyBear toy = new TeddyBear(id, name, weight, count);
                        lottery.repository.addToy(toy);
                        view.printMessage("The toy " + toy.getName() + " successfully added!");
                        done = true;
                        String more = view.getMessage("Add another toy? (1 - yes 2 - no): ");
                        switch(more){
                            case "1":
                                addToyToLottery();
                                break;
                            case "2":
                                done = true;
                                break;
                        }
                    }
                    case 2 -> {
                        Toy toy = new WoodenCar(id, name, weight, count);
                        lottery.repository.addToy(toy);
                        view.printMessage("The toy " + toy.getName() + " successfully added!");
                        done = true;
                        String more = view.getMessage("Add another toy? (1 - yes 2 - no): ");
                        switch(more){
                            case "1":
                                addToyToLottery();
                                break;
                            case "2":
                                done = true;
                                break;
                        }
                    }

                    case 3 -> {
                        Toy toy = new Barbie(id, name, weight, count);
                        lottery.repository.addToy(toy);
                        view.printMessage("The toy " + toy.getName() + " successfully added!");
                        done = true;
                        String more = view.getMessage("Add another toy? (1 - yes 2 - no): ");
                        switch(more){
                            case "1":
                                addToyToLottery();
                                break;
                            case "2":
                                done = true;
                                break;
                        }
                    }
                    default -> {
                        view.printMessage("Wrong entry. def ");
                        toyType = view.getMessage("Enter a type of the toy you'd like to create (1 - teddybear, " +
                                "2 - woodcar, 3 - barbie): ");
                    }
                }
            }
            else{
                view.printMessage("Wrong entry. else");
                toyType = view.getMessage("Enter a type of the toy you'd like to create (1 - teddybear, " +
                        "2 - woodcar, 3 - barbie): ");
            }

        }
    }

    private boolean checkFields(String str){
        return mapper.stringParse(str);
    }

    public void awardCollected (Toy toy){
        awarding.addReceivedToy(toy);
        awarding.wonToys.remove(toy);
        view.printMessage("The toy name: " + toy.getName() + " marked as received!");
    }

    public Toy findInPending(int id) throws RuntimeException{
        for (Toy item: awarding.wonToys) {
            if(item.getId() == id) return item;
        }
        throw new RuntimeException();
    }

    public void showToysInLottery(){
        List<Toy> toys = lottery.repository.getToys();
        if (toys.isEmpty()) {
            System.out.println("No items");}
        for (Toy item: toys) {
            System.out.println(item);
        }
    }

    public void showToysPendingAwarding() {
        List<Toy> toys = awarding.getWonToys();
        if (toys.isEmpty()) {
            System.out.println("No items");
        }
        for (Toy item: toys) {
            System.out.println(item);
        }
    }

    public boolean noToysInLottery(){
        return lottery.repository.getToys().isEmpty();
    }


    public void showToysCollected() {
        List<Toy> toys = awarding.receivedToys;
        if (toys.isEmpty()) {
            System.out.println("No items");
        }
        for (Toy item: toys) {
            System.out.println(item);
        }
    }
}
