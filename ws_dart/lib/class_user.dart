class User {
  late String name;
  late String email;
  late int age;

  User(this.name, this.email, this.age);

  @override
  String toString() {
    return 'User(name: $name, email: $email, age: $age)';
  }
}
