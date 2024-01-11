public class Series  extends Movie{
    private int seriesCount;

    public Series(String title, int releaseYear, int duration, double rating, int seriesCount) {
        super(title, releaseYear, duration, rating);
        this.seriesCount = seriesCount;
    }
    Series(){

    }

    public int getSeriesCount() {
        return seriesCount;
    }

    public void setSeriesCount(int seriesCount) {
        this.seriesCount = seriesCount;
    }

     public int getTotalDuration(){
        int total = seriesCount * getDuration();
        return total;
    }
}
