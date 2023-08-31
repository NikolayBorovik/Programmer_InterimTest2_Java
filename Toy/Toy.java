package Toy;

public abstract class Toy {
    int id;
    String name;
    protected int count;
    protected int weight;

    public Toy(String name, int count, int weight) {

        this.name = name;
        this.count = count;
        this.weight = weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        Toy temp = (Toy) o;
        return this.id == temp.id
                &&this.name == temp.name;
//                &&this.weight == temp.weight
//                &&this.count == temp.count;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", weight=" + weight +
                '}';
    }
}
