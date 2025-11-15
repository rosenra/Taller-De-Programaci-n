{Se lee informacion importante de las compras realizadas por los clientes de un supermercado en el año 2022. 
De cada compra se lee el codigo de cliente, numero de mes y monto gastado. La lectura finaliza cuando se lee al cliente con codigo 0.
a) Realizar un modulo que lea la informacion de las compras y retorne una estructura de datos eficiente para la busqueda por codigo de cliente.
 Para cada cliente, esta estructura debe acumular monto total gastado para cada mes del año 2022. Se sugiere utilizar el modulo leerCompra ().
b) Realizar un modulo que reciba la estructura generada en a) y un cliente, y retorne el mes con mayor gasto de dicho cliente.
c)Realizar un modulo que recibo la estructura generada en a) y un numero de mes, y retorne la cantidad de clientes que no gastaron nada en dicho mes.
}
program parcial2;
type
compra=record
  codigo:integer;
  mes:1..12;
  monto:real;
end;
vector=array [1..12] of real;
regArbol=record
 codigo:integer;
 total:vector;
end;

arbol=^nodo;
nodo=record
 dato:regArbol;
 HI:arbol;
 HD:arbol;
end;

procedure leerC (var c:compra);
begin
 c.codigo:= random(50);
 c.mes:= random (12)+1;
 c.monto:= random (300);
end;
procedure inicializarVector (var v:vector);
var
i:integer;
begin
 for i:=1 to 12 do 
  v[i]:=0;
end;
procedure agregarArbol (var a:arbol; c:compra);
var
ra:regArbol;
begin 
 if (a = nil) then
  begin
   new (a);
   ra.codigo:=c.codigo;
   inicializarVector (ra.total);//INICIALIZAR VECTOR PARA CADA CLIENTE
   ra.total[c.mes]:= ra.total[c.mes]+ c.monto;
   a^.dato:=ra;
   a^.HI:=nil;
   a^.HD:=nil;
  end
 else if (a^.dato.codigo = c.codigo) then
  a^.dato.total[c.mes]:=a^.dato.total[c.mes] + c.monto
 else if (a^.dato.codigo > c.codigo) then
  agregarArbol (a^.HI,c)
 else agregarArbol (a^.HD,c);
end;

procedure generarArbol (var a:arbol);
var
c:compra;
begin
leerC (c);
while (c.codigo <> 0) do
 begin
  agregarArbol (a,c);
  writeln (' cod: ', c.codigo, ' mes: ',c.mes,' monto: ', c.monto:0:2);
  leerC (c);
 end;
end;
procedure imprimirVector (v:vector);
var
i:integer;
begin
 for i:=1 to 12 do
  writeln ('el monto del mes ',i,' es: ', v[i]:0:2);
end;

procedure imprimir (a:arbol);
begin
 if (a<> nil) then
  begin
   imprimir (a^.HI);
   writeln ('cod: ', a^.dato.codigo);
   imprimirVector (a^.dato.total);
   imprimir (a^.HD);
  end;
end;
function recorrerV (v:vector): integer;
var
max, i:integer;
maxMonto:real;
begin
maxMonto:=-1;
 for i:=1 to 12 do
  begin
   if (v[i]> maxMonto) then
     begin
      maxMonto:= v[i];
      max:=i;
     end;
   end;
recorrerV:= max;
end;
function maxGasto (a:arbol; cliente:integer):integer;
begin
 if (a<> nil) then
  begin
   if (a^.dato.codigo =cliente) then
    maxGasto:= recorrerV (a^.dato.total)
  else if (cliente < a^.dato.codigo) then 
   maxGasto:= maxGasto (a^.HI,cliente)
  else maxGasto:= maxGasto (a^.HD,cliente);
  end
 else maxGasto:=0;
end;

function noGasto (a:arbol; mes:integer):integer;
begin
if (a<> nil) then
  begin
   if (a^.dato.total[mes]=0) then
    noGasto:=1+ noGasto (a^.HI,mes) + noGasto (a^.HD,mes)
   else
     noGasto:= noGasto (a^.HI,mes) + noGasto (a^.HD,mes);
  end
else noGasto:=0;
end;
   
var
a:arbol;
cliente:integer;
mes:integer;
begin
randomize;
a:=nil;
generarArbol (a);
WRITELN ('FIN' );
imprimir (a);
writeln ('ingrese un codigo de cliente');
readln (cliente);
writeln ('el mes ', maxGasto (a, cliente), ' fue el mes de mayor gasto del cliente ', cliente);
writeln ('ingrese mes');
readln (mes);
writeln ('en el mes ',mes,',', noGasto (a,mes),' clientes no realizaron ningun gasto');
end.
