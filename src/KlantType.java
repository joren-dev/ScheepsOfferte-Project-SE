import java.util.ArrayList;
import java.util.Objects;

public class KlantType {
    private String typenaam;
    private double korting;
    public static ArrayList<KlantType> klantTypen = new ArrayList<>();

    public KlantType(String typenaam, double korting) {
        this.typenaam = typenaam.toLowerCase();
        this.korting = korting;
        if (KlantType.klantTypen.stream().noneMatch((x) -> x.typenaam.equals(typenaam.toLowerCase()))) {
            KlantType.klantTypen.add(this);
        }
    }

    public void deleteKlantType(String typenaam) {
        KlantType.klantTypen.removeIf((x) -> x.typenaam.equals(typenaam.toLowerCase()));
    }
    public String toString() {
        return String.format("KlantType naam=%s korting=%.2f", this.typenaam, this.korting);
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
