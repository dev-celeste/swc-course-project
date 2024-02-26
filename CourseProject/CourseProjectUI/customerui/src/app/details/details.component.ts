import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent implements OnInit{
  id: number = 0;
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
        this.id = params['id'];
      }
    )
    this.customerservice.getCustomer(this.id).subscribe(
      res => {
        this.customer = res;
      }
    )
  }

  

  updateCustomer(firstName: string, lastName: string, address: string, city: string, state: string, zipcode: string, email: string, phoneNumber: string) {
    this.customer.id = this.id;
    this.customer.firstName = firstName;
    this.customer.lastName = lastName;
    this.customer.address = address;
    this.customer.city = city;
    this.customer.state = state;
    this.customer.zipcode = parseInt(zipcode);
    this.customer.email = email;
    this.customer.phoneNumber = phoneNumber;

    this.customerservice.updateCustomer(this.customer).subscribe(
      res => {
        alert('updated ' + this.customer.id);
        this.router.navigate(['/']);
      },
      error => {
        console.error('Error updating customer: ', error);
        alert('Failed to update customer. Please try again.');
      }
    )
  }


  deleteCustomer() {
    this.customerservice.deleteCustomer(this.id).subscribe(
      res => {
        alert('deleted ' + this.customer.id);
        this.router.navigate(['/']);
      },
      error => {
        console.error('Error deleting customer: ', error);
        alert('Failed to delete customer. Please try again.');
      }
    )
  }
}
