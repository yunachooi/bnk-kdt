import 'dart:io';

void main() async {
  List<Map<String, String>> studentList = [];
  bool running = true;
  var count = 0;

  while (running) {
    print("\n[메뉴]");
    print("1: 성적 관리");
    print("2: 전체 성적 조회");
    print("3: 파일로 저장");
    print("0: 종료");
    stdout.write("메뉴 번호를 입력하세요: ");
    var menuInput = stdin.readLineSync();

    switch (menuInput) {
      case '1':
        stdout.write("[1] 학생 이름을 입력하세요: ");
        var nameInput = stdin.readLineSync();

        stdout.write("[1] 학생 학번을 입력하세요: ");
        var numInput = stdin.readLineSync();

        stdout.write("[1] 학생 국어 성적을 입력하세요: ");
        var korInput = stdin.readLineSync();

        stdout.write("[1] 학생 수학 성적을 입력하세요: ");
        var mathInput = stdin.readLineSync();

        stdout.write("[1] 학생 영어 성적을 입력하세요: ");
        var engInput = stdin.readLineSync();

        stdout.write(
          "저장되었습니다.\n ${nameInput}(${numInput}) 학생의 성적 => 국어 : ${korInput}, 수학 : ${mathInput}, 영어 : ${engInput}\n",
        );

        studentList.add({
          '이름': nameInput ?? '',
          '학번': numInput ?? '',
          '국어': korInput ?? '',
          '수학': mathInput ?? '',
          '영어': engInput ?? '',
        });
        count++;

        break;

      case '2':
        print("\n[전체 학생 목록]");
        for (var student in studentList) {
          print(
            "${student['이름']}(${student['학번']}) 학생의 성적 => "
            "국어 : ${student['국어']}, 수학 : ${student['수학']}, 영어 : ${student['영어']}",
          );
        }
        break;

      case '3':
        var dstSink = File('studentlist.txt').openWrite();
        dstSink.write(':=> FILE ACCESSED ${DateTime.now()}\n');
        for (var student in studentList) {
          dstSink.writeln(
            "${student['이름']}(${student['학번']}) 학생의 성적 => "
            "국어 : ${student['국어']}, 수학 : ${student['수학']}, 영어 : ${student['영어']}",
          );
        }
        dstSink.write(':=> $count ITEMS CALCULATED');
        await dstSink.close();
        break;

      case '0':
        print("프로그램을 종료합니다.");
        running = false;
        break;

      default:
        print("잘못된 입력입니다. 1, 2, 3 또는 0을 입력하세요.");
        break;
    }
  }
}
