import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-menu-principal-screen',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './menu-principal-screen.component.html',
  styleUrls: ['../swing-theme.css', './menu-principal-screen.component.css']
})
export class MenuPrincipalScreenComponent {
}
