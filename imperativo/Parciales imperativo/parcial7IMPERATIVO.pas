{a)implemetnar un modulo qur lea compras de videojuegos. De cada compra se lee codigo del videojuego, codigo de cliente, dia y mes.
 La lectura finaliza con el codigo de cliente 0. Se sugiere utilizar el modulo leerCompra ().  Se deben retornar 2 estructuras de datos:
i. Una eficiente para la busqueda ordenada por codigo de cliente.
* ii. Otra almacen ala cantidad de compras realizadas en cada mes.
b) implementar un modulo que reciba la estructura generada en a)i, un cod  de cliente, retorne todas las compras que realizo dicho cliente.
c) Implementar un modulo que reciba la estructura generada e a) ii y retorne la misma estructura ordenada por cantidad de menor a mayor.}
program parcial7;
type 
rangoDia=1..31;
rangoMes=1..12;
videojuego= record
 codigo:integer;
 cliente:integer;
 dia:rangoDia;
 mes:rangoMes;
end;
regLista=record
 codigo:integer;
 dia:rangoDia;
 mes:rangoMes;
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
vector= array [rangoMes] of integer;

procedure leerVJ (var vj:videojuego);
begin
 vj.codigo:= random (50)+1;
 vj.cliente:= random (30);
 vj.dia:= random (31)+1;
 vj.mes:= random (12)+1;
end;
procedure inicializarVector (var v:vector);
var
i:integer;
begin
for i:=1 to 12 do
 v[i]:=0;
end;
procedure asignar (var rl:regLista; vj:videojuego);
begin
 rl.codigo:= vj.codigo;
 rl.dia:=vj.dia;
 rl.mes:=vj.mes;
end;

procedure agregarAdelante (var l:lista; rl: regLista);
var 
aux:lista;
begin
 new (aux);
 aux^.dato:= rl;
 aux^.sig:= l;
 l:=aux;
end;

procedure agregarArbol (var a:arbol; vj:videojuego);
var
rl:regLista;
begin
 if (a= nil) then
  begin
   new (a);
   a^.dato.cliente:= vj.cliente;
   a^.dato.l:= nil;
   asignar (rl,vj);
   agregarAdelante (a^.dato.l,rl);
   a^.HI:=nil;
   a^.HD:=nil;
  end
 else if (a^.dato.cliente =vj.cliente) then
  begin  
   asignar (rl,vj);
   agregarAdelante (a^.dato.l, rl);
  end
  else if (a^.dato.cliente > vj.cliente) then
   agregarArbol (a^.HI,vj)
  else agregarArbol (a^.HD, vj);
 end;
 
 procedure cargarArbol (var a:arbol; var v:vector);
 var
 vj:videojuego;
 begin
  leerVJ (vj);
  while (vj.cliente <> 0) do
   begin
    agregarArbol (a,vj);
    v[vj.mes]:= v[vj.mes] + 1;
    writeln ('cod: ', vj.codigo, ' cliente: ', vj.cliente, ' dia: ', vj.dia, ' mes: ', vj.mes); 
    leerVJ (vj);
   end;
  end;
  
  procedure imprimirLista (l:lista);
  begin
   while l<> nil do
    begin
     writeln ('cod: ', l^.dato.codigo,  ' dia: ', l^.dato.dia, ' mes: ', l^.dato.mes); 
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
   
   procedure imprimirVector (v:vector);
   var
   i:integer;
   begin
    for i:=1 to 12 do 
     writeln ('en el mes ', i, ' hubo ', v[i], ' compras');
    end;
  procedure seleccion (var v:vector);
  var
  i,j,pos:integer;
  item:integer;
  begin
  for i:=1 to 11 do 
   begin
    pos:=i;
    for j:=i+1 to 12 do
      if (v[j]< v[pos]) then
       pos:=j;
      item:= v[pos];
      v[pos]:= v[i];
      v[i]:= item;
    end;
   end;
      
  var
  a:arbol;
  v:vector;
  begin
  randomize;
  a:=nil;
  inicializarVector (v);
  cargarArbol (a,v);
  imprimirArbol (a);
  imprimirVector (v);
  seleccion (v);
  imprimirVector (v);
  end.
