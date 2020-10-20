import { Component, OnInit } from '@angular/core';
//Service
import { AuthService } from "../../services/auth.service";

@Component({
  selector: 'app-dashboard-cliente',
  templateUrl: './dashboard-cliente.component.html',
  styleUrls: ['./dashboard-cliente.component.css']
})

export class DashboardClienteComponent implements OnInit {

  constructor(public authService: AuthService) { }

  ngOnInit(): void {
  }

}
