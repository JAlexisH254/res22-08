import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  // This widget is the root of your application.

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: ListaDinamica(),
    );
  }
}

class ListaDinamica extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return ListaDinamicaState();
  }
}

class ListaDinamicaState extends State<ListaDinamica>{
  List<String> datos = ["PRIMERO","SEGUNDO","3","4"];
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: <Widget>[
          TextField(
            onSubmitted: (texto){
              datos.add(texto);
              setState(() {});
            }
          ),
          Expanded(
            child: ListView.builder(
                itemCount: datos.length,
                itemBuilder:(BuildContext context, int index){
                  return ListTile(
                    title: Text(datos[index])
                  );
                },
            ),
          ),
        ],
      ),
    );
  }

}

