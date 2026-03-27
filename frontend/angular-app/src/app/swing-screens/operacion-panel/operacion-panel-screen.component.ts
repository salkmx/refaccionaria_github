import { Component, OnInit } from '@angular/core';
import { CurrencyPipe, NgFor, NgIf } from '@angular/common';
import { Router } from '@angular/router';
import { CatalogService, Product } from '../../features/catalog/catalog.service';
import { OrderDraftService } from '../../features/orders/order-draft.service';

interface PanelTab {
  name: string;
  groups: { title: string; fields: string[] }[];
  actions: string[];
}

@Component({
  selector: 'app-operacion-panel-screen',
  standalone: true,
  imports: [NgFor, NgIf, CurrencyPipe],
  templateUrl: './operacion-panel-screen.component.html',
  styleUrls: ['../swing-theme.css', './operacion-panel-screen.component.css']
})
export class OperacionPanelScreenComponent implements OnInit {
  readonly tabs: PanelTab[] = [
    {
      name: 'Cliente',
      groups: [
        { title: 'Datos Cliente', fields: ['Nombre', 'Dirección', 'CP', 'Ciudad'] },
        { title: 'Datos Adicionales', fields: ['Teléfono', 'Celular', 'Email', 'Fecha', 'RFC'] }
      ],
      actions: ['Aceptar', 'Cancelar']
    },
    {
      name: 'Proveedor',
      groups: [
        { title: 'Datos Proveedor', fields: ['Empresa', 'Dirección', 'CP', 'Ciudad'] },
        { title: 'Datos Adicionales', fields: ['RFC', 'Teléfono', 'Celular', 'Email', 'Fecha'] }
      ],
      actions: ['Aceptar', 'Cancelar']
    },
    {
      name: 'Pedidos',
      groups: [
        { title: 'Búsqueda', fields: ['Seleccionar cliente', 'Código de producto', 'Marcas'] }
      ],
      actions: ['Buscar', 'Mostrar lista']
    },
    {
      name: 'Actualizar Catálogo',
      groups: [
        { title: 'Catálogo', fields: ['Seleccionar proveedor', 'Seleccionar catálogo'] }
      ],
      actions: ['Examinar', 'Actualizar']
    },
    {
      name: 'Reporte',
      groups: [
        { title: 'Reportes', fields: ['Fecha inicial', 'Fecha final'] }
      ],
      actions: ['Ventas por casa', 'Ventas por cliente', 'Ventas/utilidad', 'Generar reporte']
    }
  ];

  selected = this.tabs[0];
  customerId = '';
  products: Product[] = [];
  selectedProductId: number | null = null;
  quantity = 1;
  loadingProducts = false;
  productsError = '';

  constructor(
    private readonly catalogService: CatalogService,
    readonly orderDraftService: OrderDraftService,
    private readonly router: Router
  ) {}

  ngOnInit(): void {
    this.customerId = this.orderDraftService.getCustomerId();
    this.loadProducts();
  }

  setSelected(tab: PanelTab): void {
    this.selected = tab;
  }

  loadProducts(): void {
    this.productsError = '';
    this.loadingProducts = true;
    this.catalogService.getProducts().subscribe({
      next: (products) => {
        this.products = products;
        this.loadingProducts = false;
      },
      error: () => {
        this.loadingProducts = false;
        this.productsError = 'No se pudieron cargar los productos del catálogo.';
      }
    });
  }

  addLine(): void {
    if (!this.selectedProductId) {
      return;
    }

    const product = this.products.find((item) => item.id === this.selectedProductId);
    if (!product) {
      return;
    }

    this.orderDraftService.setCustomerId(this.customerId);
    this.orderDraftService.addOrUpdateLine(product, this.quantity);
    this.quantity = 1;
  }

  removeLine(productId: number): void {
    this.orderDraftService.removeLine(productId);
  }

  goToConfirmation(): void {
    this.orderDraftService.setCustomerId(this.customerId);
    void this.router.navigate(['/confirmacion']);
  }
}
