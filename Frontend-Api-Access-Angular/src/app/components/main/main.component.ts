import { Component, OnInit, ViewChild } from '@angular/core';
import { RESTserviceService } from 'src/app/services/restservice.service';
import { FileTableComponent } from '../file-table/file-table.component';
import { TableComponent } from '../table/table.component';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  @ViewChild('table') table: TableComponent;
  @ViewChild('fileTable') fileTable: FileTableComponent;


  displayFile: boolean = false;
  
  constructor(private rest: RESTserviceService) { }

  showFile(id: number) {
    if (this.displayFile == true && this.fileTable.fileOwner.id == id)
      this.displayFile = false;
    else this.displayFile = true;
    this.rest.getCustomerById(id).subscribe(customer => this.fileTable.setCustomer(customer));

  }

  

  ngOnInit(): void {
  }

}
