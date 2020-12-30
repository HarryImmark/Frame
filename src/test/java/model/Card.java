package model;

public class Card
{
    private String number;
    private String cvc;
    private String dateMonth;
    private String dateYear;

    public Card(String number, String cvc, String dateMonth, String  dateYear)
    {
        this.number = number;
        this.cvc = cvc;
        this.dateMonth = dateMonth;
        this.dateYear = dateYear;
    }

    public String getCvc() { return cvc; }
    public void setCvc(String cvc) { this.cvc = cvc; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getDateMonth() { return dateMonth; }
    public void setDateMonth(String dateMonth) { this.dateMonth = dateMonth; }

    public String getDateYear() { return dateYear; }
    public void setDateYear(String dateYear) { this.dateYear = dateYear; }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", cvc='" + cvc + '\'' +
                ", dateMonth='" + dateMonth + '\'' +
                ", dateYear='" + dateYear + '\'' +
                '}';
    }
}
