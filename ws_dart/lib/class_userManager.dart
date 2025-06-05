import 'package:ws_dart/class_user.dart';

mixin Logger {
  void log(String msg) {
    print("LOG: $msg");
  }
}

class UserManager with Logger {
  List<User> list = [];

  // 사용자 추가
  void addUser(User user) {
    log('addUser: $user');
    list.add(user);
  }

  // 사용자 목록 출력
  void listUsers() {
    for (var user in list) {
      log('listUsers: $user');
    }
  }

  // 이메일로 사용자 찾기
  void findUserByEmail(String email) {
    for (User user in list) {
      if (user.email == email) {
        log('findUserByEmail: $user');
      }
    }
  }

  // 이메일로 사용자 삭제
  void deleteUser(String email) {
    for (User user in list) {
      if (user.email == email) {
        log('deleteUser: $user');
        list.remove(user);
        break;
      }
    }
  }
}
