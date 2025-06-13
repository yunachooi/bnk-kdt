import 'package:ex04_login/components/logo.dart';
import 'package:flutter/material.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            SizedBox(height: 200),
            Logo("Care Soft"),
            SizedBox(height: 50),
            TextButton(
              onPressed: () {
                Navigator.pop(context); // 1. 화면 스택 제거
              },
              child: Text("Get Started"),
            ),
          ],
        ),
      ),
    );
  }
}
