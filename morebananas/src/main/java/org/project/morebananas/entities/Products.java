package org.project.morebananas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NonNull;


@Data
//@Builder
@Entity
@Table(name = "products")
public class Products implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    @NonNull
    @Column(name = "productId")
    private Integer productId;
    
    @Column(name = "name", length = 70)
    private String name;
    
    @Lob
    @Column(name = "description", length = 65535)
    private String description;
    
    @Column(name = "quantityInStock")
    private short quantityInStock;
    
    @Column(name = "buyPrice", precision = 12, scale = 2)
    private BigDecimal buyPrice;
    
    @OneToMany(mappedBy = "products")
    private List<OrderDetails> orderDetailsList;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "productInfo", referencedColumnName = "productInfo")
    private ProductInfo productInfo;


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