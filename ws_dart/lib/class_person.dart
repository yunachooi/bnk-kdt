class Person {
  //late : 변수의 초기화를 지연시킴. ex) late String name;
  //_ : private
  String _name;
  int _age;

  // Person(this.name, this.age) {
  //   print('Person constructor called');
  // }

  // Person(this.name, this.age); 필수적('반드시')으로 초기화가 되어야함.

  //생성자
  Person.init() : _name = 'nobody', _age = 0;
  Person.xxx() : this(name: '홍길동', age: 32);
  Person({required String name, required int age})
    : _name = name == '' ? 'unkown' : name,
      _age = age > 0 ? age : 0;

  //getter
  String get name => _name;
  int get age => _age;

  //setter
  set name(String name) {
    if (name == '') {
      name = 'unknown';
    }
    _name = name;
  }

  set age(int age) {
    if (age < 0) {
      _age = 0;
    } else {
      _age = age;
    }
  }

  void showInfo() {
    print('name : $_name');
    print('age : $_age');
  }
}
