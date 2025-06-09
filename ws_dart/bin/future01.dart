void main() async {
  Future<String> s = Future.value('hello');
  print(s);
  s.then((value) => print(value));

  Future<String> name = Future.value('James');
  String result = await name;
  print(result);

  String name2 = await Future.value('Ann');
  print(name2);

  printName(Future.value('Tom'));

  //fetchString함수 실행 후 Jerry 출력하기
  String result2 = await fetchString();
  print(result2);

  String result3 = await fetchString2();
  print(result3);
}

void printName(Future<String> name) async {
  String x = await name;
  print(x);
}

Future<String> fetchString() {
  return Future.value('Jerry');
}

Future<String> fetchString2() {
  return Future.delayed(Duration(seconds: 2), () => "hello~~"); //js: set Time
}
