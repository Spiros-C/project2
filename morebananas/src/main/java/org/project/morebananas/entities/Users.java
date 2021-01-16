package org.project.morebananas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NonNull;


@Data
@Entity
@Table(name = "users")
public class Users implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @NonNull
    @Column(name = "userName", length = 50)
    private String userName;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "password", length = 255)
    private String password;
    
    // @Max(value=?)  @Min(value=?)//field validation
    @Column(name = "creditLimit", precision = 12, scale = 2)
    private BigDecimal creditLimit;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_user_profile",
            joinColumns = {
                @JoinColumn(name = "userId")},
            inverseJoinColumns = {
                @JoinColumn(name = "profileId")})
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();

    @OneToMany(mappedBy = "userId")
    private List<Orders> ordersList;
    
    @OneToMany(mappedBy = "users")
    private List<Payment> paymentList;
}


//var
//Mutably! Hassle-free local variables.
//
//@NonNull
//or: How I learned to stop worrying and love the NullPointerException.
//
//@Cleanup
//Automatic resource management: Call your close() methods safely with no hassle.
//
//@Getter/@Setter
//Never write public int getFoo() {return foo;} again.
//
//@ToString
//No need to start a debugger to see your fields: Just let lombok generate a toString for you!
//
//@EqualsAndHashCode
//Equality made easy: Generates hashCode and equals implementations from the fields of your object..
//
//@NoArgsConstructor, @RequiredArgsConstructor and @AllArgsConstructor
//Constructors made to order: Generates constructors that take no arguments, one argument per final / non-nullfield, or one argument for every field.
//
//@Data
//All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
//
//@Value
//Immutable classes made very easy.
//
//@Builder
//... and Bob's your uncle: No-hassle fancy-pants APIs for object creation!
//
//@SneakyThrows
//To boldly throw checked exceptions where no one has thrown them before!
//
//@Synchronized
//synchronized done right: Don't expose your locks.
//
//@With
//Immutable 'setters' - methods that create a clone but with one changed field.
//
//@Getter(lazy=true)
//Laziness is a virtue!
//
//@Log
//Captain's Log, stardate 24435.7: "What was that line again?"
//
//experimental
//Head to the lab: The new stuff we're working on.