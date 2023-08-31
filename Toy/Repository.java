package Toy;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    List<Toy> toys;


    public Repository() {
        this.toys = new ArrayList<>();
    }

    public void addToy (Toy toy){
//        add a check for whether the toy exists in the repo
        toys.add(toy);
    }

    public void setToyWeight (Toy toy, int value){
        for (Toy item: toys) {
            if(item.equals(toy)){
                item.setWeight(value);
            }
        }
    }

    public void setToyQty(Toy toy, int value) throws IllegalArgumentException{
        for (Toy item: toys) {
            if(item.equals(toy)){
                if(item.getCount()<1) throw new IllegalArgumentException();
                else if (item.getCount()==1) {
                    item.setCount(value);
//                    System.out.println("Qty changed");
                    throw new IllegalArgumentException();
                }
                item.setCount(value);
//                System.out.println("Qty changed");
            }
        }
    }

    public int getToyQty(Toy toy) throws IllegalArgumentException{
        for (Toy item: toys) {
            if(item.equals(toy)){
                return item.getCount();
            }
        }
        throw new IllegalArgumentException();
    }

    public int getToysCount(){
        return toys.size();
    }

    public List<Toy> getToys() {
        return toys;
    }
}
