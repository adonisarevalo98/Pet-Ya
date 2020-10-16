import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Registro_Empleados} from '../interfaces/registro-empleados'
import { Router } from '@angular/router'
@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {
  API_ENDPOINT = 'http://localhost:8000/api';
  constructor(public router:Router ,private httpClient: HttpClient) {
   
   }
   insert(empleado: Registro_Empleados){
     const headers = new HttpHeaders({'Content-Type':'application/json'});
     
     return this.httpClient.post(this.API_ENDPOINT+'/petya-empleados', empleado, {headers:headers});
    }
}
