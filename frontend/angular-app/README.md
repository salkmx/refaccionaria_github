# Angular app (estructura base)

Esta carpeta contiene la estructura sugerida para consumir los microservicios a través del gateway.

## Archivos de configuración incluidos

- `package.json`: scripts y dependencias de Angular
- `angular.json`: configuración del workspace/proyecto
- `tsconfig.json`: reglas TypeScript globales
- `tsconfig.app.json`: configuración de compilación de app
- `tsconfig.spec.json`: configuración de pruebas
- `src/main.ts`, `src/index.html`, `src/styles.css`: punto de entrada y shell web

## Estructura funcional

- `core/auth`: autenticación, interceptor y guard
- `features/catalog`: listado de productos
- `features/orders`: alta de pedidos
- `swing-mapped`: mapeo visual de pantallas Swing legacy (Login, Operación, Confirmación)

## Mapeo Swing -> Angular

El mapeo replica etiquetas y acciones del cliente Swing original usando componentes standalone:

- `swing-shell.component`: contenedor general
- `login/swing-login.component`: pantalla de acceso
- `operacion/swing-operacion.component`: pestañas Cliente/Proveedor/Pedidos/Actualizar Catálogo/Reporte
- `confirmacion/swing-confirmacion.component`: resumen de pedido
- `swing-map.ts`: catálogo de labels y acciones traducidas desde `.properties`

## Ejecución

```bash
cd frontend/angular-app
npm install
npm run start
```

## API base

Configurar en `src/environments/environment.ts`:

```ts
export const environment = {
  production: false,
  apiBaseUrl: 'http://localhost:8080'
};
```
