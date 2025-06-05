import 'package:ws_dart/class_user.dart';
import 'package:ws_dart/class_userManager.dart';

void main() {
  UserManager userManager = UserManager();

  User user1 = User('Alice', 'alice.example.com', 25);
  User user2 = User('Bob', 'bob@example.com', 17);
  User user3 = User('Charlie', 'charlie@example.com', 32);

  userManager.addUser(user1);
  userManager.addUser(user2);
  userManager.addUser(user3);
  userManager.listUsers();

  userManager.findUserByEmail("bob@example.com");
  userManager.deleteUser("bob@example.com");
  userManager.listUsers();
}
