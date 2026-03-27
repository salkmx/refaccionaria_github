# Angular app (estructura base)

Esta carpeta contiene la estructura sugerida para consumir los microservicios a través del gateway.

## Archivos de configuración incluidos

- `package.json`: scripts y dependencias de Angular
- `angular.json`: configuración del workspace/proyecto
- `tsconfig.json`: reglas TypeScript globales
- `tsconfig.app.json`: configuración de compilación de app
- `tsconfig.spec.json`: configuración de pruebas
- `src/main.ts`, `src/index.html`, `src/styles.css`: punto de entrada y shell web

## Pantallas Swing mapeadas (1:1 por clase)

Se agregó una pantalla Angular por cada pantalla Swing principal, conservando estética azul, grupos y botones:

- `Login` -> `swing-screens/login/login-screen.component`
- `MenuPrincipal` -> `swing-screens/menu-principal/menu-principal-screen.component`
- `OperacionPanel` -> `swing-screens/operacion-panel/operacion-panel-screen.component`
- `ConfirmacionFrame` -> `swing-screens/confirmacion-frame/confirmacion-frame-screen.component`
- `AutoPartsSwingAboutBox` -> `swing-screens/about-box/about-box-screen.component`

El enrutamiento está en `src/app/app.routes.ts` y permite navegar por cada pantalla por URL.

## Estructura funcional

- `core/auth`: autenticación, interceptor y guard
- `features/catalog`: listado de productos
- `features/orders`: alta de pedidos
- `swing-mapped`: versión compacta de mapeo legacy
- `swing-screens`: mapeo por pantalla/clase Swing

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
