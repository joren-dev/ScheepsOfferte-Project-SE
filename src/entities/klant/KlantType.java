package entities.klant;

public class KlantType {
    private String type_naam;
    private double korting;
    public KlantType(String type_naam, double korting){
        this.korting = korting;
        this.type_naam = type_naam;
    }

    public String getTypeNaam()
    {
        return type_naam;
    }

    public double getKorting()
    {
        return korting;
    }

    public void setTypeNaam(String type_naam){
        this.type_naam = type_naam;
    }

    public void setKorting(double korting){
        this.korting = korting;
    }

    public String toString() {
        return String.format("Huidige waardes: naam=%s korting=%.2f", this.type_naam, this.korting);
    }
}
