import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { AuthService } from "../../../services/auth.service";
@Component({
  selector: 'app-empleado-citas',
  templateUrl: './empleado-citas.component.html',
  styleUrls: ['./empleado-citas.component.css']
})
export class EmpleadoCitasComponent implements OnInit {

  constructor( public httpClient: HttpClient, public authService: AuthService) { }

  ngOnInit(): void {
  }

}
