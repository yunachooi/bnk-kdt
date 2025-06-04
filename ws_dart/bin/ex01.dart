void main() {
  final String name = '블랙핑크';

  final DateTime now = DateTime.now();
  print(now);

  String s = 'abcd';
  print(s);
  int n = 200;
  print(n);
  double d = 3.14;
  print(d);
  bool tf = true;
  print(tf);

  List<String> blackPinkList = ['리사', '지수', '제'];
  blackPinkList[2] = '제니';
  blackPinkList.add('로제');
  print(blackPinkList);

  /*
   * where : List에 있는 값들을 순서대로 순회하면서 특정 조건에 맞는 값만 필터링하는 데 사용.
   * 매개변수의 함수를 입력해야하며, 입력된 함수는 기존 값을 하나의 매개 변수로 입력받는다.
   * 각 값 별로 true를 반환하면 값을 유지하고, false로 반환하면 값을 버린다.
   * 순회가 끝나면 유지된 값들을 기반으로 이터러블(Iterable)에 반환된다.
   * */

  final newList = blackPinkList.where((name) => name == '리사' || name == '지수');
  print(newList.toList());

  /*
   * map() : List에 있는 값들을 순서대로 순회하면서 값을 변경한다.
   * 매개변수에 함수를 입력해야 하며, 입력된 함수는 기존 값을 하나씩 매개변수로 입력받는다.
   * 반환하는 값이 현재값을 대체한다.
   * 순회가 끝나면 어터러블을 반환함.
   * */

  final newBlackPink = blackPinkList.map((name) => '블랙핑크 $name');
  print(newBlackPink);

  /*
   * reduce : 리스트를 순회하며 값을 더한다.
   * */
  final allMembers = blackPinkList.reduce(
    (value, element) => value + ',' + element,
  );
  print(allMembers);

  final allMember2 = blackPinkList.fold<int>(
    0,
    (value, element) => value + element.length,
  );
  print(allMember2);

  Map<String, String> dictionary = {
    'Harry Potter': '해리포터',
    'Ron Weasley': '론 위즐리',
    'Hermione Granger': '헤르미온느 그레인저',
  };
  print(dictionary);
  print(dictionary['Harry Potter']);

  Set<String> blackPink = {'로제', '리사', '지수', '제니', '제니'};
  print(blackPink);

  List<String> blackPink2 = ['로제', '리사', '지수', '제니', '제니'];
  print(blackPink2);
  print(Set.from(blackPink2));

  double? number1 = 1;
  print(number1);
  number1 = null;
  print(number1);

  /*
   * ?: 널을 허용하는 변수
   * ?? : 대입연산자와 같이 사용됨. NULL의 상태가 아니면 값이 삽입되지 않음(NULL 상태에서만 삽입).
   * */
  double? number2;
  print(number2);
  number2 ??= 3;
  print(number2);
  number2 ??= 4;
  print(number2);
  number2 = 5;
  print(number2);

  int num1 = 1;
  int num2 = 2;
  print(num1 > num2);
  print(num1 is int);
  print(num1 is! int);

  bool result = 12 > 10;
  print(result);

  int num3 = 2;
  if (num3 % 3 == 0) {
    print('3의 배수입니다.');
  } else if (num3 % 3 == 1) {
    print('나머지가 2입니다.');
  } else {
    print('나머지가 1입니다.');
  }

  Status status = Status.aproved;
  switch (status) {
    case Status.aproved:
      print('승인 상태입니다.');
      break;
    case Status.pending:
      print('대기 상태입니다.');
      break;
    case Status.rejected:
      print('거절 상태입니다.');
      break;
    default:
      print('알 수 없는 상태입니다.');
  }
}

enum Status { aproved, pending, rejected }
