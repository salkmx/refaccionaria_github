import { Routes } from '@angular/router';
import { MenuPrincipalScreenComponent } from './swing-screens/menu-principal/menu-principal-screen.component';
import { LoginScreenComponent } from './swing-screens/login/login-screen.component';
import { OperacionPanelScreenComponent } from './swing-screens/operacion-panel/operacion-panel-screen.component';
import { ConfirmacionFrameScreenComponent } from './swing-screens/confirmacion-frame/confirmacion-frame-screen.component';
import { AboutBoxScreenComponent } from './swing-screens/about-box/about-box-screen.component';

export const appRoutes: Routes = [
  { path: '', component: MenuPrincipalScreenComponent },
  { path: 'menu-principal', component: MenuPrincipalScreenComponent },
  { path: 'login', component: LoginScreenComponent },
  { path: 'operacion', component: OperacionPanelScreenComponent },
  { path: 'confirmacion', component: ConfirmacionFrameScreenComponent },
  { path: 'about', component: AboutBoxScreenComponent },
  { path: '**', redirectTo: '' }
];
