import { Component } from '@angular/core';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-confirmacion-frame-screen',
  standalone: true,
  imports: [NgFor],
  templateUrl: './confirmacion-frame-screen.component.html',
  styleUrls: ['../swing-theme.css', './confirmacion-frame-screen.component.css']
})
export class ConfirmacionFrameScreenComponent {
  readonly resumen = ['Sub Total $', 'Utilidad $', 'Total  $', 'Cliente:'];
}
