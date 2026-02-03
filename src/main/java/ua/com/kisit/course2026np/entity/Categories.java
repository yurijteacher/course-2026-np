package ua.com.kisit.course2026np.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "categories")
public class Categories {

    @Id // PK, NN
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    private Long id;
    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "category")
    private List<Products> products =  new ArrayList<>();

}
