mixin MyMixin {
  /*
   * Class, Interface는 아니지만 유사함.
   * 기능을 추가로 부여하고 싶을 경우 사용.
   */
  void sayHello() {
    print("Hello Mixin...");
  }
}

class MyClass with MyMixin {}

void main() {
  MyClass obj = MyClass();
  obj.sayHello();
}
