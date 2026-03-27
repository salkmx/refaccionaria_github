import { CurrencyPipe, DatePipe, NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { OrderDraftService } from '../../features/orders/order-draft.service';
import { OrdersService } from '../../features/orders/orders.service';

@Component({
  selector: 'app-confirmacion-frame-screen',
  standalone: true,
  imports: [NgFor, NgIf, CurrencyPipe, DatePipe],
  templateUrl: './confirmacion-frame-screen.component.html',
  styleUrls: ['../swing-theme.css', './confirmacion-frame-screen.component.css']
})
export class ConfirmacionFrameScreenComponent {
  loading = false;
  error = '';
  orderId = '';
  createdAt = '';

  constructor(
    readonly orderDraftService: OrderDraftService,
    private readonly ordersService: OrdersService,
    private readonly router: Router
  ) {}

  get subtotal(): number {
    return this.orderDraftService.getSubtotal();
  }

  get utilidad(): number {
    return this.subtotal * 0.2;
  }

  get total(): number {
    return this.subtotal + this.utilidad;
  }

  confirmOrder(): void {
    const lines = this.orderDraftService.getLines();
    const customerId = this.orderDraftService.getCustomerId();

    this.error = '';
    if (!customerId) {
      this.error = 'Debes indicar el cliente antes de confirmar.';
      return;
    }

    if (lines.length === 0) {
      this.error = 'Agrega por lo menos un producto al pedido.';
      return;
    }

    this.loading = true;
    this.ordersService.createOrder({
      customerId,
      lines: lines.map((line) => ({ productId: line.productId, quantity: line.quantity }))
    }).subscribe({
      next: (response) => {
        this.loading = false;
        this.orderId = response.orderId;
        this.createdAt = response.createdAt;
        this.orderDraftService.clear();
      },
      error: () => {
        this.loading = false;
        this.error = 'No fue posible confirmar el pedido.';
      }
    });
  }

  volverOperacion(): void {
    void this.router.navigate(['/operacion']);
  }
}
