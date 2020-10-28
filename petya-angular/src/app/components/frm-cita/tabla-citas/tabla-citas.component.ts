import { Component, OnInit } from '@angular/core';
import {FrmcitaService} from '../../../services/frmcita.service';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import {FrmCita} from '../../../interfaces/frmcita';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-tabla-citas',
  templateUrl: './tabla-citas.component.html',
  styleUrls: ['./tabla-citas.component.css']
})
export class TablaCitasComponent implements OnInit {
  citas: any;
  constructor(private frcitaservice: FrmcitaService, private httpClient: HttpClientModule, public toastr: ToastrService) { 
    //Arranca el metodo  de obtner los datos de citas
    this.frcitaservice.getTabla().subscribe(data =>{this.citas = data;}, error => {
      console.log(error);
      this.toastr.error("Error al mostrar tabla!");      
    }); 
  }

  ngOnInit(): void {
  }

}
