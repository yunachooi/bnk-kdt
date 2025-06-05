void f(int n1, [int n2 = 0]) {
  print('n1 + n2 = ${n1 + n2}');
}

void f2(int a, {required int b, int c = 10}) {
  print('a + b + c = ${a + b + c}');
}

void printUserInfo(String name, {required int age, String gender = 'unknown'}) {
  print('name = $name, age = $age, gender = $gender');
}

void add(int a, int b) {
  print('a + b = ${a + b}');
}

void minus(int a, int b) {
  print('a - b = ${a - b}');
}

void div(int a, int b) {
  if (b == 0) {
    print('0으로 나눌 수 없습니다.');
  } else {
    print('a / b = ${a / b}');
  }
}

void mul(int a, int b) {
  print('a * b = ${a * b}');
}

void printEvenNumber(int num) {
  print("$num is Even Number.");
}

void printOddNumber(int num) {
  print('$num is Odd Number.');
}

void printNumber(Function func, int num) {
  func(num);
}

int? stringLength(String? s) {
  return s?.length; //NULL 조건부 멤버 접근 연산자
}

void main() {
  f(1, 2);
  f(1);
  f2(1, b: 2, c: 3);
  printUserInfo('홍길동', age: 18, gender: 'M');

  List<Function> list = [add, minus, div, mul];
  for (int i = 0; i < list.length; i++) {
    list[i](1, 2);
  }

  int num;
  Function func;
  num = 3;
  func = num.isEven ? printEvenNumber : printOddNumber;
  printNumber(func, num);

  String? nullAbleString;
  //nullAbleString != null ? nullAbleString : 'aaa'
  print(nullAbleString ?? 'aaa');
  //nullAbleString = nullAbleString != null ? nullAbleString : 'bbb';
  nullAbleString ??= 'bbb';
}
