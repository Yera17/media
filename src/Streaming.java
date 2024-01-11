import java.util.Random;

public class Streaming {
    private Media[] media;

    public Media[] getMedia() {
        return media;
    }

    public Streaming(Media[] media) {
        this.media = media;
    }

    public Streaming(int size) {
        this.media = new Media[size];
    }

    // TODO: добавить медиа объект
    public void add(Media media) {
        int counter = 0;
        for (int i = 0; i < this.media.length; i++) {
            if (this.media[i] == null) {
                this.media[i] = media;
            } else {
                counter++;
            }
        }
        if (counter == this.media.length) {
            System.out.println("There is no place for it.");
        }
    }


    // TODO: вывести все фильмы/сериалы
    public void displayAll() {
        int counterOfMovies = 0;
        int counterOfSeries = 0;
        System.out.println();
        for (Media value : media) {
            if (value instanceof Series) {
                counterOfSeries++;
                System.out.println("Series : " + value.getTitle() + " : " + value.getReleaseYear() + " : " + ((Series) value).getRating() + " : " + value.getDuration() + "m : " + ((Series) value).getSeriesCount() + " ep.");
            } else {
                counterOfMovies++;
                System.out.println("Movie : " + value.getTitle() + " : " + value.getReleaseYear() + " : " + ((Movie) value).getRating() + " : " + value.getDuration() + "m");
            }
        }
        System.out.println("There is " + counterOfMovies + " movies and " + counterOfSeries + " series.");
    }

    // TODO: вывести все фильмы
    public void displayAllMovies() {
        System.out.println();
        System.out.println("All Movies: ");
        for (Media value : media) {
            if (value.getClass() == Movie.class) {
                System.out.println("Movie : " + value.getTitle() + " : " + value.getReleaseYear() + " : " + ((Movie) value).getRating() + " : " + value.getDuration() + "m");
            }
        }
        System.out.println();
    }

    // TODO: вывести все сериалы
    public void displayAllSeries() {
        System.out.println();
        System.out.println("All Series: ");
        for (int i = 0; i < media.length; i++) {
            if (media[i] instanceof Series) {
                System.out.println("Series : " + media[i].getTitle() + " : " + media[i].getReleaseYear()  + " : " + ((Series) media[i]).getRating()  + " : " + media[i].getDuration()  + "m : " + ((Series) media[i]).getSeriesCount() + " ep.");
            }
        }
        System.out.println();
    }

    // TODO: получить самый старый фильм
    public Movie getOldestMovie() {
        int yearOfOldestMovie = Integer.MAX_VALUE;
        Movie movie = null;
        for (Media value : media) {
            if (value.getClass() == Movie.class) {
                if (value.getReleaseYear() < yearOfOldestMovie) {
                    yearOfOldestMovie = value.getReleaseYear();
                    movie = (Movie) value;
                }
            }
        }
        return movie;
    }
    public Series getOldestSeries() {
        int yearOfOldestSeries = Integer.MAX_VALUE;
        Series series = null;
        for (Media value : media) {
            if (value instanceof Series) {
                if (value.getReleaseYear() < yearOfOldestSeries) {
                    yearOfOldestSeries = value.getReleaseYear();
                    series = (Series) value;
                }
            }
        }
        return series;
    }

    // TODO: получить рандомный объект Media
    public Media getRandom() {
        Random random = new Random();
        int randomMedia = random.nextInt(media.length);
        return media[randomMedia];
    }
}
