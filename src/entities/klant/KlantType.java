package entities.klant;

public class KlantType {

    public KlantType(String type_naam, int korting){
        this.korting = korting;
        this.type_naam = type_naam;
    }

    public String getTypeNaam()
    {
        return type_naam;
    }

    public int getKorting()
    {
        return korting;
    }

    public void setTypeNaam(String type_naam){
        this.type_naam = type_naam;
    }

    public void setKorting(int korting){
        this.korting = korting;
    }

    public String toString() {
        return String.format("Huidige waardes: naam=%s korting=%d", this.type_naam, this.korting);
    }

    private String type_naam;
    private int korting;
}
