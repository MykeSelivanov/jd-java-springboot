package com.cinemaapp.bootstrap;


import com.cinemaapp.entity.*;
import com.cinemaapp.enums.MovieState;
import com.cinemaapp.enums.MovieType;
import com.cinemaapp.enums.UserRole;
import com.cinemaapp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//@Component
public class DataGenerator implements CommandLineRunner {

    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public DataGenerator(MovieRepository movieRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, UserRepository userRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository) {
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
    }
    /**
     * User objects.
     */
    public User u1 = new User("josie_story@email.com", "123123123", "josieStory");
    public User u2 = new User("bernard@email.com", "123123123", "bernard");
    public User u3 = new User("faith.p@email.com", "123123123", "faith");
    public User u4 = new User("johnnie@email.com", "123123123", "johnnie");
    public User u5 = new User("lawrence.f@email.com", "123123123", "lawrence.f");
    /**
     * Cinema objects
     */
    public Cinema c1 = new Cinema("Hall 1 - EMPIRE", "McDonald");
    public Cinema c2 = new Cinema("Hall 2 - EMPIRE", "Kodak");
    public Cinema c3 = new Cinema("Hall 3 - EMPIRE", "Act Vision");
    public Cinema c4 = new Cinema("Hall 4 - EMPIRE", "Quick Vision");
    public Cinema c5 = new Cinema("Hall 1 - STREET 14", "Du Pont");
    public Cinema c6 = new Cinema("Hall 2 - STREET 14", "HBO");
    public Cinema c7 = new Cinema("Hall 3 - STREET 14", "MySpace");
    public Cinema c8 = new Cinema("Hall 4 - STREET 14", "PlayStation");
    public Cinema c9 = new Cinema("Hall 1 - SQUARE 13", "Walt Disney");
    public Cinema c10 = new Cinema("Hall 2 - SQUARE 13", "Sony Corporation");
    public Cinema c11 = new Cinema("Hall 3 - SQUARE 13", "Warner Bros");
    public Cinema c12 = new Cinema("Hall 4 - SQUARE 13", "PlayStation");
    public Cinema c13 = new Cinema("Hall 1 - VILLAGE 7", "Du Pont");
    public Cinema c14 = new Cinema("Hall 2 - VILLAGE 7", "Kodak");
    public Cinema c15 = new Cinema("Hall 3 - VILLAGE 7", "MySpace");
    public Cinema c16 = new Cinema("Hall 4 - VILLAGE 7", "Channel 4");
    /**
     * Movie Objects.
     */
    public Movie m1 = new Movie("The Gentleman", LocalDate.of(2020,1,24), 113, MovieType.REGULAR, MovieState.ACTIVE,new BigDecimal("20.00"));
    public Movie m2 = new Movie("A Beautiful Mind",LocalDate.of(2002,1,04),135, MovieType.REGULAR, MovieState.DRAFT,new BigDecimal("15.00"));
    public Movie m3 = new Movie("The Shawshank Redemption",LocalDate.of(1994,10,14),142, MovieType.REGULAR, MovieState.DRAFT,new BigDecimal("35.00"));
    public Movie m4 = new Movie("The Godfather",LocalDate.of(1972,3,24), 175, MovieType.REGULAR, MovieState.DRAFT,new BigDecimal("35.00"));
    public Movie m5 = new Movie("Tenet",LocalDate.of(2020,9,3), 150, MovieType.PREMIER, MovieState.ACTIVE,new BigDecimal("35.00"));
    public Movie m6 = new Movie("The Loss Adjuster",LocalDate.of(2020,12,29), 100, MovieType.PREMIER, MovieState.DRAFT,new BigDecimal("35.00"));
    public Movie m7 = new Movie("The Nights Before Christmas", LocalDate.of(2020,11,19), 100, MovieType.REGULAR, MovieState.ACTIVE,new BigDecimal("28.00"));
    public Movie m8 = new Movie("Spider-Man: Miles Morales",LocalDate.of(2020,12,12), 130, MovieType.REGULAR, MovieState.DRAFT,new BigDecimal("28.00"));
    public Movie m9 = new Movie("Avengers: Endgame",LocalDate.of(2019,4,26), 181, MovieType.REGULAR, MovieState.DRAFT,new BigDecimal("48.00"));
    /**
     * Movie Cinema objects.
     */
    public MovieCinema mc1 = new MovieCinema(LocalDateTime.of(2020,12,5,20,00));
    public MovieCinema mc2 = new MovieCinema(LocalDateTime.of(2020,12,5,19,00));
    public MovieCinema mc3 = new MovieCinema(LocalDateTime.of(2020,12,5,18,45));
    public MovieCinema mc4 = new MovieCinema(LocalDateTime.of(2020,12,5,18,45));
    public MovieCinema mc5 = new MovieCinema(LocalDateTime.of(2020,12,5,21,30));
    public MovieCinema mc6 = new MovieCinema(LocalDateTime.of(2020,12,6,20,00));
    public MovieCinema mc7 = new MovieCinema(LocalDateTime.of(2020,12,6,19,00));
    public MovieCinema mc8 = new MovieCinema(LocalDateTime.of(2020,12,6,18,00));
    public MovieCinema mc9 = new MovieCinema(LocalDateTime.of(2020,12,6,20,45));
    public MovieCinema mc10 = new MovieCinema(LocalDateTime.of(2020,12,6,21,30));
    public MovieCinema mc11 = new MovieCinema(LocalDateTime.of(2020,12,6,20,00));
    public MovieCinema mc12 = new MovieCinema(LocalDateTime.of(2020,12,6,19,00));
    public MovieCinema mc13 = new MovieCinema(LocalDateTime.of(2020,12,6,18,00));
    public MovieCinema mc14 = new MovieCinema(LocalDateTime.of(2020,12,6,20,45));
    public MovieCinema mc15 = new MovieCinema(LocalDateTime.of(2020,12,6,21,30));
    public MovieCinema mc16 = new MovieCinema(LocalDateTime.of(2020,12,6,20,00));
    public MovieCinema mc17 = new MovieCinema(LocalDateTime.of(2020,12,6,19,00));
    public MovieCinema mc18 = new MovieCinema(LocalDateTime.of(2020,12,6,18,00));
    public MovieCinema mc19 = new MovieCinema(LocalDateTime.of(2020,12,6,20,45));
    public MovieCinema mc20 = new MovieCinema(LocalDateTime.of(2020,12,6,21,30));
    public MovieCinema mc21 = new MovieCinema(LocalDateTime.of(2020,12,26,18,00));
    public MovieCinema mc22 = new MovieCinema(LocalDateTime.of(2020,12,26,20,00));
    public MovieCinema mc23 = new MovieCinema(LocalDateTime.of(2020,12,26,20,30));
    public MovieCinema mc24 = new MovieCinema(LocalDateTime.of(2020,12,26,18,30));
    public MovieCinema mc25 = new MovieCinema(LocalDateTime.of(2020,12,26,21,30));
    public MovieCinema mc26 = new MovieCinema(LocalDateTime.of(2020,12,26,19,00));
    public MovieCinema mc27 = new MovieCinema(LocalDateTime.of(2020,12,26,19,45));
    public MovieCinema mc28 = new MovieCinema(LocalDateTime.of(2020,12,26,22,00));

