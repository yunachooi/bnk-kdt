typedef Operation = void Function(int x, int y);

void main() {
  for (int i = 0; i < 3; i++) {
    print(i);
  }
  List<int> numList = [3, 6, 9];
  for (int n in numList) {
    print(n);
  }

  int total = 0;
  while (total < 10) {
    total += 1;
  }
  print(total);

  int total2 = 0;
  do {
    total2 += 1;
  } while (total2 < 10);
  print(total2);

  print(addTwoNumbers(1, 2));
  print(addTwoNumbers2(a: 1, b: 2));
  print(addTwoNumbers3(a: 3));
  print(addTwoNumbers4(1, b: 2));

  add(1, 2);
  subtract(1, 2);
  Operation oper = add;
  oper = subtract;
  oper(1, 2);
}

/*
 * 포지셔닝 파라미터 : 순서 중요
 * */
int addTwoNumbers(int a, int b) {
  return a + b;
}

int addTwoNumbers2({required int a, required int b}) {
  return a + b;
}

int addTwoNumbers3({required int a, int b = 2}) {
  return a + b;
}

int addTwoNumbers4(int a, {required int b, int c = 4}) {
  return a + b + c;
}

void add(int x, int y) {
  print('결과 : ${x + y}');
}

void subtract(int x, int y) {
  print('결과 : ${x - y}');
}
