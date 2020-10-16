import { Injectable, NgZone } from '@angular/core';
import { User } from "../models/user";
import { auth } from 'firebase/app';
import { AngularFireAuth } from "@angular/fire/auth";
import { AngularFirestore, AngularFirestoreDocument } from '@angular/fire/firestore';
import { Router } from "@angular/router";
import { HttpClientModule, HttpClient, HttpHeaders } from '@angular/common/http';
import { Registro_Clientes } from '../interfaces/registro-clientes';
import { element } from 'protractor';
import { EmailValidator } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})


export class AuthService {
  userData; // Guardar datos de usuario registrados
  API_ENDPOINT = 'http://localhost:8000/api';
  lista_clientes;
  contador=0;
  
  constructor(
    public afs: AngularFirestore,   //  Inyectar Servicio Firestore
    public afAuth: AngularFireAuth, // Inyectar el servicio de autenticación de Firebase
    public router: Router,  
    public ngZone: NgZone, // Servicio NgZone para eliminar la advertencia de alcance externo
    private httpClient: HttpClient
    
    ) {    

    /* Guardar datos de usuario en almacenamiento local cuando
    iniciado sesión y configurando nulo al cerrar sesión*/
    this.afAuth.authState.subscribe(user => {
      if (user) {
        this.userData = user;
        localStorage.setItem('user', JSON.stringify(this.userData));
        JSON.parse(localStorage.getItem('user'));
      } else {
        localStorage.setItem('user', null);
        JSON.parse(localStorage.getItem('user'));
      }
    })
  }

  // Iniciar sesión con correo electrónico / contraseña
  SignIn(email, password) {
  let conta=0;
  let categoria='';
    this.httpClient.get( this.API_ENDPOINT+'/petya-empleados').subscribe( 
      (data: [any]) =>{ 
    data.forEach(element =>{
      if(element.correo == email){
        conta =1;
        categoria = element.categoria;
      }else{
        categoria = 'A';
      }
      
    });
    console.log(conta);
    console.log(categoria);
    if(categoria=='E'){
      this.afAuth.signInWithEmailAndPassword(email, password).then((result) => {
        this.ngZone.run(() => {
          this.router.navigate(['empleado']);
        });
        this.SetUserData(result.user);
      }).catch((error) => {
       // window.alert("Por favor revisar credenciales")
         window.alert(error.message)
      })
    }else if(categoria=='A'){
      this.afAuth.signInWithEmailAndPassword(email, password).then((result) => {
        this.ngZone.run(() => {
          this.router.navigate(['index']);
        });
        this.SetUserData(result.user);
      }).catch((error) => {
       // window.alert("Por favor revisar credenciales")
         window.alert(error.message)
      })
    }   
  
  
  });
     
     
  }

  // Regístrese con correo electrónico / contraseña
  SignUp(email, password) {
    let reg_client: Registro_Clientes ={
    nombre: null,
    correo: email,
    foto_perfil: null,
    telefono: null,
    passwd:null,
    categoria: null

    };
    const headers = new HttpHeaders( {'Content-Type': 'application/json'});
 
     this.afAuth.createUserWithEmailAndPassword(email, password)
      .then((result) => {
        /* Llame a la función SendVerificaitonMail () cuando un nuevo usuario firme
        y vuelve la funcion*/
        this.SendVerificationMail();
        this.SetUserData(result.user);
    this.httpClient.post(this.API_ENDPOINT + '/petya-clientes',reg_client, {headers: headers}).subscribe( (data) =>{ 
      
      console.log(data);
      });; 
      
  
      }).catch((error) => {
        window.alert(error.message)
      })
  }

  // Enviar verificación por correo electrónico cuando se registre un nuevo usuario
  SendVerificationMail() {
    return this.afAuth.currentUser.then(u => u.sendEmailVerification())
    .then(() => {
    this.router.navigate(['verify-email-address']);
    })
    }

  // Restablecer contraseña olvidada
  ForgotPassword(passwordResetEmail) {
    return this.afAuth.sendPasswordResetEmail(passwordResetEmail)
    .then(() => {
      window.alert('Password reset email sent, check your inbox.');
    }).catch((error) => {
      window.alert(error)
    })
  }

  // Devuelve verdadero cuando el usuario está conectado y 
  // el correo electrónico está verificado
  get isLoggedIn(): boolean {
    const user = JSON.parse(localStorage.getItem('user'));
    return (user !== null && user.emailVerified !== false) ? true : true;
  }
  // Iniciar sesión usando Facebook Google
  GoogleAuth() {
    return this.AuthLogin(new auth.GoogleAuthProvider());
  }

  // Lógica de autenticación para ejecutar cualquier proveedor de autenticación  
  
  AuthLogin(provider) {
    return this.afAuth.signInWithPopup(provider)
    .then((result) => {
       this.ngZone.run(() => {
          this.router.navigate(['empleado']);
        })
      this.SetUserData(result.user);
    }).catch((error) => {
      window.alert(error)
    })
  }


  /* Configurar datos de usuario al iniciar sesión con nombre de usuario / contraseña,
  registrarse con nombre de usuario / contraseña e iniciar sesión con autenticación social
  proveedor en la base de datos de Firestore usando el servicio AngularFirestore + AngularFirestoreDocument*/
  SetUserData(user) {
    const userRef: AngularFirestoreDocument<any> = this.afs.doc(`users/${user.uid}`);
    const userData: User = {
      uid: user.uid,
      email: user.email,
      displayName: user.displayName,
      photoURL: user.photoURL,
      emailVerified: user.emailVerified
    }
    return userRef.set(userData, {
      merge: true
    })
  }

  // desconectar
  SignOut() {
    return this.afAuth.signOut().then(() => {
      localStorage.setItem('user', null);
      localStorage.removeItem('user');
      this.router.navigate(['sign-in']);
    })
  }

  //

}