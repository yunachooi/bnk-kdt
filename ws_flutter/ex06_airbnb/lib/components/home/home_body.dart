import 'package:ex06_airbnb/components/home/home_body_banner.dart';
import 'package:ex06_airbnb/components/home/home_body_popular.dart';
import 'package:ex06_airbnb/size.dart';
import 'package:flutter/material.dart';

class HomeBody extends StatelessWidget {
  const HomeBody({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    double bodyWidth = getBodyWidth(context);
    // 1. SizedBox 위젯을 가운데 정렬하기 위해서 Align을 사용한다. Center 위젯도 가능함.
    return Align(
      child: SizedBox(
        width: bodyWidth, // 2. 화면의 70프로만 차지하게 하려고 Column의 영역을 강제시킴.
        child: Column(children: [HomeBodyBanner(), HomeBodyPopular()]),
      ),
    );
  }
}
