public class Movie extends Media{
    private double rating;

    public Movie(String title, int releaseYear, int duration, double rating) {
        super(title, releaseYear, duration);
        this.rating = rating;
    }
    Movie(){

    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
