import { Component } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { SWING_OPERATION_TABS, SwingTab } from '../swing-map';

@Component({
  selector: 'app-swing-operacion',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './swing-operacion.component.html',
  styleUrl: './swing-operacion.component.css'
})
export class SwingOperacionComponent {
  readonly tabs = SWING_OPERATION_TABS;
  selectedTab: SwingTab = this.tabs[0];

  selectTab(tab: SwingTab): void {
    this.selectedTab = tab;
  }
}
