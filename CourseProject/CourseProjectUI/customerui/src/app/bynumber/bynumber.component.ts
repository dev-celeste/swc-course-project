import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { customer } from '../model/customer';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-bynumber',
  templateUrl: './bynumber.component.html',
  styleUrl: './bynumber.component.css'
})
export class BynumberComponent implements OnInit{
  //id: number = 0;
  phoneNumber: string = '';
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
        this.phoneNumber = params['phoneNumber'];
      }
    )
    this.customerservice.getCustomerByPhoneNumber(this.phoneNumber).subscribe(
      res => {
        this.customer = res;
      }
    )
  }
}
