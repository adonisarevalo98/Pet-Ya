<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

//Declarando controladores
use App\Http\Controllers\ClienteController;
use App\Http\Controllers\FormularioCitaController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:api')->get('/user', function (Request $request) {
    return $request->user();
});

//***********ruta para acceder al backend

//ruta a metodos del controller cliente
Route::resource('vetya-clientes', ClienteController::class);
//ruta a metodos del controller cliente
Route::resource('vetya-formcita', FormularioCitaController::class);