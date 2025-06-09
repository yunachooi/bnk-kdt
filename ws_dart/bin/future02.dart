void main() async {
  //1. 응대하기
  print('주문하세요...');

  //2. Ice Coffee 주문하기
  String takeOrder = await menuOrder();
  print(takeOrder);

  //3. 조리완료
  String cookComplete = await menuComplete();
  print(cookComplete);

  //4. 전달하기
  print('여기있습니다. 맛있게 드세요.');

  //5. 종료
  print('종료');
}

Future<String> menuOrder() {
  return Future.delayed(Duration(seconds: 2), () => "Ice Coffee주세요...");
}

Future<String> menuComplete() {
  return Future.delayed(Duration(seconds: 5), () => "조리 완료...");
}
