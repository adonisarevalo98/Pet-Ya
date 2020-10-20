import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { IndexComponent } from './index/index.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { VerifyEmailComponent } from './components/verify-email/verify-email.component';
import { AuthGuard } from "./guard/auth.guard";
import { EmpleadoComponent } from './components/empleado/empleado.component';
import { AdministradorComponent } from './components/administrador/administrador.component';
import { AgregarClienteComponent } from './components/clientes/agregar-cliente/agregar-cliente.component';
import { ClienteListComponent } from './components/clientes/cliente-list/cliente-list.component';
import { EditarClienteComponent } from './components/clientes/editar-cliente/editar-cliente.component';
import { CrearEmpleadoComponent } from './components/administrador/crear-empleado/crear-empleado.component'
import { ControlHorariosComponent } from './components/administrador/control-horarios/control-horarios.component'
import {CrearHorariosComponent} from './components/administrador/control-horarios/crear-horarios/crear-horarios.component'
import {DashboardClienteComponent} from './components/dashboard-cliente/dashboard-cliente.component';

const routes: Routes = [
  { path: '', redirectTo: '/index', pathMatch: 'full' },
  { path: 'index', component: IndexComponent },
  { path: 'sign-in', component: SignInComponent },
  { path: 'register-user', component: SignUpComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  { path: 'forgot-password', component: ForgotPasswordComponent },
  { path: 'verify-email-address', component: VerifyEmailComponent },
  { path: 'empleado', component: EmpleadoComponent },
  { path: 'administrador', component: AdministradorComponent },
  { path: 'administrador/:id', component: CrearEmpleadoComponent },
  { path: 'control-horarios', component: ControlHorariosComponent },
  { path: 'control-horarios/:id', component: CrearHorariosComponent },
  { path: 'agregar-cliente', component: AgregarClienteComponent },
  { path: 'editar-cliente', component: EditarClienteComponent },
  {path:'editar-cliente/:id',component:EditarClienteComponent,canActivate:[AuthGuard]},
  { path: 'dashboard-cliente', component: DashboardClienteComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
