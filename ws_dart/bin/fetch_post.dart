import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:ws_dart/class_post.dart';

Future<void> sendPost(Post post) async {
  final url = Uri.parse('http://localhost:8090/api/post');
  print("다트: post 데이터 전송 시작...");
  print("다트: 전송할 Post 객체 : $post");

  try {
    final Map<String, dynamic> postJsonMap = post.toJson();
    final String requestBody = jsonEncode(postJsonMap);
    final response = await http.post(
      url,
      headers: <String, String>{'Content-Type': 'application/json'},
      body: requestBody,
    );
    if (response.statusCode == 201 || response.statusCode == 200) {
      print("다트 : 데이터 전송 성공! 상태 코드 : ${response.statusCode}");
      print("서버 응답 본문 : ${response.body}");

      Map<String, dynamic> responseJson = jsonDecode(response.body);
      print('서버 응답(Json) : $responseJson');
    } else {
      print('다트: 데이터 전송 실패 - 상태 코드 : ${response.statusCode}');
      print('서버 응답 본문 : ${response.body}');
    }
  } catch (e) {
    print('다트: 전송 중 오류 발생 : $e');
  }
  print('다트: Post 데이터 전송 완료...');
}

void main() async {
  final post = Post(pno: 101, title: 'New Post...', body: 'New Post Body...');
  await sendPost(post);
}
