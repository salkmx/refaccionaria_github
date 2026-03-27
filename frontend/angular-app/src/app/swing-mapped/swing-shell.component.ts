import { Component } from '@angular/core';
import { SwingLoginComponent } from './login/swing-login.component';
import { SwingOperacionComponent } from './operacion/swing-operacion.component';
import { SwingConfirmacionComponent } from './confirmacion/swing-confirmacion.component';

@Component({
  selector: 'app-swing-shell',
  standalone: true,
  imports: [SwingLoginComponent, SwingOperacionComponent, SwingConfirmacionComponent],
  templateUrl: './swing-shell.component.html',
  styleUrl: './swing-shell.component.css'
})
export class SwingShellComponent {
}
