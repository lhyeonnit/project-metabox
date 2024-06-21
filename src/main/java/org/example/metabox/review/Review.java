package org.example.metabox.review;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.metabox.movie.Movie;
import org.example.metabox.user.User;

@Entity
@Data
@NoArgsConstructor
@Table(name = "review_tb")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    private String comment;
    // TODO : Enum 처리?
    private double rating;

    @Builder
    public Review(int id, User user, Movie movie, String comment, int rating) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.comment = comment;
        this.rating = rating;
    }
}
