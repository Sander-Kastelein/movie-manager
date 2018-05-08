package nl.sanderkastelein.models;

public class Movie{

    private String name;

    private int releaseYear;

    private String countryOfOrigin;

    private double budget;

    public Movie(String name, int releaseYear, String countryOfOrigin, double budget){
        this.name = name;
        this.releaseYear = releaseYear;
        this.countryOfOrigin = countryOfOrigin;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public double getBudget() {
        return budget;
    }

    public String toString(){
        return this.name + " (" + this.releaseYear + ") " + "[" + this.countryOfOrigin + "] " + "<" + this.budget + ">";
    }
}
