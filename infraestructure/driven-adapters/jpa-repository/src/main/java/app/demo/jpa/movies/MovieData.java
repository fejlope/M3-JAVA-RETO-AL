package app.demo.jpa.movies;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "TBL_MOVIES")
@NoArgsConstructor
public class MovieData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE", length = 500, nullable = false)
    private String title;

    @Column(name = "CATEGORY", length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private Categories category;


}

enum Categories {
    ACTION,
    ADVENTURE,
    COMEDY,
    DRAMA
}