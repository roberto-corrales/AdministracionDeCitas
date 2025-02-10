# Administración de citas

## Instalación y configuración
Al iniciar el programa, debemos ingresar con el usuario Admin y la contraseña Admin (sensible a mayusculas). Haciendo estoy nos permitira iniciar la sesión y ver el menu. 

Si los archivos citas.txt o usuarios.txt no existen, el sistema automaticamente creará uno al momento de inicializarse. 

## Uso del programa
El programa inicia solicitando que el usuario inicie sesión, y hace una validación para saber si es administrador o no. Si el usuario no es administrador, lo lleva directamente a agendar una cita, para lo cual muestra una lista con las especialidades de los doctores registrados en el sistema, para que el usuario pueda elegir la especialidad de su interés. Una vez que el usuario selecciona su opción, el sistema muestra un listado de los doctores de esa especialidad, y pide al usuario que seleccione un doctor, después pregunta una fecha y hora en la que el usuario desea crear la cita, y con esta información el sistema valida si ya existe una cita creada para ese doctor, fecha y hora. Si no existe ninguna cita, continua solicitando al usuario que ingrese el motivo de su consulta, y con esto crea la cita en el sistema. El sistema ofrece la alternativa la opción de crear una nueva cita o salir del sistema.


Si el usuario es administrador, el sistema despliega un menú con tres opciones. La primera es la de dar de alta a un usuario, ya sea paciente o doctor. La otra opción es la de cambiar los privilegios de algún usuario (hacer o remover administrador). La última opción es la de salir del programa. 


## Créditos
Desarrollado por Roberto Corrales

##  Licencia
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.