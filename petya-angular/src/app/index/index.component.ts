import { Component, OnInit } from '@angular/core';
import { AuthService } from "../services/auth.service";
import { Cliente } from "../interfaces/cliente";
import { ClienteService } from "../services/cliente.service";
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  allclient = null;
  constructor(public authService: AuthService, private clienteServices: ClienteService, private toastr: ToastrService
  ) {



  }

  ngOnInit(): void {
   // this.seleccionarTodo();
  }

  registro: Cliente = {
    nombre: null,
    correo: null,
    telefono: null,
    contra: null,
  }



  guardarcliente() {


    this.clienteServices.guardar(this.registro).subscribe((data) => {
      this.toastr.success("Registro exitosamente");

    }, (error) => {
      this.toastr.error("Ha ocurrido un error!");
      console.log(error);
    });

    this.authService.SignUp(this.registro.correo, this.registro.contra);


  }

  id = 0;
  /*seleccionarTodo() {
   // servicio para select * from clientes
    this.clienteServices.select().subscribe((data: Cliente[]) => {
      //asignando el registros al arreglo 'clientes'
      this.allclient = data;
      if (this.authService.userData.email != null) {
        for (let i = 0; i < this.allclient.length; i++) {
          if (this.authService.userData.email == this.allclient[i].correo) {
            console.log(this.allclient[i]);
            this.id = this.allclient[i].id;
            break;
          }
        }
        console.log(this.id);
      } else {
      }
    }, (error) => {
      this.toastr.error("Ha ocurrido un error!");
      console.log(error);
    });
  } */




}
