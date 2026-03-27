import { Component } from '@angular/core';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../../core/auth/auth.service';

@Component({
  selector: 'app-login-screen',
  standalone: true,
  imports: [NgIf, FormsModule],
  templateUrl: './login-screen.component.html',
  styleUrls: ['../swing-theme.css', './login-screen.component.css']
})
export class LoginScreenComponent {
  username = '';
  password = '';
  loading = false;
  error = '';

  constructor(
    private readonly authService: AuthService,
    private readonly router: Router
  ) {}

  login(): void {
    this.error = '';

    if (!this.username.trim() || !this.password.trim()) {
      this.error = 'Usuario y contraseña son requeridos.';
      return;
    }

    this.loading = true;
    this.authService.login(this.username, this.password).subscribe({
      next: () => {
        this.loading = false;
        void this.router.navigate(['/menu-principal']);
      },
      error: () => {
        this.loading = false;
        this.error = 'No fue posible iniciar sesión. Verifica el gateway y auth-service.';
      }
    });
  }

  clear(): void {
    this.username = '';
    this.password = '';
    this.error = '';
  }
}
