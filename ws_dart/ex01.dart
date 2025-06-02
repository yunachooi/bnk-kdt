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
}
