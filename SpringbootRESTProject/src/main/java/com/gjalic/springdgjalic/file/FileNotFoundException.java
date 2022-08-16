package com.gjalic.springdgjalic.file;

public class FileNotFoundException extends RuntimeException{
    FileNotFoundException(long customerId ,long id) {super("Could not find file " + id + " on Customer " + customerId);}
}
