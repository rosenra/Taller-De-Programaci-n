{El hipermercado Carrefour necesita un sistema para obtener estadisticas sobre las compras realizadas por sus clientes:
a) Implementar un modulo que lea informacion de todas las compras de 2023,
los almacene y retorne una estructura de datos eficiente para la busqueda por codigo de cliente,donde para cada 
codigo de cliente se almacenen juntas todas sus compras.De cada compra se conoce: codigo de cliente, numero de factura,cantidad de productos y monto. 
La lectura finaliza con el codigo de cliente 0.
b) Implementar un modulo que reciba la estructura generada en a), un codigo de cliente y retorne la cantidad de compras y el monto total gastado
por dicho cliente durante el 2023.
c) Realizar un modulo que reciba la estructura generada en a) y dos numeros de factura X e Y, y retorne todas las ventas
cuyo numero de factura esten entre X e Y (incluidos)}
program parcial4;
type
compra=record
 cliente:integer;
 factura:integer;
 cantidad:integer;
 monto:real;
end;

regLista=record
 factura:integer;
 cantidad:integer;
 monto:real;
end;

lista=^nodoLista;
nodoLista=record
 dato:regLista;
 sig:lista;
end;

regArbol=record
  cliente:integer;
  l:lista;
end;

arbol=^nodoArbol;
nodoArbol=record
  dato:regArbol;
  HI:arbol;
  HD:arbol;
end;
procedure leerCompra (var c:compra);
begin
 c.cliente:= random (50);
 c.factura:= random (80) + 1;
 c.cantidad:= random (70) +1;
 c.monto:= random (200) + 1;
end;

procedure asignar (var rl:regLista; c:compra);
begin
 rl.factura:=c.factura;
 rl.cantidad:=c.cantidad;
 rl.monto:=c.monto;
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

procedure agregarArbol (var a:arbol; c:compra);
var
 rl:regLista;
begin
 if (a= nil) then // IGUALLLL
   begin
    new (a);
    a^.dato.cliente:= c.cliente;
    a^.dato.l:=nil;
    asignar (rl,c);
    agregarAdelante (a^.dato.l,rl);
    a^.HI:=nil;
    a^.HD:=nil;
   end
 else 
  if (a^.dato.cliente =c.cliente) then
   begin 
    asignar (rl,c);
    agregarAdelante (a^.dato.l, rl);
   end
  else if (a^.dato.cliente > c.cliente) then
   agregarArbol (a^.HI,c)
  else agregarArbol (a^.HD,c);
end;

procedure cargarArbol (var a:arbol);
var
c:compra;
begin
leerCompra (c);
while (c.cliente <>0) do 
 begin
  agregarArbol (a,c);
  writeln ('cliente: ',c.cliente,' factura: ', c.factura, 'cant: ',c.cantidad, ' monto: ', c.monto:0:2);
  leerCompra (c);
 end;
end;

procedure imprimirLista (l:lista);
begin
while (l<> nil) do
 begin
  writeln ('factura: ', l^.dato.factura, ' cant: ', l^.dato.cantidad, ' monto: ', l^.dato.monto:0:2);
  l:=l^.sig;
 end;
end;

procedure imprimirArbol (a:arbol);
begin
 if (a<> nil) then
  begin
   imprimirArbol (a^.HI);
   writeln ('cliente: ', a^.dato.cliente);
   imprimirLista (a^.dato.l);
   imprimirArbol (a^.HD);
  end;
 end;
 
 procedure recorrerLista (l:lista; var cantC:integer; var total:real);
 begin
  while (l<> nil ) do 
   begin
    cantC:=cantC+1;
    total:= total + l^.dato.monto;
    l:=l^.sig;
   end;
 end;
 
 procedure buscarCli (a:arbol; var cantC:integer; var total:real; cli:integer);
 begin
   if (a<> nil) then
    begin
     if (a^.dato.cliente = cli) then
       recorrerLista (a^.dato.l, cantC,total)
     else if (a^.dato.cliente > cli) then
      buscarCli (a^.HI,cantC,total,cli)
     else
      buscarCli (a^.HD,cantC,total,cli);
   end;
end;

 procedure agregarLF (var lf:lista; l:lista; x,y:integer);
 begin
  while (l<> nil) do 
   begin
    if (l^.dato.factura >= x) and (l^.dato.factura <= y) then
       agregarAdelante (lf, l^.dato);
    l:=l^.sig;// AFUERA DEL IF
    end;
  end;
    
 procedure entreDos (var lf:lista; a:arbol; x,y:integer);
 begin
  if (a<> nil) then
   begin
    agregarLF (lf, a^.dato.l, x,y);
    entreDos (lf, a^.HI, x,y);
    entreDos (lf, a^.HD, x,y);
   end;
 end;

 var
 a:arbol;
 cli:integer;
 cantCli:integer;
 total:real;
 x,y:integer;
 lf:lista;
 begin
 randomize;
 a:=nil;
 cargarArbol (a);
 imprimirArbol (a);
 cantCli:=0;
 total:=0;
 writeln ('ingrese un codigo de cliente');
 readln (cli);
 buscarCLi (a,cantCli,total,cli);
 writeln ('el cliente: ',cli,' realizo ', cantCli,' compras, en total gasto  $',total:0:2); 
 writeln ('ingrese un numero de factura ');
 readln (x);
 writeln ('ingrese otro numero de factura (mas grande)');
 readln (y);
 lf:=nil;
 entreDos (lf,a,x,y);
 imprimirLista (lf);
end.
