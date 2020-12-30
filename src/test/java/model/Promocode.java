package model;

public class Promocode
{
    private String code;

    public Promocode(String code)
    {
        this.code = code;
    }

    public String getPromocode() {
        return code;
    }

    public void setPromocode(String username) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Promocode:{" +
                "Code='" + code + '\'' +
                '}';
    }
}

