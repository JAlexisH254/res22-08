

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_006/Modelos/Categoria.dart';
import 'dart:convert' show utf8;

class CategoriaCuadrado extends StatelessWidget{
  final Categoria categoria;


  const CategoriaCuadrado({Key key, this.categoria})  : super(key: key);

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
      margin: EdgeInsets.all(5),
      child: Card(
        child: InkWell(
          splashColor: Colors.pink,
          onTap: ()=> Navigator.pushNamed(context, "/detalle",arguments: categoria),

            child: Image.network(categoria.imagencuadrada),
        ),
      ),
    );
  }
}

class CategoriaCuadradoDetalle extends StatelessWidget{
  final String url;
  final String id;
  final String detalle;

  const CategoriaCuadradoDetalle({Key key, this.url, this.id, this.detalle}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
      margin: EdgeInsets.all(5),
      child: Card(
        child: InkWell(
          splashColor: Colors.pink,
          onTap: ()=> print("me toco"),

          child: Row(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              Container(width: 150,child: Image.network(url,width: 50,height: 50,)),
              Container(width: 150,child: Text(detalle,textAlign: TextAlign.center,)),
            ],
          ),
        ),
      ),
    );
  }

}