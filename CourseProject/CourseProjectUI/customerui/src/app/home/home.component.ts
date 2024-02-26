import { Component } from '@angular/core';
import { customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  customers:customer[] = [];
  customer: customer = new customer;

  constructor(private customerservice: CustomerService) {}

  ngOnInit(): void {
    this.customerservice.getCustomers().subscribe(
      res => {
        this.customers = res;
      },
      error => {
        console.error('Error viewing customers: ', error);
        alert('Failed to import customers.');
      }
    )
  }
}
