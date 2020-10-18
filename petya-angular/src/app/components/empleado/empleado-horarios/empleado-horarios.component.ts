import { Component, OnInit } from '@angular/core';
import { EmpleadoService } from '../../../services/empleado.service';
import { HttpClient } from '@angular/common/http';
import { Horario } from '../../../interfaces/horario'
import { AuthService } from "../../../services/auth.service";
import { element } from 'protractor';
import { Registro_Empleados} from '../../../interfaces/registro-empleados'
@Component({
  selector: 'app-empleado-horarios',
  templateUrl: './empleado-horarios.component.html',
  styleUrls: ['./empleado-horarios.component.css']
})
export class EmpleadoHorariosComponent implements OnInit {
  API_ENDPOINT = 'http://localhost:8000/api';
  horarios: Horario[];
  correo: AuthService[];
 horarios_user;
 lista_empleados=[];
  constructor(private empleadoService: EmpleadoService,
    public httpClient: HttpClient, public authService: AuthService) {

  }

  ngOnInit(): void {
    
    let id = 0;
    this.httpClient.get(this.API_ENDPOINT + '/petya-empleados').subscribe(
      (data: Registro_Empleados) => {
        this.lista_empleados.push(data) ; 
      
       
      })
     
  }



}
