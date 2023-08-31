package Mapper;

import Toy.Toy;

public class UserMapper {

    public boolean stringParse(String s) {
        String[] lines = s.split(",");
        return lines.length == 4 && isDigit(lines[0]) && isDigit(lines[2]) && isDigit(lines[3]);
    }

    public boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
