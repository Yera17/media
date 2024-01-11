import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Streaming streaming;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of movies and series: ");
        streaming = new Streaming(scanner.nextInt());

        toCreateMediaGallery(streaming.getMedia());

        streaming.displayAll();

        amountOfMediaInDays(streaming.getMedia());

        streaming.displayAllMovies();
        streaming.displayAllSeries();

        System.out.println("The oldest movie is " + streaming.getOldestMovie().getTitle() + " : " + streaming.getOldestMovie().getReleaseYear());
        System.out.println("The oldest series is " + streaming.getOldestSeries().getTitle() + " : " + streaming.getOldestSeries().getReleaseYear());

        if (streaming.getRandom() instanceof Series) {
            System.out.println("Today" + "'" + "s series is " + streaming.getRandom().getTitle());
        } else {
            System.out.println("Today" + "'" + "s movie is " + streaming.getRandom().getTitle());
        }
    }
    static void toCreateMediaGallery(Media[] media) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        for (int i = 0; i < media.length; i++) {
            System.out.println("1. Enter a movie");
            System.out.println("2. Enter a series");
            System.out.print("Choose what you want to enter: ");
            choice = scanner.nextInt();
            if (choice == 1) {
                media[i] = new Movie();
                System.out.print("Enter the title of the movie: ");
                System.out.print(scanner.nextLine());
                media[i].setTitle(scanner.nextLine());
                System.out.print("Enter released year of the movie: ");
                media[i].setReleaseYear(scanner.nextInt());
                System.out.print("Enter the rating of the movie: ");
                ((Movie) media[i]).setRating(scanner.nextDouble());
                System.out.print("Enter the duration of the movie: ");
                media[i].setDuration(scanner.nextInt());

            } else if (choice == 2) {
                media[i] = new Series();
                System.out.print("Enter the title of the series: ");
                System.out.print(scanner.nextLine());
                media[i].setTitle(scanner.nextLine());
                System.out.print("Enter released year of the series: ");
                media[i].setReleaseYear(scanner.nextInt());
                System.out.print("Enter the rating of the series: ");
                ((Movie) media[i]).setRating(scanner.nextDouble());
                System.out.print("Enter the average duration of episodes: ");
                media[i].setDuration(scanner.nextInt());
                System.out.print("Enter the number of episodes of the series: ");
                ((Series) media[i]).setSeriesCount(scanner.nextInt());
            }
        }
    }
    static void toDisplayAll(Media[] media){
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
        System.out.println("There are " + counterOfMovies + " movies and " + counterOfSeries + " series.");
    }
    static void amountOfMediaInDays(Media[] media){
        int counter = 0;
        for (Media value : media) {
            if (value instanceof Series) {
                counter += ((Series) value).getTotalDuration();
            } else {
                counter += value.getDuration();
            }
        }
        int days = (counter / (60 * 24));
        int hours = ((counter % (60 * 24)) / 60);
        int minutes = ((counter % (60 * 24)) % 60);
        if (days == 0 && hours == 0) {
            System.out.println("It takes only " + minutes + " minutes to watch all the media. ");
        } else if (days == 0) {
            System.out.println("It takes only " + hours + " hours and " + minutes + " minutes to watch all the media. ");
        } else {
            System.out.println("It takes " + days + " days, " + hours + " hours and " + minutes + " minutes to watch all the media. ");
        }
    }
}