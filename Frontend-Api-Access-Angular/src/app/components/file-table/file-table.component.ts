import { Component, OnInit, ViewChild } from '@angular/core';
import { Customer } from 'src/app/Customer';
import { RESTserviceService } from 'src/app/services/restservice.service';
import { TheFile } from 'src/app/File';
import { InputComponent } from '../input/input.component';

@Component({
  selector: 'app-file-table',
  templateUrl: './file-table.component.html',
  styleUrls: ['./file-table.component.css']
})
export class FileTableComponent implements OnInit {
  @ViewChild("uploadField") uploadField: InputComponent;

  public fileOwner: Customer = new Customer;
  theFiles: TheFile[] = [];

  fileDL(id: number) {
    window.open(`${this.rest.getURL()}customers/files/${id}`, '_blank');
  }

  fileADD() {
    let formData = new FormData();
    formData.set('file', this.uploadField.getValue())
    this.rest.uploadFile(formData, this.fileOwner.id).subscribe();
    window.location.reload();
  }

  fileDEL(id: number) {
    this.rest.deleteFile(id).subscribe();
    window.location.reload();
  }

  setCustomer(customer: Customer) {
    this.fileOwner = customer;
    this.rest.getFilesFromCustomer(customer.id).subscribe(files => this.theFiles = files);
  }

  constructor(private rest: RESTserviceService) { }

  ngOnInit(): void {
  }

}
