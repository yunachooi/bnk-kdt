import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:ws_dart/class_post.dart';

Future<void> fetchGet() async {
  print('다트: 데이터 요청 시작...');
  try {
    final response = await http.get(
      Uri.parse('http://localhost:8090/api/post/1'),
    );
    if (response.statusCode == 200) {
      Map<String, dynamic> data = jsonDecode(response.body);
      final Post post = Post.fromJson(data);
      print("다트: 데이터 수신 성공 : ${data['title']}");
      print('다트: 데이터 수신 성공(수동 파싱) : ${post.title}');
    } else {
      print('다트: 요청 실패 - 상태 코드 ${response.statusCode}');
    }
  } catch (e) {
    print('다트: 오류발생...$e');
  }
  print('다트: 데이터 요청 완료...');
}

void main() {
  fetchGet();
}
