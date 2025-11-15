{Una librería requiere el procesamiento de la información de sus productos. De cada
producto se conoce el código del producto, código de rubro (del 1 al 8) y precio.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de los productos y los almacene ordenados por código de producto y
agrupados por rubro, en una estructura de datos adecuada. El ingreso de los productos finaliza
cuando se lee el precio 0.
b. Una vez almacenados, muestre los códigos de los productos pertenecientes a cada rubro. 
c. Genere un vector (de a lo sumo 30 elementos) con los productos del rubro 3. Considerar que
puede haber más o menos de 30 productos del rubro 3. Si la cantidad de productos del rubro 3
es mayor a 30, almacenar los primeros 30 que están en la lista e ignore el resto.
d. Ordene, por precio, los elementos del vector generado en c) utilizando alguno de los dos
métodos vistos en la teoría.
e. Muestre los precios del vector resultante del punto d).
f. Calcule el promedio de los precios del vector resultante del punto d).
}
program ej4p1;
const
cantR=8; //rubro del 1-8
type
rangoR=1..cantR;
productos=record
  codP:integer;
  codR:rangoR;
  precio:real;
 end;
 
 lista=^nodo;
 nodo=record
dato:productos;
sig:lista;
end;

vectorR=array [rangoR] of lista;
vectorR3=array [1..30] of productos;

procedure leerP (var p:productos);
begin
p.codP:= random (50);
p.codR:= random(8)+1;
p.precio:= random (100)/random (100);
end;

procedure insertarOrdenado (var l:lista; p:productos);
var
ant, aux, act:lista;
begin
new(aux);
aux^.dato:=p;
act:=l;
ant:=l;
while (act <> nil) and (aux^.dato.codP < act^.dato.codP) do
begin
ant:=act;
act:=act^.sig;
end;
if (ant = act) then
l:=aux
else
 ant^.sig:=aux;
aux^.sig:= act
end;


procedure inicializarVR (var vr:vectorR);
var
i: rangoR;
begin
for i:=1 to cantR do
 vr[i]:= nil; // vector de tipo lista

end;

procedure cargarV3 (var v3:vectorR3; v:vectorR;var DL:integer);
var
i: integer; act:lista;
begin
DL:=0;
i:=0;
act:=v[3];
  while (act<> nil) and (DL < 30) do// nil pq es lista
   begin
    DL:= DL +1;
    i:= i+1;
    v3[i]:= act^.dato;
    act:=act^.sig;
   end;
end;

{procedure cargarVector(var vr:vectorR);
var
	p: productos;
    i: integer;
begin
	for i:= 1 to random((50)+1) do
        begin
            leerP(p);
            insertarOrdenado(vr[p.codR], p);
        end;
end;}
procedure cargarVR (var vr:vectorR);
var
p: productos; 
begin 
leerP(p); 
while (p.precio <> 0) do 
  begin 
  insertarOrdenado (vr[p.codR], p); 
  leerP(p); 
 end; 
end; 

procedure imprimirLista(L: lista); begin
  if(L = nil)then
    Writeln('Lista vacia');
  While( L <> nil)do
    begin
      Writeln('Codigo producto = ',L^.dato.codP);
      Writeln('Precio de producto = ',L^.dato.precio:0:2);
      L:= L^.sig;
    end;
end; 


procedure imprimir (vr:vectorR);
var
i:integer;
begin
for i:=1 to cantR do
begin
writeln ('rubro:', i);
imprimirLista (vr[i])

end;
end;

procedure insercion (var v3: vectorR3; dl:integer);
var
i,j:integer;
act:productos;
begin
for i:=2 to dl-1 do
begin
act:= v3[i];
j:=i-1;
while (j >0) and (v3[j].precio > act.precio) do // > act NO A v3[act]!!!
 begin
  v3[j+1]:= v3[j];
  j:=j-1;
 end;
v3[j+1]:=act;
end;
end;

 
procedure imprimirV3 (v3:vectorR3; dl:integer);
var
k:integer;
begin
writeln ('rubro3: ');
for k:=1 to dl do
writeln ('codigo: ',v3[k].codP, ' precio: ', v3[k].precio:0:2);

end;

function promedio (v3:vectorR3; dl:integer):real;
var
i:integer; cant:real;
begin
cant:=0;
for i:=1 to dl do
cant:= cant + v3[i].precio;
promedio:= cant/dl;
end;

var
vr:vectorR; v3: vectorR3; DL:integer;
begin
inicializarVR (vr);
writeln ('fin');
cargarVR (vr);//cargarVector(vr);//cargarVR (vr);
writeln ('fin');
imprimir (vr);
cargarV3(v3,vr,DL);
insercion(v3,DL);
imprimirV3 (v3,DL);
writeln ('el promedio es: ', promedio(v3,dl):0:2);
end.


