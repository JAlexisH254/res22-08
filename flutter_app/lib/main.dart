import 'package:english_words/english_words.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  Widget cuerpo = Container(
    padding: EdgeInsets.all(30),
    child: Row(
     children:<Widget>[
       Expanded(
         child: Column(
           children: <Widget>[
             Text("Tituto",
               style: TextStyle(
                 fontSize: 13,
                 fontWeight: FontWeight.bold
               )),
             Text("Subtitulo"),
           ],
         ),
       ),
       Icon(
         Icons.star
       ),
     ],
    ),
  );

  @override
  Widget build(BuildContext context) {
    var palabra = WordPair.random();
    return MaterialApp(
      title: "mi primera pagina",
      home: Scaffold(
        appBar: AppBar(
          title: Text("Prueba fluter"),
        ),
        body: cuerpo,
      ),
    );
  }
}