    Account a1 = new Account("Josie D Story", "262  Lochmere Lane", "United States", "Kentucky", "LOUISVILLE", 35, "40289", UserRole.USER);
    Account a2 = new Account("Bernard P Fendley", "2903  Jarvis Street", "United States", "New York", "Buffalo", 28, "14211", UserRole.USER);
    Account a3 = new Account("Faith R Parsons", "4161  Alfred Drive", "United States", "New York", "Brooklyn", 47, "11226", UserRole.USER);
    Account a4 = new Account("Johnnie J Cannon", "2587  Logan Lane", "United States", "New York", "HOLTSVILLE", 47, "00544", UserRole.USER);
    Account a5 = new Account("Lawrence E Folkerts", "698  Clark Street", "United States", "New York", "Brentwood", 47, "11717", UserRole.USER);

    Location l1 = new Location("AMC Empire 25",null,null, 10036,"United States","New York", "New York","234 W 42nd St") ;
    Location l2 = new Location("AMC 34th Street 14",null,null, 10001, "United States", "New York", "New York","312 W 34th St");
    Location l3 = new Location("AMC Lincoln Square 13",null,null, 10023, "United States", "New York", "New York", "1998 Broadway");
    Location l4 = new Location("AMC Village 7",null,null, 10003, "United States", "New York", "New York", "66 3rd Ave");

    Genre g1 = new Genre("Comedy");
    Genre g2 = new Genre("Sci-Fi");
    Genre g3 = new Genre("Action");
    Genre g4 = new Genre("Horror");
    Genre g5 = new Genre("Thriller");
    Genre g6 = new Genre("Drama");
    Genre g7 = new Genre("Mystery");
    Genre g8 = new Genre("Crime");
    Genre g9 = new Genre("Animation");
    Genre g10 = new Genre("Adventure");
    Genre g11 = new Genre("History");
    Genre g12 = new Genre("Fantasy");
    Genre g13 = new Genre("Biography");

