{Un comercio necesita el procesamiento de las compras realizadaspor sus clientes el mes de julio de 2022. 
De cada compra se conoce codigo del cliente, dia ,cantidad de productos y monto pagado.
a) Implementar un modulo que lea compras, genere y retorne una estructura adecuada para la busqueda por codigo del cliente, 
donde para cada codigo de cliente se almacenan juntas todas sus compras (dia, cantidad de productos y monto, ) que realizo .
La lectura finaliza con la cantidad de productos 0. Se sugiere utilizar el modulo leerregistro ().
b) Implementar un modulo que reciba la estructura generada en a) y un codigo de cliente y retorne todas las compras de dicho cliente.
c) Realizar un modulo RECURSIVO  que reciba la estructura el iniciso b) y retorne el monto de la compra con mayor cantidad de productos.}
program parcial6;
type 
rangoDia=1..31;
compra=record
 codigo:integer;
 dia:rangoDia;
 cantidad:integer;
 monto:real;
end;

regLista=record
 dia:rangoDia;
 cantidad:integer;
 monto:real;
end;

lista=^nodoLista;
nodoLista=record
 dato:regLista;
 sig:lista;
end;

regArbol=record
 codigo:integer;
 l:lista;
end;
arbol=^nodoArbol;
nodoArbol=record
 dato:regArbol;
 HI:arbol;
 HD:arbol;
end;

procedure LeerCompra (var c:compra);
begin
 c.codigo:=random (50)+1;
 c.dia:= random (31)+1;
 c.cantidad:= random (30);
 c.monto:= random (200)+1;
end;
procedure asignar (var rl:regLista; c:compra);
begin
 rl.dia:=c.dia;
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
 if (a=nil) then
  begin
   new (a);
   a^.dato.codigo:=c.codigo;
   asignar (rl,c);
   a^.dato.l:=nil;
   agregarAdelante (a^.dato.l, rl);
   a^.HI:=nil;
   a^.HD:=nil;
  end
 else if (a^.dato.codigo =c.codigo) then
  begin
   asignar (rl,c);
   agregarAdelante (a^.dato.l,rl);
  end
 else if (a^.dato.codigo > c.codigo) then
  agregarArbol (a^.HI,c)
 else  agregarArbol (a^.HD,c);
end;
procedure cargarArbol (var a:arbol);
var
c:compra;
begin
leerCompra (c);
while (c.cantidad <> 0) do 
 begin
  agregarArbol (a,c);
  writeln ('cod: ',c.codigo,' dia: ',c.dia,' cantidad: ', c.cantidad, ' monto: ', c.monto:0:2); 
  leerCompra (c);
 end;
end;
procedure imprimirLista (l:lista);
begin
 while (l<>nil) do
  begin
   writeln (' dia: ',l^.dato.dia,' cantidad: ',l^.dato.cantidad, ' monto: ',l^.dato.monto:0:2);
   l:=l^.sig;
  end;
end;
procedure imprimirArbol (a:arbol);
begin
 if (a<> nil) then
  begin
   imprimirArbol (a^.HI);
   writeln ('codigo: ',a^.dato.codigo);
   imprimirLista (a^.dato.l);
   imprimirArbol (a^.HD);
  end;
end;
procedure buscarCli (a:arbol; cli:integer; var listaNue:lista);
begin
 if (a<> nil) then
  begin
   if (a^.dato.codigo = cli) then
     listaNue:=a^.dato.l
   else if (a^.dato.codigo > cli) then
    buscarCli (a^.HI,cli, listaNue)
   else buscarCli (a^.HD,cli, listaNue);
  end
 else writeln ('no se encontro el cliente');
end;
procedure maxProductos (var maxP:integer; cantidad:integer);
begin
 if (maxP < cantidad) then
  maxP:=cantidad;
end;
procedure maxMonto (l:lista; var maxP:integer;var maxM:real);
begin
 if (l<> nil) then
  begin
   maxProductos (maxP,l^.dato.cantidad);
   if (maxP = l^.dato.cantidad) then
    maxM:= l^.dato.monto;
   maxMonto (l^.sig,maxP,maxM);
  end;
end;
var
a:arbol;
cliente:integer;
lisCli:lista;
maxP:integer;
maxM:real;
begin
randomize;
a:=nil;
cargarArbol (a);
imprimirArbol (a);
writeln ('ingrese codigo de cliente: ');
readln (cliente);
buscarCli (a,cliente,lisCli);
maxP:=0;
maxMonto (lisCli, maxP, maxM);
writeln ('el monto de la compra con mas productos es: ', maxM:0:2);
end.
