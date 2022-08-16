package com.gjalic.springdgjalic.file;

import com.gjalic.springdgjalic.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {

    @Autowired
    FileService service;

    @Autowired
    private final CustomerService cService;

    FileController(FileService service, CustomerService cService) {
        this.service = service;
        this.cService = cService;
    }

    @GetMapping("/customers/files")
    public Iterable<File> getFiles(Model model) {
        return service.findAll();
    }

    @GetMapping("/customers/{id}/files")
    public Iterable<File> getFilesFromOne(@PathVariable Long id) {
        return service.findByCustomer(cService.findById(id));
    }

    @PostMapping(value = "/customers/{id}/files",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public Iterable<File> uploadFile(@RequestParam MultipartFile file, @PathVariable Long id) {
        try {
            service.save(new File(file.getOriginalFilename(), file.getContentType(), file.getBytes(), cService.findById(id)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return service.findByCustomer(cService.findById(id));

    }

    @GetMapping("/customers/files/{id}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable("id") Long id) {
        File file = service.findById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment:filename=\"" + file.getDocName() + "\"")
                .body(new ByteArrayResource(file.getData()));
    }

    @DeleteMapping("/customers/files/{id}")
    public void deleteFile(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

}
