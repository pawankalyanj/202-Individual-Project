package card;

public class Card {
    private String number, type, error;
    private boolean valid;

    public Card(String number) {
        this.number = number;
        valid = true;
    }

    public String getNumber(){return number;}
    public String getValue(){
        if(valid) return type;
        return error;
    }

    public String setInvalid(){this.valid = false;
        return null;
    }
    public boolean isValid(){return this.valid;}

    public void setError(String error){this.error = error;}

    public void setAmericanExpress(){this.type = "AmericanExpress";}
    public void setDiscover(){this.type = "Discover";}
    public void setMasterCard(){this.type = "MasterCard";}
    public void setVisa(){this.type = "Visa";}
}
