import 'package:ws_dart/class_animal.dart';
import 'package:ws_dart/class_cat.dart';
import 'package:ws_dart/class_dog.dart';
import 'package:ws_dart/class_tiger.dart';

void main() {
  Animal animal = new Animal();

  Cat cat = new Cat();
  Dog dog = new Dog();
  Tiger tiger = new Tiger();

  animal.cryInfo(cat);
  animal.cryInfo(dog);
  animal.cryInfo(tiger);
}
