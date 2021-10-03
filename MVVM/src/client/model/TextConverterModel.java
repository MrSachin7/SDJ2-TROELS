package client.model;

public class TextConverterModel implements TextConverter {
    @Override
    public String toUpperCase(String txt) {
        return txt.toUpperCase();
    }
}
