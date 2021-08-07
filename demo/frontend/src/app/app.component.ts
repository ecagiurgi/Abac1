import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class AppComponent implements OnInit {

  items !: MenuItem[];

  activeItem!: MenuItem;

  ngOnInit() {
    this.items = [
      {label: 'Home', icon: 'pi pi-fw pi-home'},
      {label: 'My Planets', icon: 'pi pi-fw pi-map'},
      {label: 'Logout', icon: 'pi pi-fw pi-sign-out'}
    ];

    this.activeItem = this.items[0];
  }
}
