import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("Titulo"),
        ),
        body: ObtenerBody(),
      ),
    );
  }
}

Widget ObtenerBody(){
  return Padding(
    padding: EdgeInsets.all(16.0),
    child: Column(
      children: <Widget>[
        Text("Hello, Flutter!"),
        RaisedButton(
          child: Text("BUTTON"),
          //onPressed: ()=> null,
          color: Colors.blue,
          elevation: 4.0,
          splashColor: Colors.yellow,
          onPressed: () {},

        ),
        TextField(
          decoration: InputDecoration(
            hintText: "Ingrese dotas",
          )
        ),
        RaisedButton(
          onPressed: () {},
          child: const Text(
              'Enabled Button',
              style: TextStyle(fontSize: 20)
          ),
        ),
        RaisedButton(
          onPressed: () {},
          textColor: Colors.white,
          padding: const EdgeInsets.all(0.0),
          child: Container(
            decoration: const BoxDecoration(
              gradient: LinearGradient(
                colors: <Color>[
                  Color(0xFF0D47A1),
                  Color(0xFF1976D2),
                  Color(0xFF42A5F5),
                ],
              ),
            ),
            padding: const EdgeInsets.all(10.0),
            child: const Text(
                'Gradient Button',
                style: TextStyle(fontSize: 20)
            ),
          ),
        ),
      ],
    ),
  );
}