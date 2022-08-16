package com.gjalic.springdgjalic.file;

import com.gjalic.springdgjalic.customer.Customer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String docName;
    private String docType;

    private Integer docSize;
    @Lob
    private byte[] data;

    @ManyToOne
    private Customer customer;

    protected File() {}
    public File(String docName, String docType, byte[] data, Customer customer) {
        this.docName = docName;
        this.docType = docType;
        this.data = data;
        this.customer = customer;
        this.docSize = data.length;
    }
}
