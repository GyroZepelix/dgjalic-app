package com.gjalic.springdgjalic.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Iterable<Customer> findAll() {
        return repository.findAll();
    }

    public Customer findById(long id) {
        return repository.findById(id);
    }

    public List<Customer> findByActive(Boolean active) {
        return repository.findByActive(active);
    }

    public List<Customer> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    public Customer replaceCustomerByID(Customer _newCustomer, Long id) {

        return repository.findById(id)
                .map(customer -> {
                    customer.setFirstName(_newCustomer.getFirstName());
                    customer.setLastName(_newCustomer.getLastName());
                    customer.setActive(_newCustomer.getActive());
                    return repository.save(customer);
                }).orElseGet(() -> {
                    _newCustomer.setId(id);
                    return repository.save(_newCustomer);
                });
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    //--------------------<  File Handling  >------------------------------

//    public File saveFile(MultipartFile file, long id) {
//        String documentName = file.getOriginalFilename();
//        try {
//            findById(id).getCustomerFiles().add((new File( documentName, file.getContentType(), file.getBytes())));
//        }
//
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return findById(id).getCustomerFiles().get();
//    }
//    public List<File> getFilesFromCustomer(long customerId) {
//        return findById(customerId).getCustomerFiles();
//    }
//    public File getFile(long customerId, long id) throws FileNotFoundException {
//        List<File> files = findById(customerId).getCustomerFiles();
//        for (File file : files) {
//            if (file.getID() == id) {
//                return file;
//            }
//        }
//        throw new FileNotFoundException(customerId, id);
//    }
//
//    public List<File> getFiles() {
//        Iterable<Customer> customers = findAll();
//
//        ArrayList<File> files = new ArrayList<File>();
//        customers.forEach(customer -> files.addAll(customer.getCustomerFiles()));
//        return files;
//    }


}
