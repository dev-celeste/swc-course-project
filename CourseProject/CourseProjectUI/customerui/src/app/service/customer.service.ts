import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  url: string = 'http://localhost:8080/api/v1/customers';
  constructor(private http:HttpClient) { }

  getCustomers():Observable<customer[]> {
    return this.http.get<customer[]>(this.url);
  }

  createCustomer(customer: customer):Observable<customer> {
    return this.http.post<customer>(this.url, customer);
  }

  getCustomer(id: number):Observable<customer> {
    return this.http.get<customer>(this.url + '/' + id);
  }

  getCustomerByPhoneNumber(phoneNumber: string):Observable<customer> {
    return this.http.get<customer>(this.url + '/customernumber/' + phoneNumber);
  }

  getCustomerByLastName(lastName: string):Observable<customer> {
    return this.http.get<customer>(this.url + '/customername/' + lastName)
  }

  updateCustomer(customer: customer):Observable<customer> {
    return this.http.put<customer>(this.url + '/updatecustomer', customer);
  }

  deleteCustomer(id: number):Observable<customer> {
    return this.http.delete<customer>(this.url + '/deletecustomer/' + id)
  }
}
