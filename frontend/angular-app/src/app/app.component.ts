import { Component } from '@angular/core';
import { SwingShellComponent } from './swing-mapped/swing-shell.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [SwingShellComponent],
  template: '<app-swing-shell />'
})
export class AppComponent {
}
