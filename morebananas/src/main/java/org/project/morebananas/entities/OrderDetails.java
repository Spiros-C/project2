package org.project.morebananas.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;


//@Data
//@Builder
@Entity
@EqualsAndHashCode
@ToString
@Table(name = "order_details")
public class OrderDetails implements Serializable {

    @EmbeddedId
    protected OrderDetailsPK orderDetailsPK;
    
    @NonNull
    @Column(name = "quantityOrdered")
    private int quantityOrdered;
    
    @NonNull
    @Column(name = "priceEach", precision = 12, scale = 2)
    private BigDecimal priceEach;
    
    
    @Column(name = "orderLineNumber")
    private short orderLineNumber;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", insertable = false, updatable = false)
    private Orders orders;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "productId", referencedColumnName = "productId", insertable = false, updatable = false)
    private Products products;

    public OrderDetails() {
    }

    public OrderDetails(OrderDetailsPK orderDetailsPK) {
        this.orderDetailsPK = orderDetailsPK;
    }

    public OrderDetails(OrderDetailsPK orderDetailsPK, int quantityOrdered, BigDecimal priceEach, short orderLineNumber) {
        this.orderDetailsPK = orderDetailsPK;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetails(int orderId, int productId) {
        this.orderDetailsPK = new OrderDetailsPK(orderId, productId);
    }

    public OrderDetailsPK getOrderDetailsPK() {
        return orderDetailsPK;
    }

    public void setOrderDetailsPK(OrderDetailsPK orderDetailsPK) {
        this.orderDetailsPK = orderDetailsPK;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }

    public short getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(short orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

}