    Ticket t1 = new Ticket(15, 14, LocalDateTime.of(2020,12,5,20,00));
    Ticket t2 = new Ticket(7, 18, LocalDateTime.of(2020,12,5,20,00));
    Ticket t3 = new Ticket(9, 9, LocalDateTime.of(2020,12,5,20,00));
    Ticket t4 = new Ticket(18, 12, LocalDateTime.of(2020,12,5,20,00));
    Ticket t5 = new Ticket(5, 11, LocalDateTime.of(2020,12,5,20,00));
    Ticket t6 = new Ticket(15, 14, LocalDateTime.of(2020,12,6,20,45));
    Ticket t7 = new Ticket(7, 18, LocalDateTime.of(2020,12,6,20,45));
    Ticket t8 = new Ticket(9, 9, LocalDateTime.of(2020,12,6,20,45));
    Ticket t9 = new Ticket(18, 12, LocalDateTime.of(2020,12,6,20,45));
    Ticket t10 = new Ticket(5, 11, LocalDateTime.of(2020,12,6,20,45));
    Ticket t11 = new Ticket(15, 14, LocalDateTime.of(2020,12,7,21,30));
    Ticket t12 = new Ticket(7, 18, LocalDateTime.of(2020,12,7,21,30));
    Ticket t13 = new Ticket(9, 9, LocalDateTime.of(2020,12,7,21,30));
    Ticket t14 = new Ticket(18, 12, LocalDateTime.of(2020,12,7,21,30));
    Ticket t15 = new Ticket(5, 11, LocalDateTime.of(2020,12,7,21,30));
    Ticket t16 = new Ticket(15, 14, LocalDateTime.of(2020,12,8,19,00));
    Ticket t17 = new Ticket(7, 18, LocalDateTime.of(2020,12,8,19,00));
    Ticket t18 = new Ticket(9, 9, LocalDateTime.of(2020,12,8,19,00));
    Ticket t19 = new Ticket(18, 12, LocalDateTime.of(2020,12,8,19,00));
    Ticket t20 = new Ticket(5, 11, LocalDateTime.of(2020,12,8,19,00));


