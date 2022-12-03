package card;

public class Card {
    public String number, type, error;
    public boolean isValid;

    public Card(String number) {
        this.number = number;
        isValid = true;
    }

    public String getNumber(){return number;}
    public String getValue(){
        if(isValid) return type;
        return error;
    }

    public void setInvalid(){this.isValid = false;}

    public void setError(String error){this.error = error;}

    public void setAmericanExpress(){this.type = "American Express";}
    public void setDiscover(){this.type = "Discover";}
    public void setMaster(){this.type = "Master";}
    public void setVisa(){this.type = "Visa";}
}
