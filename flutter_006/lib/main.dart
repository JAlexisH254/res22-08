import 'package:flutter/material.dart';
import 'package:flutter_006/Routes/detalle.dart';
import 'package:flutter_006/Routes/home.dart' as prefix0;


void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: prefix0.home(),
      routes: {
        '/detalle':(context)=> detalle(),
      },
    );
  }
}