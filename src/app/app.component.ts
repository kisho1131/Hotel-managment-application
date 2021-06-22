import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
     <app-login></app-login>
  `,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Hotel-App';
}
