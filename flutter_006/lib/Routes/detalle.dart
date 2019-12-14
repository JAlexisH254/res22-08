
import 'dart:convert';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_006/Modelos/Categoria.dart';
import 'package:http/http.dart' as http;

import '../CategoriaCuadrado.dart';
import 'home.dart';

class detalle extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    Categoria categoria = ModalRoute.of(context).settings.arguments;
    // TODO: implement build
    return Scaffold(
      appBar: AppBar(
        title: Text("Seleccionar_subCategoria"),
      ),
      body: Container(
        child: Column(
          children: <Widget>[
            Container(
              height: 135,
              color: Colors.blue,
              child: Image.network(categoria.imagenBanner),
            ),
            FutureBuilder<List<Categoria>>(
              future: ObtenerCAtegoria(categoria.id),
              builder: (context, data){
                if(data.hasData){
                  return Flexible(
                    child: GridView.builder(
                      itemCount: data.data.length,
                      gridDelegate: new SliverGridDelegateWithFixedCrossAxisCount(
                          crossAxisCount: 1,childAspectRatio: 3),
                      itemBuilder: (context,index){
                        return CategoriaCuadradoDetalle(url:data.data[index].imagencuadrada, id:data.data[index].toString(),detalle:data.data[index].descripcion);
                      },
                    ),
                  );
                }else if(data.hasError){
                  return Text("error");
                }
                return CircularProgressIndicator();
              },
            ),
          ],
        ),
      ),
    );
  }
}

Future<List<Categoria>> ObtenerCAtegoria(int id) async {
  final response = await http.get("https://viveyupi.com/api/categorias/padre/"+id.toString()+"/");
  if(response.statusCode == 200) {
    List<dynamic> body = jsonDecode(Utf8Decoder().convert(response.bodyBytes));
    List<Categoria> datos = body.map((json) => Categoria.fromJson(json)).toList();
    return datos;
  }else{
    throw Exception("error cargando la categoria");
  }
}