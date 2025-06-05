import 'package:intl/intl.dart';
import 'package:ws_dart/class_person2.dart';

class Student extends Person2 {
  late int studentId;

  Student(this.studentId, String name, int age, DateTime birth)
    : super.full(name, birth: birth, age: age);

  @override
  void showInfo() {
    if (this.birth == null) {
      int year = DateTime.now().year - this.age;
      this.birth = DateTime(year, 1, 1);
    }

    var birth = DateFormat(
      'yyyy/MM/dd',
    ).format(this.birth ?? DateTime(2000, 1, 1));

    print("studentId: $studentId, name: $name, age: $age, birth: $birth");
  }
}
