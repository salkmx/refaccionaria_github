import { Injectable } from '@angular/core';
import { Product } from '../catalog/catalog.service';

export interface DraftOrderLine {
  productId: number;
  productName: string;
  sku: string;
  price: number;
  quantity: number;
}

@Injectable({ providedIn: 'root' })
export class OrderDraftService {
  private customerId = '';
  private lines: DraftOrderLine[] = [];

  setCustomerId(customerId: string): void {
    this.customerId = customerId.trim();
  }

  getCustomerId(): string {
    return this.customerId;
  }

  addOrUpdateLine(product: Product, quantity: number): void {
    const sanitizedQuantity = Math.max(1, Math.floor(quantity));
    const existing = this.lines.find((line) => line.productId === product.id);

    if (existing) {
      existing.quantity = sanitizedQuantity;
      return;
    }

    this.lines.push({
      productId: product.id,
      productName: product.name,
      sku: product.sku,
      price: product.price,
      quantity: sanitizedQuantity
    });
  }

  removeLine(productId: number): void {
    this.lines = this.lines.filter((line) => line.productId !== productId);
  }

  getLines(): DraftOrderLine[] {
    return [...this.lines];
  }

  getSubtotal(): number {
    return this.lines.reduce((acc, line) => acc + line.price * line.quantity, 0);
  }

  clear(): void {
    this.customerId = '';
    this.lines = [];
  }
}
