{Aerolineas Argentinas necesita procesar los pasajes vendidos durante 2023.
De cada pasaje se conoce codigo de vuelo, codigode cliente, codigo ciudad destino y monto del pasaje.
a) Implementar un modulo que lea pasajes, genere y retorne una estructura adecuada para la busqueda por codigo de ciudad destino, 
donde para cada ciudad de destino se almacenan juntos todos los pasajes (cod de vuelo. cod cliente y monto del pasaje).
La lectura finaliza con el monto de pasaje 0, Se sugiere utilizar el modulo leerPasaje ().
b) Implementar un modulo que reciba la estructura generada en a) y un codigo de ciudad de destino y retorne todos los pasajes hacia esa ciudad destino.
c)Realizar un modulo que reciba la estructura generada en a) y retorne el codigo de ciudad de destino con mayor cantidad de pasajes vendidos.
}
program parcial3;
type
pasaje=record
  vuelo:integer;
  cliente:integer;
  ciudad:integer;
  monto:real;
end;

regLista=record
 vuelo:integer;
 cliente:integer;
 monto:real;
end;

lista=^nodoLista;
nodoLista=record
 dato:regLista;
 sig:lista;
end;

regArbol=record
 ciudad:integer;
 pasajes:lista;
end;
Arbol=^nodoArbol;
nodoArbol=record
 dato:regArbol;
 HI:arbol;
 HD:arbol;
end;

procedure leerP (var p:pasaje);
begin
  p.vuelo:=random (70)+1;
  p.cliente:=random(50)+1;
  p.ciudad:=random (100)+1;
  p.monto:=random(300);
end;

procedure asignar (var rl:regLista; p:pasaje);
begin
 rl.vuelo:=p.vuelo;
 rl.cliente:=p.cliente;
 rl.monto:= p.monto;
end;

procedure agregarAdelante (var l:lista; rl:regLista);
var
aux:lista;
begin
new (aux);
aux^.dato:=rl;
aux^.sig:=l;
l:=aux;
end;

procedure agregarArbol (var a:arbol; p:pasaje);
var
rl:regLista;
begin
if (a = nil) then
 begin
  new (a);
  asignar (rl,p);
  a^.dato.ciudad:=p.ciudad;
  a^.dato.pasajes:=nil;
  agregarAdelante (a^.dato.pasajes,rl);
  a^.HI:=nil;
  a^.HD:=nil
 end
else if (a^.dato.ciudad = p.ciudad) then
 begin
  asignar (rl,p);
  agregarAdelante (a^.dato.pasajes,rl);
 end
else if (a^.dato.ciudad > p.ciudad) then
 agregarArbol (a^.HI,p)
else agregarArbol (a^.HD,p);
end;

procedure cargarArbol (var a:arbol);
var
p:pasaje;
begin
leerP (p);
while (p.monto <> 0) do
 begin
  agregarArbol (a,p);
  writeln ('ciudad: ',p.ciudad,' vuelo ',p.vuelo,' cliente ', p.cliente, ' monto ', p.monto:0:2);
  leerP (p);
 end;
end;

procedure imprimirLista (l:lista);
begin
while (l<> nil) do
 begin
  writeln ('vuelo: ', l^.dato.vuelo, ' cliente ', l^.dato.cliente, ' monto ', l^.dato.monto:0:2);
  l:=l^.sig;
 end;
end;
procedure imprimirArbol (a:arbol);
begin
 if (a<> nil) then
  begin 
   imprimirArbol (a^.HI);
   writeln ('ciudad ',a^.dato.ciudad);
   imprimirLista (a^.dato.pasajes);
   imprimirArbol (a^.HD);
  end;
end;
procedure buscar (a:arbol; destino:integer);
begin
 if (a<> nil) then
  begin
   if (a^.dato.ciudad =destino) then
    begin
     writeln ('los pasajes para la ciudad ', destino,' son: ');
     imprimirLista (a^.dato.pasajes); 
    end
   else if (a^.dato.ciudad > destino) then
    buscar (a^.HI,destino)
   else  buscar (a^.HD,destino);
  end;
end;
function maxLista (l:lista):integer;
var
cant:integer;
begin
cant:=0;
while (l<> nil) do
 begin
  cant:=cant +1;
  l:=l^.sig;
 end;
maxlista:=cant;
end;
procedure maxArbol (a:arbol; var cod, max:integer);
var
cant:integer;
begin
 if (a<> nil) then
  begin
   cant:=maxLista (a^.dato.pasajes);
   if (cant > max) then
    begin
     max:=cant;
     cod:=a^.dato.ciudad;
    end;
   maxArbol (a^.HI,cod,max); // no es else pq sino se queda on el 1er valor que lee
   maxArbol (a^.HD,cod,max);
 end;
end;
var
a:arbol;
destino:integer;
cod, max:integer;
begin
randomize;
a:=nil;
cargarArbol (a);
imprimirArbol (a);
writeln ('ingrese un destino');
readln (destino);
buscar (a, destino);
max:=-1;
maxArbol (a,cod,max);
writeln ('la ciudad con mas pasajes vendidos es: ' ,cod);
end.
