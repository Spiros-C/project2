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
public class PaymentPK implements Serializable {

    @NonNull
    @Basic(optional = false)
    @Column(name = "userId")
    private int userId;
    
    @NonNull
    @Basic(optional = false)
    @Column(name = "paymentId", length = 50)
    private String paymentId;

//    public PaymentPK() {
//    }
//
//    public PaymentPK(int userId, String paymentId) {
//        this.userId = userId;
//        this.paymentId = paymentId;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    public String getPaymentId() {
//        return paymentId;
//    }
//
//    public void setPaymentId(String paymentId) {
//        this.paymentId = paymentId;
//    }
//

}
