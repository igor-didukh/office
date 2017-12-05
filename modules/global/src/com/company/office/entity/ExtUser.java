package com.company.office.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.cuba.security.entity.User;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

@NamePattern("%s|user")
@Table(name = "OFFICE_EXT_USER")
@Entity(name = "office$ExtUser")
public class ExtUser extends StandardEntity {
    private static final long serialVersionUID = 4488226150514187212L;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", unique = true)
    protected User user;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "extUser")
    protected Request request;

    @Column(name = "EMAIL", length = 100)
    protected String email;

    @Column(name = "PHONE")
    protected String phone;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE1_ID")
    protected FileDescriptor file1;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE2_ID")
    protected FileDescriptor file2;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE3_ID")
    protected FileDescriptor file3;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE4_ID")
    protected FileDescriptor file4;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILE5_ID")
    protected FileDescriptor file5;

    public void setFile1(FileDescriptor file1) {
        this.file1 = file1;
    }

    public FileDescriptor getFile1() {
        return file1;
    }

    public void setFile2(FileDescriptor file2) {
        this.file2 = file2;
    }

    public FileDescriptor getFile2() {
        return file2;
    }

    public void setFile3(FileDescriptor file3) {
        this.file3 = file3;
    }

    public FileDescriptor getFile3() {
        return file3;
    }

    public void setFile4(FileDescriptor file4) {
        this.file4 = file4;
    }

    public FileDescriptor getFile4() {
        return file4;
    }

    public void setFile5(FileDescriptor file5) {
        this.file5 = file5;
    }

    public FileDescriptor getFile5() {
        return file5;
    }


    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


}