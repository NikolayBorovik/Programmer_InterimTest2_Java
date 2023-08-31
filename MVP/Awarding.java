package MVP;

import Toy.Toy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Toy.TeddyBear;
import Toy.WoodenCar;
import Toy.Barbie;
import Mapper.UserMapper;

public class Awarding {

    Lottery lottery;
    List<Toy> wonToys;

    List<Toy> receivedToys;
    private String path;

    private File file;

    public Awarding(Lottery lottery, String path) {
        this.lottery = lottery;
        this.wonToys = new ArrayList<>();
        this.receivedToys = new ArrayList<>();
        this.path = path;
        this.file = new File(path);
        load();
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

    private void load (){
        try{
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null){
                line = line.replace("Toy{id=", "");
                line = line.replace(", name='", " ");
                line = line.replace("', count=", " ");
                line = line.replace(", weight=", " ");
                line = line.replace("}", "");
                String[] lineArr = line.split(" ");

                int idInt = Integer.parseInt(lineArr[0]);
                String name = lineArr[1];
                int count = Integer.parseInt(lineArr[2]);
                int weight = Integer.parseInt(lineArr[3]);
                switch (idInt){
                    case 1 -> this.receivedToys.add(new TeddyBear(name, count, weight));
                    case 2 -> this.receivedToys.add(new WoodenCar(name, count, weight));
                    case 3 -> this.receivedToys.add(new Barbie(name, count, weight));
                }
                line = br.readLine();
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println("Could not load the load file. Please, check it.");
        }
    }

    public void save (){
        try{
            FileWriter fw = new FileWriter(path, true);
            for (int i = 0; i < this.receivedToys.size(); i++) {
                Toy temp = this.receivedToys.get(i);
                fw.write(String.valueOf(temp));
                fw.write("\n");
            }
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
