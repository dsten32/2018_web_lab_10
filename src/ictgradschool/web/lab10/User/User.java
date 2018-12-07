package ictgradschool.web.lab10.User;

public class User {
    String ufName=null;
    String ulName=null;
    String uCountry=null;
    String uCity=null;

    public User(String ufName, String ulName, String uCountry, String uCity) {
        this.ufName = ufName;
        this.ulName = ulName;
        this.uCountry = uCountry;
        this.uCity = uCity;
    }

    public String getUfName() {
        return ufName;
    }

    public String getUlName() {
        return ulName;
    }

    public String getuCountry() {
        return uCountry;
    }

    public String getuCity() {
        return uCity;
    }
}
