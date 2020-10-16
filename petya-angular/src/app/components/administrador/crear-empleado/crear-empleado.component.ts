import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

//  Service 
import { EmpleadoService } from '../../../services/empleado.service';
import {Router } from '@angular/router'
// toastr
import { ToastrService } from 'ngx-toastr';
import { Registro_Empleados } from 'src/app/interfaces/registro-empleados';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-crear-empleado',
  templateUrl: './crear-empleado.component.html',
  styleUrls: ['./crear-empleado.component.css']
})
export class CrearEmpleadoComponent implements OnInit {
empleado: Registro_Empleados={
  nombres: null,
  apellidos: null,
  correo: null,
  foto_perfil: null,
  passwd: null,
  telefono: null,
  categoria: null
};
  constructor(
    public toastr: ToastrService,
    private http: HttpClient,
    private empleadoService: EmpleadoService,
    public router: Router
  ) { }

  ngOnInit() {
  }

   insertEmpleado(){
this.empleadoService.insert(this.empleado).subscribe(
  data => {
   
    this.toastr.success('Completado!', 'Empleado registrado.');
   
  }, error =>{
    this.toastr.error('UPS!', 'Ocurrio un Error.');
  });
   }
}
