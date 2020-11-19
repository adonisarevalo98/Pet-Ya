import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { AuthService } from "../../../services/auth.service";
@Component({
  selector: 'app-empleado-diagnosticos',
  templateUrl: './empleado-diagnosticos.component.html',
  styleUrls: ['./empleado-diagnosticos.component.css']
})
export class EmpleadoDiagnosticosComponent implements OnInit {

  constructor( public httpClient: HttpClient, public authService: AuthService) { }

  ngOnInit(): void {
  }

}
