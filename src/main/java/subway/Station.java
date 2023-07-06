package subway;

import javax.persistence.*;

@Entity // (1)
@Table(name = "station") // (2)
public class Station {
    @Id // (3)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (4)
    private Long id;

    @Column(name = "name", nullable = false) // (5)
    private String name;

    protected Station(String name) {
        this.name = name;
    }

    public Station(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Station() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

