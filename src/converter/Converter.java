package converter;

public class Converter {
    private String numb;

    public Converter() {
        numb = new String();
    }

    public Converter(String numb) {
        this.numb = numb;
    }

    public String returnValue() {
        return numb;
    }

    public int convertString() throws StringNotValidException {
        String regex = ".*[a-zA-Z].*";
        int min = -32768;
        int max = 32767;

        if (numb.contains(" ") && numb.lastIndexOf(" ") != 0) {
            throw new StringNotValidException();
        }

        if (numb.contains("+") && numb.lastIndexOf("+") != 0) {
            throw new StringNotValidException();
        }

        if (numb.contains("-") && numb.lastIndexOf("-") != 0) {
            throw new StringNotValidException();
        }

        if (numb.contains(".")) {
            throw new StringNotValidException();
        }

        if (numb.contains(",")) {
            throw new StringNotValidException();
        }

        if (numb.matches(regex)) {
            throw new StringNotValidException();
        }

        if (numb.lastIndexOf(" ") == 0) {
            numb = numb.replace(" ", "");
        }

        if (numb.startsWith("+")) {
            numb = numb.replace("+", "");
        }

        if (Integer.parseInt(numb) < min || Integer.parseInt(numb) > max) {
            throw new StringNotValidException();
        }

        return Integer.parseInt(numb);
    }
}
