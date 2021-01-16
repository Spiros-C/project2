package org.project.morebananas.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NonNull;



@Data
//@Builder
@Entity
@Table(name = "product_info")
public class ProductInfo implements Serializable {

    @Id
    @Column(name = "productInfo", length = 50)
    private String productInfo;
    
    @Column(name = "textDescription", length = 400)
    private String textDescription;
    
    @Column(name = "imageURL", length = 400)
    private String imageURL;
    
    @OneToMany(mappedBy = "productInfo")
    private List<Products> productsList;

}
