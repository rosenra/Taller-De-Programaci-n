{Escribir un programa que:
a. Implemente un módulo recursivo que genere y retorne una lista de números enteros
“random” en el rango 100-200. Finalizar con el número 100.
b. Un módulo recursivo que reciba la lista generada en a) e imprima los valores de la lista en el
mismo orden que están almacenados.
c. Implemente un módulo recursivo que reciba la lista generada en a) e imprima los valores de
la lista en orden inverso al que están almacenados.
d. Implemente un módulo recursivo que reciba la lista generada en a) y devuelva el mínimo
valor de la lista.
e. Implemente un módulo recursivo que reciba la lista generada en a) y un valor y devuelva
verdadero si dicho valor se encuentra en la lista o falso en caso contrario.}

program ej2p2;
type
lista=^nodo;
nodo=record
dato:integer;
sig:lista;
end;
procedure agregarAdelante (var l:lista; n:integer);
var
aux:lista;
begin
new(aux);
aux^.dato:= n;
aux^.sig:= l;
l:=aux;
end;
procedure cargarL (var l:lista);
var
n:integer;
begin
n:= random (200-100 +1)+100;
if  (n <> 100) then
  begin 
   agregarAdelante (l,n);
   cargarL (l);
 end;
end;
procedure imprimirR (l: lista);
begin
 if (l <> nil) then
   begin
    imprimirR (l^.sig);
    writeln (l^.dato);
   end;
end;
procedure imprimirInverso (l: lista);
begin
 if (l <> nil) then
   begin
   
    writeln (l^.dato);
    imprimirInverso (l^.sig);
    
   end;
end;

{function minimo (l: lista):integer;
var
min:integer;
begin
if (l <> nil) then
  begin
     min:= minimo(l^.sig);
     if (min > l^.dato) then
       minimo:= l^.dato
     else 
       minimo:= min;
   end;
end;}

procedure minimo(l: lista; var min:integer);

begin
	if (l<>nil) then begin
		if (l^.dato <min) then
			min:=l^.dato;
		minimo(l^.sig,min);
	end;
end;

function encontrar (l:lista; v:integer):boolean;
begin
if (l<> nil) then
 begin
  if (l^.dato = v) then
  encontrar:=true
  else 
  encontrar:= encontrar (l^.sig,v);//!!!
 end
else if (l = nil) then //!!!
encontrar:= false;
end;
var
l:lista; v: integer;esta:boolean; min:integer;
begin
randomize;
l:=nil;
min:=9999;
cargarL (l);
imprimirR(l);
writeln ('fin' );
imprimirInverso(l);
minimo (l,min);
writeln ('el minimo es: ', min);
writeln (  );
writeln ('ingrese un valor');
readln (v);
esta:=encontrar(l,v);
if (esta) then
 writeln ('se encontro')
 else writeln ('no esta');
 
end.
