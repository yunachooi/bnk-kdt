import 'package:ex05_shoppingcart/constants.dart';
import 'package:flutter/material.dart';

class ProductSelectorButton extends StatelessWidget {
  final int id;
  final int selectedIconNum;
  final IconData mIcon;
  final Function changeIcon;

  const ProductSelectorButton({
    Key? key,
    required this.id,
    required this.selectedIconNum,
    required this.mIcon,
    required this.changeIcon,
  }) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 70,
      height: 70,
      decoration: BoxDecoration(
        color: id == selectedIconNum ? kAccentColor : kSecondaryColor,
        borderRadius: BorderRadius.circular(20),
      ),
      child: IconButton(
        icon: Icon(mIcon, color: Colors.black),
        onPressed: () {
          changeIcon(id);
        },
      ),
    );
  }
}
