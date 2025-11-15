{Netflix ha publicado la lista de películas que estarán disponibles durante el mes de
diciembre de 2022. De cada película se conoce: código de película, código de género (1: acción,
2: aventura, 3: drama, 4: suspenso, 5: comedia, 6: bélico, 7: documental y 8: terror) y puntaje
promedio otorgado por las críticas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Lea los datos de películas, los almacene por orden de llegada y agrupados por código de
género, y retorne en una estructura de datos adecuada. La lectura finaliza cuando se lee el
código de la película -1.
b. Genere y retorne en un vector, para cada género, el código de película con mayor puntaje
obtenido entre todas las críticas, a partir de la estructura generada en a)..
c. Ordene los elementos del vector generado en b) por puntaje utilizando alguno de los dos
métodos vistos en la teoría.
d. Muestre el código de película con mayor puntaje y el código de película con menor puntaje,
del vector obtenido en el punto c).}
program ej3p1;
const  cantGen=8;
type rangoGen=1..cantGen;
peliculas= record
  codP:integer;
  codG:rangoGen;
  puntaje:real;
 end;
 
 lista=^nodo;
 nodo=record
  dato:peliculas;
  sig:lista;
 end; 
 
 vectorP= array [rangoGen] of lista;
 
 codProm=record
   codPeli:integer;
   puntajePromedio:real;
 end;
 
 vectorC=array [rangoGen] of codProm;
 
 procedure leerP (var p:peliculas);
 begin //writeln ('ingrese codigo de pelicula');
  p.codP:= random(30);//readln (p.codP);
   if (p.codP <> -1) then 
   begin
   // writeln ('ingrese genero');
    p.codG:=random(8)+1;//readln (p.codG);
    //#FFFFFFwriteln ('ingrese puntaje');
    p.puntaje:= random (10)+1;//readln (p.puntaje);
   end;
end;

procedure agregarAtras (var l:lista; p:peliculas);
var
aux,ult:lista;
begin
new(aux);
aux^.dato:= p;
aux^.sig:= nil;
if (l=nil) then 
 l:=aux
else
 begin
   ult:=l;
   while (ult^.sig <> nil) do
     ult:= ult^.sig;
   ult^.sig:= aux
 end;
end;
 
 procedure inicializarVectorP (var vp:vectorP);
 var
 i:rangoGen;
 begin
 for i:=1 to cantGen do
 vp[i]:= nil;
 end;

procedure cargarVectorP (var vp:vectorP);
var
p:peliculas;i,j:integer;
begin
j:=random (30);
leerP(p);
for i:=1 to j do//while (p.codP <> -1) do
 begin
   agregarAtras(vp[p.codG],p);
   leerP(p);
 end;
end;

procedure inicializarVectorC ( var vc:vectorC);
var
k:integer;
begin
for k:=1 to cantGen do
  begin
   vc[k].codPeli:=0;
   vc[k].puntajePromedio:=0;
  end;
end;
   
procedure obtenerMax (vp:vectorP; var vc:vectorC);
var
codMax,i:rangoGen;
puntMax:real;
begin
for i:=1 to cantGen do //por genero
begin
  puntMax:=0;
  while (vp[i] <> nil ) do // varias pelis dentro del genero
    begin 
     if (vp[i]^.dato.puntaje > puntMax) then
      begin
       puntMax:= vp[i]^.dato.puntaje;
       codMax:= vp[i]^.dato.codP;
     end;
     vp[i]:= vp[i]^.sig;
    end;
  vc[i].codPeli:= codMax;
  vc[i].puntajePromedio:= puntMax;
end;
end;

procedure imprimir (vc:vectorC);
var
i:integer;
begin
for i:=1 to cantGen do
writeln ('genero: ', i,' codigo: ', vc[i].codPeli,' puntaje: ', vc[i].puntajePromedio:0:2);
end;

procedure seleccion (var vc: vectorC);
var
act, j, i: integer;
item:codProm;
begin
for i:=1 to cantGen-1 do //DL= 8-1
 begin
  act:=i;
  for j:= i+1 to cantGen do
     if (j > 0) and (vc[j].puntajePromedio < vc[act].puntajePromedio) then
       act:=j;
     item:= vc[act];
     vc[act]:= vc[i]; //intercambio act(=j) e i
     vc[i]:=item;
  end;
end;
var
vc: vectorC;
vp:vectorP;
begin
randomize;
inicializarVectorP (vp);
inicializarVectorC(vc);
cargarVectorP (vp);
obtenerMax (vp,vc);
seleccion (vc);
imprimir (vc);
writeln ('El codigo de pelicula de mayor puntaje es: ',vc[cantGen].codPeli);
    Writeln('El codigo de pelicula de menor puntaje por la critica es: ',vc[1].codPeli);

end. 
