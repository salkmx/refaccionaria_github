import { Component } from '@angular/core';
import { SWING_LOGIN_UI } from '../swing-map';

@Component({
  selector: 'app-swing-login',
  standalone: true,
  templateUrl: './swing-login.component.html',
  styleUrl: './swing-login.component.css'
})
export class SwingLoginComponent {
  readonly ui = SWING_LOGIN_UI;
}
