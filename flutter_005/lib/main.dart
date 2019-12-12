import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;

void main() => runApp(MyApp(post: obtenerPost()));


Future<List<Post>> obtenerPost() async{
  final response = await http.get("https://jsonplaceholder.typicode.com/posts/");
  if(response.statusCode == 200){
    List<dynamic> body = jsonDecode(response.body);
    List<Post> posts = body.map((dynamic item) => Post.fromJson(item),).toList();
    return posts;
  }else{
    throw Exception("error");
  }
}

class Post{
  int userId;
  int id;
  String title;
  String body;

  Post({this.userId, this.id, this.title, this.body});

  factory Post.fromJson(Map<String, dynamic> json){
    Post p = Post(userId: json["userId"],
        id:json["id"],
        title: json["title"],
        body: json["body"]);
    return p;
  }
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  final Future<List<Post>> post;

  const MyApp({Key key, this.post}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text("appBar                                                                                                                                                           "),
        ),
        body: Container(
          child: Center(
            child: FutureBuilder<List<Post>>(
                future: post,
                builder: (context,snapshot){
                  if(snapshot.hasData){
                    return ListView.builder(
                        itemCount: snapshot.data.length,
                        itemBuilder: (BuildContext context, int index){
                          return ListTile(
                            title: Column(
                              children: <Widget>[
                                Text(snapshot.data[index].userId.toString()),
                                Text(snapshot.data[index].id.toString()),
                                Text(snapshot.data[index].title),
                                Text(snapshot.data[index].body),
                              ],
                            ),
                          );
                        });
                    return Text(snapshot.data[0].title);
                  }else if(snapshot.hasError){
                    return Text("error");
                  }
                  return CircularProgressIndicator();
                },
          ),
        )
      ),
      drawer: Drawer(
        child: Column(
          children: <Widget>[
            UserAccountsDrawerHeader(
              accountEmail: Text("hol@cnasn.com"),
              accountName:  Text("sdcasd"),
              currentAccountPicture: CircleAvatar(
                backgroundColor:
                Theme.of(context).platform == TargetPlatform.iOS ? Colors.blue : Colors.black,
                child: Text("s",
                style: TextStyle(fontSize: 40),
                ),
              ),
            ),
            Text("hola"),
            Text("hola"),
            Text("hola"),
            Text("hola"),
          ],
        ),
      ),
    ),
    );
  }
}

