import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { OutletContext } from '@angular/router';
import { delay } from 'rxjs';
import { Customer } from 'src/app/Customer';
import { RESTserviceService } from 'src/app/services/restservice.service';
import { InputComponent } from '../input/input.component';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  @Output() fileAccessedEvent = new EventEmitter();

  @ViewChild('EFN') EFN: InputComponent;
  @ViewChild('ELN') ELN: InputComponent;
  @ViewChild('EA') EA: InputComponent;

  public customers: Customer[] = [];
  public tableMode: string;
  public editedCustomer: Customer = new Customer();
  public isEditVisible: boolean = false;

  constructor(private RESTService: RESTserviceService) { }
  
  showFile(id: number) {
    this.fileAccessedEvent.emit(id);
  }

  deleteCust(id: number) {
    console.log(id);
    this.RESTService.deleteCustomer(id).subscribe();
    this.ngOnInit();
    window.location.reload();
  }

  editCust(id: number) {
    this.tableMode = "EDIT";
    if (this.isEditVisible && this.editedCustomer.id == id) {
      this.isEditVisible = false;
    } else {
      this.isEditVisible = true;
    }
    this.RESTService.getCustomerById(id).subscribe(customer => this.editedCustomer = customer);

  }

  addCust() {
    if (this.isEditVisible && this.tableMode == "ADD" ) {
      this.isEditVisible = false;
    } else {
      this.isEditVisible = true;
    }
    this.tableMode = "ADD";

    this.editedCustomer = new Customer;
    this.editedCustomer.active = false;
  }

  acceptEdit(id: number) {
    this.editedCustomer.firstName = this.EFN.getValue();
    this.editedCustomer.lastName = this.ELN.getValue();
    this.editedCustomer.active = this.EA.getValue();

    if (this.tableMode == "EDIT") 
      this.RESTService.replaceCustomer(this.editedCustomer).subscribe();
    else 
      this.RESTService.addCustomer(this.editedCustomer).subscribe();
    window.location.reload();
  }

  ngOnInit(): void {
    this.RESTService.getCustomers().subscribe((customers) => (this.customers = customers));
    
  }

}
