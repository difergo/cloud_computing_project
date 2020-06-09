package co.com.poli.taller1.taller1.exceptions;

public class CurrencyUniqueNameExceptionResponse {
    private String name;

    public CurrencyUniqueNameExceptionResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
