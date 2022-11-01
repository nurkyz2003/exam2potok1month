package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String creatAt;
    private String rating;

    @ManyToMany(cascade = {DETACH,MERGE,REFRESH,PERSIST},fetch = FetchType.EAGER)
    @JoinTable(name = "person_socialmedia",joinColumns = @JoinColumn(name = "person_id"),inverseJoinColumns = @JoinColumn(name = "socialMedia_id"))
    private List<Person> person = new ArrayList<>();

    public SocialMedia(String name, String creatAt, String rating) {
        this.name = name;
        this.creatAt = creatAt;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "SocialMedia{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creatAt='" + creatAt + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}