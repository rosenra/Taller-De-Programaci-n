{Una clinica necesita un sistema para el procesamiento de las atenciones realizadas a los pacientes.
a) implementar un modulo que lea informacion de las atenciones. De cada atencion se lee: DNI del paciente, numero de mes, y codigo de diagnostico (1 a 15).
 La lectura finaliza con el mes 0. Se sugiere utilizar el modulo leerAtencion (). El modulo debe retornar dos estructuras de datos. 
 i. Una estructura de datos eficiente para la busqueda por DNI del paciente. Para cadaDNI debe almacenarse la cantidad total de atenciones recibidas.
 ii. Otra estructura de datos con la cantidad de atenciones realizadas para cada diagnostico.
b) Implementar un modulo que reciba la estructura generada en a)i.; dos numeros de DNI y un valor entero x.
Este modulo debe retornar la cantidad de pacientes con mas de x atenciones cuyos DNI estan entre los 2 numeros de DNI recibidos.
c) Implementar un modulo RECURSIVO que reciba la estructura generada en a) ii. y retorne 
la cantidad de diagnosticos para los cuales la cantidad de atenciones fue cero.}
program parcial1;
type 
rangoDiagnostico=1..15;

atencion=record
 dni:integer;
 mes:integer;// si uso rango no corta nunca
 codigo:rangoDiagnostico;
end;

regArbolI = record
  dni:integer;
  cantidad:integer;
end;
arbolI=^nodo;
nodo=record
  dato:regArbolI;
  HI:arbolI;
  HD:arbolI;
end;

vectorA = array [rangoDiagnostico] of integer;

procedure inicializarVector (var v:vectorA);
var
i:rangoDiagnostico;
begin
for i:=1 to 15 do
 v[i]:= 0;
end;
procedure leerAtencion (var a:atencion);
begin
 a.dni:= random (100)+1;
 a.mes:= random (13);
 a.codigo:= random (15)+1;
end;

procedure agregarArbolI (var a:arbolI; dni:integer);
begin
 if (a = nil) then
  begin
   new (a);
   a^.dato.dni:= dni;
   a^.dato.cantidad:= 1;
   a^.HI:=nil;
   a^.HD:=nil;
  end
 else  begin
   if (a^.dato.dni =dni) then
    a^.dato.cantidad:= a^.dato.cantidad +1
   else if (a^.dato.dni > dni) then
    agregarArbolI (a^.HI,dni)
   else 
     agregarArbolI (a^.HD,dni);
   end;
 end;
 
 procedure cargar (var a:arbolI; var v:vectorA);
 var
 r:atencion;
 begin
 leerAtencion (r);
 while (r.mes <> 0) do 
  begin
   agregarArbolI (a,r.dni);
   v[r.codigo]:= v[r.codigo] +1;
   writeln ('dni:' , r.dni, 'mes: ', r.mes, ' cod ', r.codigo);
   
   leerAtencion (r);
  end;
 end;
 
 procedure imprimir (a:arbolI);
 begin
 if (a<> nil) then
 begin
  imprimir (a^.HI);
  writeln ('dni: ', a^.dato.dni, ' cant: ', a^.dato.cantidad);
  imprimir (a^.HD);
 end;
end;
procedure imprimirVector (v:vectorA);
var
i:rangoDiagnostico;
begin
  for i:=1 to 15 do 
   writeln (' hubo ', v[i], ' atenciones para el diagnostico ', i);
end;

function entreDos (a:arbolI; dni1,dni2,valor:integer): integer;
begin 
 if (a <> nil ) then
  begin
   if (a^.dato.dni > dni1) and (a^.dato.dni < dni2) then
    begin
     if (a^.dato.cantidad > valor) then
      entreDos := 1 + entreDos (a^.HI,dni1,dni2,valor) +entreDos (a^.HD,dni1,dni2,valor)
    end
   else
    if (a^.dato.dni > dni1) then
    entreDos:= entreDos (a^.HI,dni1,dni2,valor)
   else entreDos := entreDos (a^.HD, dni1,dni2, valor);
  end
 else
  entreDos:=0;
end;

function ceroAtenciones (v:vectorA; dim:integer):integer;
begin
 if (dim> 0) then
  begin
   if (v[dim] = 0) then
    ceroAtenciones:= 1 + ceroAtenciones (v,dim-1)
   else ceroAtenciones:= ceroAtenciones (v,dim-1);// IMPORTANTE
  end
 else
  ceroAtenciones:=0;
end;
var
a:arbolI;
v:vectorA;
aux,dni1, dni2, valor:integer;
dim:integer;
begin
randomize;
a:=nil;
inicializarVector (v);
cargar (a, v);
imprimir (a);
imprimirVector (v);
writeln ('ingrese un dni:');
readln (dni1);
writeln ('ingrese otro dni: (mas grande)');
readln (dni2);
writeln ('ingrese un valor');
readln (valor);
aux:=entreDos (a,dni1,dni2,valor);
writeln ('entre ', dni1,' y ', dni2,' hay ',aux,' pacientes con mas de ', valor, ' atenciones '); 
dim:=15;
aux:=ceroAtenciones (v,dim);
writeln ('hubo ', aux, ' con cero atenciones');
end.
