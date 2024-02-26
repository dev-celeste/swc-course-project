import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-byname',
  templateUrl: './byname.component.html',
  styleUrl: './byname.component.css'
})
export class BynameComponent {
  //id: number = 0;
  lastName: string = '';
  customers:customer[] = [];
  customer: customer = {
    id: 0,
    firstName: '',
    lastName: '',
    address: '',
    city: '',
    state: '',
    zipcode: 0,
    email: '',
    phoneNumber: ''
  }
  constructor(private route:ActivatedRoute, private customerservice:CustomerService, private router:Router) {}

  ngOnInit(): void {
    this.route.params.subscribe(
      params => {
        this.lastName = params['lastName'];
      }
    )
    this.customerservice.getCustomerByLastName(this.lastName).subscribe(
      res => {
        this.customer = res;
      }
    )
  }





  // customers:customer[] = [];

  // constructor(private customerservice: CustomerService) {}

  // ngOnInit(): void {
  //   this.customerservice.getCustomerByLastName(this.lastName).subscribe(
  //     res => {
  //       this.customers = res;
  //     },
  //     error => {
  //       console.error('Error viewing customers: ', error);
  //       alert('Failed to import customers.');
  //     }
  //   )
  // }
}
