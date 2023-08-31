package Mapper;

public class UserMapper {

    public boolean validToyString(String s) {
        String[] lines = s.split(",");
        return lines.length == 4 && isDigit(lines[0])
                && (Integer.parseInt(lines[0]) < 3 || Integer.parseInt(lines[0]) > 1)
                && isDigit(lines[2]) && isDigit(lines[3]);
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
