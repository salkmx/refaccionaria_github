import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkActive],
  template: `
    <header class="topbar">
      <a routerLink="/menu-principal" routerLinkActive="active">Menú Principal</a>
      <a routerLink="/login" routerLinkActive="active">Login</a>
      <a routerLink="/operacion" routerLinkActive="active">Operación</a>
      <a routerLink="/confirmacion" routerLinkActive="active">Confirmación</a>
      <a routerLink="/about" routerLinkActive="active">Acerca de</a>
    </header>

    <main class="page">
      <router-outlet />
    </main>
  `,
  styles: [
    `
      .topbar {
        display: flex;
        flex-wrap: wrap;
        gap: 0.5rem;
        padding: 0.75rem;
        background: #0f2f55;
      }
      .topbar a {
        color: #fff;
        text-decoration: none;
        border: 1px solid rgba(255, 255, 255, 0.25);
        border-radius: 8px;
        padding: 0.35rem 0.65rem;
      }
      .topbar a.active {
        background: #1f5c9c;
      }
      .page {
        padding: 1rem;
      }
    `
  ]
})
export class AppComponent {
}
