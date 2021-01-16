package org.project.morebananas.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;


@Data
//@Builder
@EqualsAndHashCode
@ToString
@Embeddable
public class OrderDetailsPK implements Serializable {
    
    @NonNull
    @Basic(optional = false)
    @Column(name = "orderId")
    private int orderId;

    @NonNull
    @Basic(optional = false)
    @Column(name = "productId")
    private int productId;

//    public OrderDetailsPK() {
//    }
//
//    public OrderDetailsPK(int orderId, int productId) {
//        this.orderId = orderId;
//        this.productId = productId;
//    }
//
//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }
//
//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }


}
