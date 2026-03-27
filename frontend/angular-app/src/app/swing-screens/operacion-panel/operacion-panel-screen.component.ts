import { Component } from '@angular/core';
import { NgFor } from '@angular/common';

interface PanelTab {
  name: string;
  groups: { title: string; fields: string[] }[];
  actions: string[];
}

@Component({
  selector: 'app-operacion-panel-screen',
  standalone: true,
  imports: [NgFor],
  templateUrl: './operacion-panel-screen.component.html',
  styleUrls: ['../swing-theme.css', './operacion-panel-screen.component.css']
})
export class OperacionPanelScreenComponent {
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

  setSelected(tab: PanelTab): void {
    this.selected = tab;
  }
}
