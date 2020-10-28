import { Component, OnInit } from '@angular/core';
import { FrmCita } from 'src/app/interfaces/frmcita';
import {FrmcitaService} from '../../services/frmcita.service';
import {Registro_Empleados} from '../../interfaces/registro-empleados';
import {Registro_Clientes} from '../../interfaces/registro-clientes';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-frm-cita',
  templateUrl: './frm-cita.component.html',
  styleUrls: ['./frm-cita.component.css']
})
export class FrmCitaComponent implements OnInit {
  frmcita: FrmCita = {
    fecha_cita: null,
    hora: null,
    nombre_mascota:null,
    especie:null,
    raza: null,
    edad:null,
    sexo:null,
    color:null,
    vacunacion:null,
    motivo:null,
    vacunas_realizadas:null,
    id_empleado:null,
    peso:null,
    pulso:null,
    temperatura:null,
    cliente_id:null
  };

  empleados: Registro_Empleados[]; //arreglo donde se guardaran los datos de los empleados
  clientes: Registro_Clientes[]; // arreglo donde se guradaran los datos de los clientes

  constructor(private frcitaservice: FrmcitaService, public toastr: ToastrService) { 
    this.comboempleados();
    this.comboclientes();
  }

  ngOnInit(): void {
  }
   //Metodo que se encarga de mandar el objeto frmcita al service 
   saveFrmcita(){
    this.frcitaservice.save(this.frmcita).subscribe(data =>{
      this.toastr.success("Cita guardada")
      //console.log(data);
    }, error => {
      console.log(error);
      this.toastr.error("Error al guardar");
    });
  }

  //metodo que obtiene los datos para llenar el comboBox
  comboempleados(){
    this.frcitaservice.getEmpleados().subscribe((data: Registro_Empleados[]) =>{
      this.empleados = data;
    }, error =>{
      this.toastr.error("Error combo empleados!");      
    });
  }

  //metodo que obtiene los datos para llenar el combo
  comboclientes(){
    this.frcitaservice.getClientes().subscribe((data: Registro_Clientes[]) =>{
      this.clientes = data;
    }, error =>{
      this.toastr.error("Error combo clientes!");      
    });
  }
}
