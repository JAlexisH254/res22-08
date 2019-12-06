import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  Widget ObtenerAppBar() {
    return PreferredSize(
      preferredSize: Size.fromHeight(210.0),
      child: AppBar(
        backgroundColor: Colors.cyan,
        leading: Icon(Icons.menu),
        actions: <Widget>[
          IconButton(
            icon: Icon(
              Icons.favorite_border,
              color: Colors.white,
            ),
          )
        ],
        flexibleSpace: Column(
          children: <Widget>[
            Container(
              height: 100,
            ),
            Text(
              "Trivago",
              style: TextStyle(
                  fontSize: 25,
                  fontWeight: FontWeight.bold,
                  color: Colors.white),
            ),
            Container(
              margin: EdgeInsets.fromLTRB(0, 15, 0, 0),
              width: 330,
              child: TextField(
                  style: TextStyle(
                    fontSize: 25.0,
                    color: Colors.grey,
                  ),
                  decoration: InputDecoration(
                      filled: true,
                      fillColor: Colors.white,
                      contentPadding:
                      EdgeInsets.fromLTRB(30.0, 15.0, 20.0, 15.0),
                      prefixIcon: Icon(Icons.search, color: Colors.grey),
                      hintText: "Buscar",
                      border: OutlineInputBorder(
                          borderSide:
                          BorderSide(color: Colors.white, width: 32.0),
                          borderRadius: BorderRadius.circular(50.0)),
                      focusedBorder: OutlineInputBorder(
                          borderSide:
                          BorderSide(color: Colors.white, width: 32.0),
                          borderRadius: BorderRadius.circular(50.0)))),
            ),
          ],
        ),
      ),
    );
  }

  Widget ObtenerBody(){
    return Column(
      children: <Widget>[
        Container(
          margin: EdgeInsets.all(15),
          child: Row(
            
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Container(
                height: 90,
                width: 90,
                margin: EdgeInsets.all(5),
                decoration: BoxDecoration(
                  color: Colors.pink,
                  borderRadius: BorderRadius.all(
                    Radius.circular(10)
                  ),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Icon(
                      Icons.ac_unit,
                      color: Colors.white,
                    ),
                    Text(
                      "Hotel",
                      style: TextStyle(color: Colors.white),
                    ),
                  ],
                ),
              ),
              Container(
                height: 90,
                width: 90,
                margin: EdgeInsets.all(5),
                decoration: BoxDecoration(
                  color: Colors.blue,
                  borderRadius: BorderRadius.all(
                      Radius.circular(10)
                  ),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Icon(
                      Icons.ac_unit,
                      color: Colors.white,
                    ),
                    Text(
                      "Hotel",
                      style: TextStyle(color: Colors.white),
                    ),
                  ],
                ),
              ),
              Container(
                height: 90,
                width: 90,
                margin: EdgeInsets.all(5),
                decoration: BoxDecoration(
                  color: Colors.deepOrange,
                  borderRadius: BorderRadius.all(
                      Radius.circular(10)
                  ),
                ),
                child: Column(
                  crossAxisAlignment: CrossAxisAlignment.center,
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: <Widget>[
                    Icon(
                      Icons.ac_unit,
                      color: Colors.white,
                    ),
                    Text(
                      "Hotel",
                      style: TextStyle(color: Colors.white),
                    ),
                  ],
                ),
              ),
            ],
          ),
        ),
        Container(
          width: 300,
          height: 228,
          color: Colors.white,
          child: Column(
            crossAxisAlignment:  CrossAxisAlignment.start,
            children: <Widget>[
              Image.network(
                  "https://images2.minutemediacdn.com/image/upload/c_crop,h_1191,w_2121,x_0,y_223/f_auto,q_auto,w_1100/v1555272928/shape/mentalfloss/50569-istock-486178472.jpg",
                height: 150,
              ),
              Text(
                  "Titulo",
                style: TextStyle(
                  fontWeight: FontWeight.bold,
                  fontSize: 16,
                ),
              ),
              Text("Subtitulo"),
              Row(
                children: <Widget>[
                  Icon(Icons.star,color: Colors.green,),
                  Icon(Icons.star,color: Colors.green,),
                  Icon(Icons.star,color: Colors.green,),
                  Icon(Icons.star,color: Colors.green,),
                  Icon(Icons.star,color: Colors.green,),
                  Text("(220 votos)"),
                ],
              ),
            ],

          ),
        ),
      ],
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: ObtenerAppBar(),
        body: ObtenerBody(),
      ),
    );
  }
}