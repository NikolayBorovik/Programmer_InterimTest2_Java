package Mapper;

import Toy.Toy;

public interface Mapper<E, T> {
    String toInput(Toy toy);

    //    T toInput(E e);
    E toOutput(T t);
}

