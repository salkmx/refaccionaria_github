import { Component } from '@angular/core';
import { NgFor } from '@angular/common';
import { SWING_CONFIRMATION_SUMMARY } from '../swing-map';

@Component({
  selector: 'app-swing-confirmacion',
  standalone: true,
  imports: [NgFor],
  templateUrl: './swing-confirmacion.component.html',
  styleUrl: './swing-confirmacion.component.css'
})
export class SwingConfirmacionComponent {
  readonly ui = SWING_CONFIRMATION_SUMMARY;
}
