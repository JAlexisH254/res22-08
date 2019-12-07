import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: PrimeraPantalla(),
      routes: {
        "/segunda": (context) => SegundaPantalla(),
      },
    );
  }
}

class PrimeraPantalla extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: RaisedButton(
          child: Text("Tocame"),
            onPressed: (){
              Navigator.pushNamed(context, "/segunda");
            }
        ),
      ),
    );
  }
}

class SegundaPantalla extends StatelessWidget{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: RaisedButton(
          child: Text("no me toquea"),
            onPressed: (){
              Navigator.pop(context);
            }
        ),
      ),
    );
  }
}

