import 'dart:convert';
import 'dart:io';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_006/Modelos/Categoria.dart';
import '../CategoriaCuadrado.dart';
import 'package:http/http.dart' as http;

class home extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(
        title: Text("Hola flutter"),
      ),
      drawer: Drawer(
        child: ListView(
          children: <Widget>[
            DrawerHeader(
                child: Text("Codigo Tienda"),
              decoration: BoxDecoration(
                color: Colors.blue,
              ),
            ),
            ListTile(title: Text("Inicio"), leading: Icon(Icons.home),),
            ListTile(title: Text("cerrar sesion"), leading: Icon(Icons.bluetooth),onTap: ()=> exit(0))
          ],
        ),
      ),
      body: Container(
        child: FutureBuilder<List<Categoria>>(
          future: ObtenerCategoria(),
          builder: (context, data){
            if(data.hasData){
              return GridView.builder(
                itemCount: data.data.length,
                gridDelegate: new SliverGridDelegateWithFixedCrossAxisCount(
                    crossAxisCount: 2),
                itemBuilder: (context,index){
                  return CategoriaCuadrado(categoria:data.data[index]);
                },
              );
            }else if(data.hasError){
              return Text("error");
            }
            return CircularProgressIndicator();
          },
        ),
      ),
    );
  }

}

Future<List<Categoria>> ObtenerCategoria() async{
  final response = await http.get("https://viveyupi.com/api/categorias/nivel/1/");
  if(response.statusCode == 200) {
    List<dynamic> body = jsonDecode(response.body);
    List<Categoria> datos = body.map((json) => Categoria.fromJson(json)).toList();
    return datos;
  }else{
    throw Exception("error cargando la categoria");
  }
}