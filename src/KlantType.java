public class KlantType {
    private String typenaam;
    private double korting;

    public KlantType(String typenaam, double korting) {
        this.typenaam = typenaam;
        this.korting = korting;
    }

    public String getTypeNaam() {
        return typenaam;
    }

    public void setTypeNaam(String typenaam) {
        this.typenaam = typenaam;
    }

    public double getKorting() {
        return korting;
    }

    public void setKorting(double korting) {
        this.korting = korting;
    }
}
