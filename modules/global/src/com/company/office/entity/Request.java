package com.company.office.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.security.entity.User;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;
import java.util.List;
import javax.persistence.OneToMany;

@NamePattern("%s|extUser")
@Table(name = "OFFICE_REQUEST")
@Entity(name = "office$Request")
public class Request extends StandardEntity {
    private static final long serialVersionUID = 1078634413564627380L;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EXT_USER_ID", unique = true)
    protected ExtUser extUser;

    @Column(name = "POSITION_", nullable = false)
    protected Integer position;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    protected User user;

    @Column(name = "COUNTER")
    protected Integer counter;

    @Temporal(TemporalType.DATE)
    @Column(name = "CREATED")
    protected Date created;

    @Temporal(TemporalType.DATE)
    @Column(name = "CLOSED")
    protected Date closed;

    @Column(name = "DESCRIPTION", length = 100)
    protected String description;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "request")
    protected List<RequestAct> acts;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "request")
    protected List<RequestStatus> states;

    public void setActs(List<RequestAct> acts) {
        this.acts = acts;
    }

    public List<RequestAct> getActs() {
        return acts;
    }


    public void setStates(List<RequestStatus> states) {
        this.states = states;
    }

    public List<RequestStatus> getStates() {
        return states;
    }


    public void setExtUser(ExtUser extUser) {
        this.extUser = extUser;
    }

    public ExtUser getExtUser() {
        return extUser;
    }

    public void setPosition(Position position) {
        this.position = position == null ? null : position.getId();
    }

    public Position getPosition() {
        return position == null ? null : Position.fromId(position);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCreated() {
        return created;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public Date getClosed() {
        return closed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}