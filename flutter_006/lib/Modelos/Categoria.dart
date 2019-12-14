class Categoria{
  String imagencuadrada;
  String imagenBanner;
  String descripcion;
  int id;

  Categoria({this.imagencuadrada, this.id, this.imagenBanner, this.descripcion});

  factory Categoria.fromJson(Map<String, dynamic> json){
    Categoria c = Categoria(
        imagencuadrada:json["imagen_cuadrada"],
        imagenBanner:json["imagen_banner"],
        descripcion:json["descripcion"],
        id:json["id"]
    );
    return c;
  }
}