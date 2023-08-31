package MVP;

import java.util.List;

import Toy.Toy;
import Toy.Repository;

public class Lottery {
    Repository repository;

    public Lottery() {
        this.repository = new Repository();
    }

    public Toy hold(List<Toy> toys) {
        try {
            toys.isEmpty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Toy winToy = null;

        double completeWeight = 0.0;
        for (Toy item : toys)
            completeWeight += item.getWeight() ;
        double r = Math.random() * completeWeight;
        double countWeight = 0.0;
        for (Toy item : toys) {
            countWeight += item.getWeight();
            if (countWeight >= r) {
                winToy = item;
//                return winToy;
            }

        }
        return winToy;
    }
}
