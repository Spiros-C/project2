package org.project.morebananas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;


//@Data
//@Builder
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "payment")
public class Payment implements Serializable {

    @EmbeddedId
    protected PaymentPK paymentPK;

    @NonNull
    @Column(name = "paymentDate")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @NonNull
    @Column(name = "amount", precision = 12, scale = 2)
    private BigDecimal amount;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "userId", referencedColumnName = "userId", insertable = false, updatable = false)
    private Users users;

    public Payment() {
    }

    public Payment(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public Payment(PaymentPK paymentPK, Date paymentDate, BigDecimal amount) {
        this.paymentPK = paymentPK;
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public Payment(int userId, String paymentId) {
        this.paymentPK = new PaymentPK(userId, paymentId);
    }

    public PaymentPK getPaymentPK() {
        return paymentPK;
    }

    public void setPaymentPK(PaymentPK paymentPK) {
        this.paymentPK = paymentPK;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

}
