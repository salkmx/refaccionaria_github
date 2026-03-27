export interface SwingTab {
  key: string;
  title: string;
  fields: string[];
  actions: string[];
}

export const SWING_LOGIN_UI = {
  title: 'Acceso al sistema',
  usernameLabel: 'Nombre de usuario',
  passwordLabel: 'Contraseña',
  primaryAction: 'Entrar',
  secondaryAction: 'Cancelar'
};

export const SWING_OPERATION_TABS: SwingTab[] = [
  {
    key: 'cliente',
    title: 'Cliente',
    fields: ['Nombre', 'Dirección', 'CP', 'Ciudad', 'Teléfono', 'Celular', 'Email', 'Fecha', 'RFC'],
    actions: ['Aceptar', 'Cancelar']
  },
  {
    key: 'proveedor',
    title: 'Proveedor',
    fields: ['Empresa', 'RFC', 'Dirección', 'CP', 'Ciudad', 'Teléfono', 'Celular', 'Email', 'Fecha'],
    actions: ['Aceptar', 'Cancelar']
  },
  {
    key: 'pedidos',
    title: 'Pedidos',
    fields: ['Seleccionar cliente', 'Código de producto', 'Marcas'],
    actions: ['Buscar', 'Mostrar lista']
  },
  {
    key: 'actualizar-catalogo',
    title: 'Actualizar Catálogo',
    fields: ['Seleccionar proveedor', 'Seleccionar catálogo'],
    actions: ['Examinar', 'Actualizar']
  },
  {
    key: 'reporte',
    title: 'Reporte',
    fields: ['Fecha inicial', 'Fecha final'],
    actions: ['Reportes de ventas por casa', 'Reporte de ventas por cliente', 'Reportes de ventas/utilidad', 'Generar reporte']
  }
];

export const SWING_CONFIRMATION_SUMMARY = {
  title: 'Confirmación de Pedido',
  labels: ['Sub Total $', 'Utilidad $', 'Total $', 'Cliente:'],
  action: 'Confirmar Pedido'
};
