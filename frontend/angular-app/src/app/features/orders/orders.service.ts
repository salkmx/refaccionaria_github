import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

export interface OrderLine {
  productId: number;
  quantity: number;
}

export interface CreateOrderRequest {
  customerId: string;
  lines: OrderLine[];
}

@Injectable({ providedIn: 'root' })
export class OrdersService {
  constructor(private readonly http: HttpClient) {}

  createOrder(payload: CreateOrderRequest): Observable<unknown> {
    return this.http.post(`${environment.apiBaseUrl}/api/orders`, payload);
  }
}
