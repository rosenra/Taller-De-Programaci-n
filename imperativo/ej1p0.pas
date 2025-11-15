{1.- Implementar un programa que procese la información de los alumnos de la Facultad de
Informática.
a) Implementar un módulo que lea y retorne, en una estructura adecuada, la información de
todos los alumnos. De cada alumno se lee su apellido, número de alumno, año de ingreso,
cantidad de materias aprobadas (a lo sumo 36) y nota obtenida (sin contar los aplazos) en cada
una de las materias aprobadas. La lectura finaliza cuando se ingresa el número de alumno
11111, el cual debe procesarse.
b) Implementar un módulo que reciba la estructura generada en el inciso a) y retorne número
de alumno y promedio de cada alumno.
c) Analizar: ¿qué cambios requieren los puntos a y b, si no se sabe de antemano la cantidad de
materias aprobadas de cada alumno, y si además se desean registrar los aplazos? ¿cómo
puede diseñarse una solución modularizada que requiera la menor cantidad de cambios?}

program ej1Intro;
const
materias=5;
type
RangoM=1..materias;
vectorM= array [RangoM] of integer;
alumno=record
apellido:string;
num:integer;
ingreso: integer;
nota: vectorM;
end;
lista=^nodo;
nodo= record
dato:alumno;
sig:lista;
end;

procedure leerM (var n: vectorM);
var
i:integer;
begin
for i:=1 to materias do
begin
writeln ('ingrese nota de la materia',i);
readln(n[i]);
end;
end;

procedure leerA (var a:alumno);
begin
writeln ('ingrese apellido del alumno');
readln(a.apellido);
writeln ('ingrese numero de alumno');
readln (a.num);
writeln ('ingrese año de ingreso');
readln (a.ingreso);
leerM (a.nota);
end;

procedure agregarAdelante (var l:lista; a: alumno);
var
aux: lista;
begin
new(aux);
aux^.dato:=a;
aux^.sig:=l;
l:=aux;
end;

procedure CargarLista (var l:lista);
var
a:alumno;
begin
l:=nil;
repeat
leerA(a);
agregarAdelante (l,a);
until (a.num=11111);
end;

function calcularProm (v:vectorM): real;
var
k, prom:integer;
begin
prom:= 0;
for k:=1 to materias do begin
prom:= prom + v[k];
end;
calcularProm:= prom/materias;
end;
procedure procesar (l:lista);
begin
while (l<> nil) do
begin
writeln ('el alumno', l^.dato.num, 'tiene un promedio de:', calcularProm(l^.dato.nota));
l:=l^.sig;
end;
end;
var
l:lista;
begin
CargarLista(l);
procesar (l);
end.

