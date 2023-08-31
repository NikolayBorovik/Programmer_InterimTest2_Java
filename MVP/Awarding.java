package MVP;

import Toy.Toy;

import java.util.ArrayList;
import java.util.List;

public class Awarding {

    Lottery lottery;
    List<Toy> wonToys;

    List<Toy> receivedToys;

    public Awarding(Lottery lottery) {
        this.lottery = lottery;
        this.wonToys = new ArrayList<>();
        this.receivedToys = new ArrayList<>();
    }

    public void addWonToy(Toy toy) {
        wonToys.add(toy);
    }

    public List<Toy> getReceivedToys() {
        return receivedToys;
    }

    public List<Toy> getWonToys() {
        return wonToys;
    }

    public void addReceivedToy(Toy toy) {
        receivedToys.add(toy);
    }
}
