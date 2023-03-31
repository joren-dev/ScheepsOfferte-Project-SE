package klant;

public class Klant {
    public double korting;
    private String naam;
    private String bedrijf;
    private String adres;
    private String email;
    private String telefoon;
    private KlantType type;

    /**
     * @param naam
     * @param bedrijf
     * @param adres
     * @param email
     * @param telefoon
     * @param type
     */
    public Klant(String naam, String bedrijf, String adres, String email, String telefoon, KlantType type) {
        this.naam = naam;
        this.bedrijf = bedrijf;
        this.adres = adres;
        this.email = email;
        this.telefoon = telefoon;
        this.type = type;

    }

    /**
     * @param naam
     * @param adres
     * @param email
     * @param telefoon
     * @param type
     */
    public Klant(String naam, String adres, String email, String telefoon, KlantType type) {
        this.naam = naam;
        this.adres = adres;
        this.email = email;
        this.telefoon = telefoon;
        this.type = type;

    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBedrijf() {
        return bedrijf;
    }

    public void setBedrijf(String bedrijf) {
        this.bedrijf = bedrijf;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoon() {
        return telefoon;
    }

    public void setTelefoon(String telefoon) {
        this.telefoon = telefoon;
    }

    public KlantType getKlantType() {
        return type;
    }

    public void setKlantType(KlantType type) {
        this.type = type;
    }

    public double getKlantKorting() {
        return type.getKorting();
    }
}


