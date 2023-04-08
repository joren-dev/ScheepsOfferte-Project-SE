package entities.klant;

public class KlantType {

    private String type_naam;
    private int korting;

    public KlantType(final String type_naam, final int korting) {
        this.korting = korting;
        this.type_naam = type_naam;
    }

    public String getTypeNaam() {
        return type_naam;
    }

    public void setTypeNaam(final String type_naam) {
        this.type_naam = type_naam;
    }

    public int getKorting() {
        return korting;
    }

    public void setKorting(final int korting) {
        this.korting = korting;
    }

    public String toString() {
        return String.format("Huidige waardes: naam=%s korting=%d", this.type_naam, this.korting);
    }
}
