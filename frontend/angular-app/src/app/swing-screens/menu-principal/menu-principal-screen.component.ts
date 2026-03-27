import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink, RouterLinkActive } from '@angular/router';
import { AuthService } from '../../core/auth/auth.service';

@Component({
  selector: 'app-menu-principal-screen',
  standalone: true,
  imports: [NgIf, RouterLink, RouterLinkActive],
  templateUrl: './menu-principal-screen.component.html',
  styleUrls: ['../swing-theme.css', './menu-principal-screen.component.css']
})
export class MenuPrincipalScreenComponent {
  username = '';

  constructor(
    readonly authService: AuthService,
    private readonly router: Router
  ) {
    if (this.authService.isAuthenticated()) {
      this.authService.me().subscribe({
        next: (me) => {
          this.username = me.username;
        },
        error: () => {
          this.username = 'usuario';
        }
      });
    }
  }

  logout(): void {
    this.authService.logout();
    void this.router.navigate(['/login']);
  }
}
