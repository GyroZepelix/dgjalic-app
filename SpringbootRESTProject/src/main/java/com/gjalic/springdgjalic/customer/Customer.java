package com.gjalic.springdgjalic.customer;

import com.gjalic.springdgjalic.file.File;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@EqualsAndHashCode
@Table(name="Kupac")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Ime")
    private String firstName;
    @Column(name="Prezime")
    private String lastName;

    @Column(name="Aktivan")
    private Boolean active;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<File> customerFiles = new ArrayList<File>();
    protected Customer() {}

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = true;
    }
    public Customer(String firstName, String lastName, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.active = active;
    }


}
