mixin Validator {
  bool isValidEmail(String email) {
    return email.contains('@');
  }
}

mixin Logger {
  void log(String msg) {
    print("LOG: '$msg'");
  }
}

class UserManager with Validator, Logger {
  void createUser(String email) {
    if (isValidEmail(email) == true) {
      //email에 문제가 없으면 'Creating user with email: 이메일 주소'입력
      log('Creating user with email: $email');
    } else {
      //email에 문제가 있으면 'Invalid email: 이메일 주소'입력
      log('Invalid email: $email');
    }
  }
}

void main() {
  UserManager userManager = UserManager();
  userManager.createUser("email@email.com");
  userManager.createUser("email.com");
}
