# Angular app (estructura base)

Esta carpeta contiene la estructura sugerida para consumir los microservicios a través del gateway.

## Estructura

- `core/auth`: autenticación, interceptor y guard
- `features/catalog`: listado de productos
- `features/orders`: alta de pedidos

## API base

Configurar en `src/environments/environment.ts`:

```ts
export const environment = {
  production: false,
  apiBaseUrl: 'http://localhost:8080'
};
```
