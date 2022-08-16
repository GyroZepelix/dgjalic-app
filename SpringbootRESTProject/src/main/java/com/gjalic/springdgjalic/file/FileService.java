package com.gjalic.springdgjalic.file;

import com.gjalic.springdgjalic.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class FileService {

    @Autowired
    private final FileRepository repository;


    public FileService(FileRepository repository) {
        this.repository = repository;
    }

    public Iterable<File> findAll() {
        return repository.findAll();
    }

    public Iterable<File> findByCustomer(Customer customer) {
        return repository.findByCustomer(customer);
    }

    public File save(File file) {return repository.save(file);}

    public void deleteById(long id) { repository.deleteById(id); }

    public File findById(long id) { return repository.findById(id); }

}

