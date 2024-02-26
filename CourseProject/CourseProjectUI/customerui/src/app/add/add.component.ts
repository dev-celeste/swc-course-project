import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrl: './add.component.css'
})
export class AddComponent implements OnInit{
  constructor(private customerservice:CustomerService, private router:Router) {}

  ngOnInit(): void {
    
  }

  createCustomer(firstName: string, lastName: string, address: string, city: string, state: string, zipcode: string, email: string, phoneNumber: string) {
    
    let customer:customer = {
      id: 0,
      firstName: firstName,
      lastName: lastName,
      address: address,
      city: city,
      state: state,
      zipcode: parseInt(zipcode),
      email: email,
      phoneNumber: phoneNumber
    }

    this.customerservice.createCustomer(customer).subscribe(
      res => {
        alert('Customer successfully created!');
        this.router.navigate(['/']);
      },
      error => {
        console.error('Error creating customer: ', error);
        alert('Failed to create customer. Please try again.');
      }
    )
  }
}