    @Override
    public void run(String... args) throws Exception {
        createUsers();
        createCinemasAndLocations();
        createMoviesAndGenres();
        scheduleMovies();
        bookAMovie();
    }
    /**
     * Create users.
     */
    private void createUsers() {
        u1.setAccount(a1);
        u2.setAccount(a2);
        u3.setAccount(a3);
        u4.setAccount(a4);
        u5.setAccount(a5);
        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
    }
    /**
     * create cinemas and locations.
     */
    private void createCinemasAndLocations() {
        c1.setLocation(l1);
        c2.setLocation(l1);
        c3.setLocation(l1);
        c4.setLocation(l1);
        c5.setLocation(l2);
        c6.setLocation(l2);
        c7.setLocation(l2);
        c8.setLocation(l2);
        c9.setLocation(l3);

        c10.setLocation(l3);
        c11.setLocation(l3);
        c12.setLocation(l3);
        c13.setLocation(l4);
        c14.setLocation(l4);
        c15.setLocation(l4);
        c16.setLocation(l4);

        Set<Cinema> cinemas = new HashSet<>();
        cinemas.addAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16));
        cinemaRepository.saveAll(cinemas);
    }
    /**
     * Create movies and genres.
     */
    private void createMoviesAndGenres() {
        Set<Genre> genre = new HashSet<>();
        genre.addAll(Arrays.asList(g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13));
        genreRepository.saveAll(genre);

        m1.setSummary("An American expat tries to sell off his highly profitable marijuana empire in London, triggering plots, schemes, bribery and blackmail in an attempt to steal his domain out from under him.");
        m2.setSummary("After John Nash, a brilliant but asocial mathematician, accepts secret work in cryptography, his life takes a turn for the nightmarish.");
        m3.setSummary("Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency");
        m4.setSummary("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son");
        m5.setSummary("Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time");
        m6.setSummary("Hapless Insurance Loss Adjuster - Martin Dyer - feels his life is spiralling out of control but discovers that even when you reach rock bottom, that some clouds really do have a silver lining");
        m7.setSummary("A murderous Santa and Mrs Claus play a cat and mouse game with the FBI.");
        m8.setSummary("In this sequel of Marvel's Spider-Man (2018), you can play as Miles Morales as a new and different Spider-Man while he learns some stories about his will of fighting crime and serving justice by his mentor and former hero, Peter Parker.");
        m9.setSummary("After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.");

        m1.setGenreList(new HashSet<>(Arrays.asList(g3, g1, g8)));
        m2.setGenreList(new HashSet<>(Arrays.asList(g13, g6)));
        m3.setGenreList(new HashSet<>(Arrays.asList(g6)));
        m4.setGenreList(new HashSet<>(Arrays.asList(g6, g8)));
        m5.setGenreList(new HashSet<>(Arrays.asList(g2, g3)));
        m6.setGenreList(new HashSet<>(Arrays.asList(g1)));
        m7.setGenreList(new HashSet<>(Arrays.asList(g4)));
        m8.setGenreList(new HashSet<>(Arrays.asList(g3, g8, g10)));
        m9.setGenreList(new HashSet<>(Arrays.asList(g3, g10)));

        Set<Movie> movies = new HashSet<>();
        movies.addAll(Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9));
        movieRepository.saveAll(movies);
    }
    /**
     * Shcedule a movie.
     */
    private void scheduleMovies() {
        mc1.setMovie(m1);
        mc1.setCinema(c1);
        mc2.setMovie(m1);
        mc2.setCinema(c7);
        mc3.setMovie(m1);
        mc3.setCinema(c10);
        mc4.setMovie(m1);
        mc4.setCinema(c12);
        mc5.setMovie(m1);
        mc5.setCinema(c14);
        mc6.setMovie(m5);
        mc6.setCinema(c1);
        mc7.setMovie(m5);
        mc7.setCinema(c7);
        mc8.setMovie(m5);
        mc8.setCinema(c12);
        mc9.setMovie(m5);
        mc9.setCinema(c12);
        mc10.setMovie(m5);
        mc10.setCinema(c14);
        mc11.setMovie(m7);
        mc11.setCinema(c1);
        mc12.setMovie(m7);
        mc12.setCinema(c7);
        mc13.setMovie(m7);
        mc13.setCinema(c12);
        mc14.setMovie(m7);
        mc14.setCinema(c12);
        mc15.setMovie(m7);
        mc15.setCinema(c14);
        mc16.setMovie(m2);
        mc16.setCinema(c1);
        mc17.setMovie(m3);
        mc17.setCinema(c7);
        mc18.setMovie(m4);
        mc18.setCinema(c12);
        mc19.setMovie(m8);
        mc19.setCinema(c12);
        mc20.setMovie(m9);
        mc20.setCinema(c14);
        mc21.setMovie(m6);
        mc21.setCinema(c1);
        mc22.setMovie(m6);
        mc22.setCinema(c1);
        mc23.setMovie(m6);
        mc23.setCinema(c2);
        mc24.setMovie(m6);
        mc24.setCinema(c2);
        mc25.setMovie(m6);
        mc25.setCinema(c3);
        mc26.setMovie(m6);
        mc26.setCinema(c3);
        mc27.setMovie(m6);
        mc27.setCinema(c4);
        mc28.setMovie(m6);
        mc28.setCinema(c4);

        Set<MovieCinema> movieCinemas = new HashSet<>();
        movieCinemas.addAll(Arrays.asList(mc1, mc2, mc3, mc4, mc5, mc5, mc6, mc7, mc8, mc9, mc10, mc11, mc12, mc13, mc14, mc15, mc16, mc17, mc18, mc19, mc20,mc21, mc22, mc23, mc24, mc25, mc26, mc27, mc28 ));
        movieCinemaRepository.saveAll(movieCinemas);
    }
    /**
     * Book a movie.
     */
    private void bookAMovie() {
        t1.setUser(u1);
        t1.setMovieCinema(mc1);
        t2.setUser(u2);
        t2.setMovieCinema(mc1);
        t3.setUser(u3);
        t3.setMovieCinema(mc1);
        t4.setUser(u4);
        t4.setMovieCinema(mc1);
        t5.setUser(u5);
        t5.setMovieCinema(mc1);
        t6.setUser(u1);
        t6.setMovieCinema(mc8);
        t7.setUser(u2);
        t7.setMovieCinema(mc8);
        t8.setUser(u3);
        t8.setMovieCinema(mc8);
        t9.setUser(u4);
        t9.setMovieCinema(mc8);
        t10.setUser(u5);
        t10.setMovieCinema(mc8);
        t11.setUser(u1);
        t11.setMovieCinema(mc15);
        t12.setUser(u2);
        t12.setMovieCinema(mc15);
        t13.setUser(u3);
        t13.setMovieCinema(mc15);
        t14.setUser(u4);
        t14.setMovieCinema(mc15);
        t15.setUser(u5);
        t15.setMovieCinema(mc15);
        t16.setUser(u1);
        t16.setMovieCinema(mc17);
        t17.setUser(u2);
        t17.setMovieCinema(mc17);
        t18.setUser(u3);
        t18.setMovieCinema(mc17);
        t19.setUser(u4);
        t19.setMovieCinema(mc17);
        t20.setUser(u5);
        t20.setMovieCinema(mc17);

        Set<Ticket> tickets = new HashSet<>();
        tickets.addAll(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20));
        ticketRepository.saveAll(tickets);
    }
}
