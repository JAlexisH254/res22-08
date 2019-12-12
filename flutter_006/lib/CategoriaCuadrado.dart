

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class CategoriaCuadrado extends StatelessWidget{
  final String url;

  const CategoriaCuadrado({Key key, this.url}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Container(
      child: Card(
        child: InkWell(
          splashColor: Colors.pink,
          onTap: ()=> print("me toco"),
            child: Image.network(url),
        ),
      ),
    );
  }
  
}