package com.paymentSystem.paymentsystem.repo;

import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
// import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
// @EnableJpaAuditing
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {
    // @CreatedBy
    // protected T createdBy;

    @Temporal(TemporalType.TIMESTAMP)

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected Date createdDate;

    // @LastModifiedBy

    // protected T lastModifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    protected Date lastModifiedDate;

    // public T getCreatedBy(){
    // return createdBy;
    // }

    // public void setCreatedBy (T createdBy){
    // this.createdBy = createdBy;
    // }

    public Date getCreatedDate() {
        return createdDate;
    }

    // public void setCreatedDate(Date createdDate){
    // this.createdDate = createdDate;
    // }

    // public T getLastModifiedBy(){
    // return lastModifiedBy;
    // }

    // public void setLastModifiedBy(T lastModifiedBy){
    // this.lastModifiedBy = lastModifiedBy;
    // }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    // public void setLastModifiedDate(Date lastModifiedDate){
    // this.lastModifiedDate = lastModifiedDate;
    // }

}
