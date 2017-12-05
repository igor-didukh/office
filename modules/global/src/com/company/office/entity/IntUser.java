package com.company.office.entity;

import javax.persistence.Entity;
import javax.persistence.Column;
import com.haulmont.cuba.security.entity.User;
import javax.persistence.Table;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.haulmont.cuba.core.entity.StandardEntity;

@Table(name = "OFFICE_INT_USER")
@Entity(name = "office$IntUser")
public class IntUser extends StandardEntity {
    private static final long serialVersionUID = -8692350638050790495L;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    protected User user;

    @Column(name = "POSITION_")
    protected Integer position;

    @Column(name = "REQUEST_COUNT")
    protected Integer requestCount;

    @Column(name = "REQUEST_THRESHOLD")
    protected Integer requestThreshold;

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


    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestThreshold(Integer requestThreshold) {
        this.requestThreshold = requestThreshold;
    }

    public Integer getRequestThreshold() {
        return requestThreshold;
    }



}