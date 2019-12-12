import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'CategoriaCuadrado.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Hola flutter"),
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
                    return CategoriaCuadrado(url:data.data[index].imagencuadrada,);
                  },
                );
              }else if(data.hasError){
                return Text("error");
              }
              return CircularProgressIndicator();
            },
          ),
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

class Categoria{
  String imagencuadrada;
  int id;

  Categoria({this.imagencuadrada, this.id});

  factory Categoria.fromJson(Map<String, dynamic> json){
    Categoria c = Categoria(
        imagencuadrada:json["imagencuadrada"],
        id:json["id"]
    );
    return c;
  }
}