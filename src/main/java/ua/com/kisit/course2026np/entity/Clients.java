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
@Table(name = "clients")
public class Clients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private int phone;

    // OneToOne
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Users user;


    @OneToMany(mappedBy = "client")
    private List<Orders> orders = new ArrayList<>();

    @OneToMany(mappedBy = "clients")
    private List<AddressClient> addresses;



}
