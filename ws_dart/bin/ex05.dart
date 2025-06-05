import 'package:ws_dart/class_person2.dart';
import 'package:ws_dart/class_student.dart';

void main() {
  var person = Person2();
  person.name = "James Dean";
  person.age = 24;

  person.showInfo();

  var person1 = Person2.create(name: 'Bruce Lee', age: 30);
  person1.showInfo();

  var person2 = Person2.onlyName(name: 'Kim');
  person2.showInfo();

  var person3 = Person2.onlyAge(age: 18);
  person3.showInfo();

  var person4 = Person2.full("hong");
  person4.showInfo();

  var student = Student(1, "Jane", 22, DateTime(2002, 3, 14));
  student.showInfo();
}
