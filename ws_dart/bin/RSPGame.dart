import 'dart:math';
import 'dart:io';

var random = Random();
void main(List<String> arguments) {
  bool flag = true;
  int draw = 0;
  int win = 0;
  int lose = 0;

  while (flag) {
    int ranNum = random.nextInt(3) + 1;
    print('-----------------');
    print('가위바위보 게임');
    print('가위(1), 바위(2), 보(3) 중 하나를 고르세요...');
    int userNum = int.parse(stdin.readLineSync()!);
    if (userNum == 0) {
      flag = false;
      break;
    }
    int result = ranNum - userNum;

    if (result == 0) {
      print('무승부 입니다...');
      draw += 1;
    } else if (result == -1 || result == 2) {
      print('이겼습니다.');
      win += 1;
    } else {
      print('졌습니다.');
      lose += 1;
    }
  }
  print('-----------------');
  print('승 | 무 | 패');
  print('${win} | ${draw} | ${lose}');
}
