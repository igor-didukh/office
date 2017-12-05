package com.company.office.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Table(name = "OFFICE_ACT")
@Entity(name = "office$Act")
public class Act extends StandardEntity {
    private static final long serialVersionUID = 8530702335739023159L;

    @NotNull
    @Column(name = "TYPE_", nullable = false)
    protected String type;

    @NotNull
    @Column(name = "POSITION_", nullable = false)
    protected Integer position;

    @Column(name = "DESCRIPTION", length = 100)
    protected String description;

    @NotNull
    @Column(name = "WORK_DAYS", nullable = false)
    protected Integer workDays;


    @Column(name = "RESULT_REQUIRED")
    protected Boolean resultRequired;

    public void setResultRequired(Boolean resultRequired) {
        this.resultRequired = resultRequired;
    }

    public Boolean getResultRequired() {
        return resultRequired;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


    public void setPosition(Position position) {
        this.position = position == null ? null : position.getId();
    }

    public Position getPosition() {
        return position == null ? null : Position.fromId(position);
    }

    public void setType(ActType type) {
        this.type = type == null ? null : type.getId();
    }

    public ActType getType() {
        return type == null ? null : ActType.fromId(type);
    }

    public void setWorkDays(Integer workDays) {
        this.workDays = workDays;
    }

    public Integer getWorkDays() {
        return workDays;
    }


}