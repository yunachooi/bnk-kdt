import 'package:intl/intl.dart';

class Person2 {
  late String name;
  late int age;
  DateTime? birth;

  Person2();

  Person2.create({required this.name, required this.age});
  Person2.onlyName({required this.name}) {
    this.age = 0;
  }
  Person2.onlyAge({required this.age}) {
    this.name = "Unknown";
  }

  Person2.full(this.name, {this.age = 20, this.birth});

  void showInfo() {
    if (this.birth == null) {
      int year = DateTime.now().year - this.age;
      this.birth = DateTime(year, 1, 1);
    }

    var birth = DateFormat(
      'yyyy/MM/dd',
    ).format(this.birth ?? DateTime(2000, 1, 1));

    print("name : $name, age : $age, birth : $birth");
  }
}
