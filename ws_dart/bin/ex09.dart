import 'dart:io';
import 'dart:convert';

Future<String> readFileToString(String fileName) async {
  var file = File(fileName);
  String fileContent = await file.readAsString();
  return fileContent;
}

Future<List<String>> readFileToList(String filename) async {
  Stream<String> lines = File(
    filename,
  ).openRead().transform(utf8.decoder).transform(LineSplitter());

  try {
    List<String> sList = [];
    await for (var line in lines) {
      sList.add(line);
    }
    return sList;
  } catch (e) {
    throw (e);
  }
}

void main() async {
  print("[1] File read scenario #1.");

  try {
    String fileContent = await readFileToString('src.txt');
    print(fileContent);
  } catch (e) {
    print(e);
  }

  print("[2] File read scenario #2.");
  try {
    List<String> fileContent = await readFileToList('src.txt');
    for (var fileLine in fileContent) {
      print(fileLine);
    }
  } catch (e) {
    print(e);
  }

  print("[3] File write.");

  List<String> fileContent = await readFileToList('src.txt');

  var sList = [];
  var iVar1 = 0;
  var iVar2 = 0;
  var count = 0;

  var dstSink = File('dst.txt').openWrite();
  dstSink.write(':=> FILE ACCESSED ${DateTime.now()}\n');
  for (var fileLine in fileContent) {
    sList = fileLine.split(',');
    iVar1 = int.parse(sList[0]);
    iVar2 = int.parse(sList[1]);
    print("$iVar1 x $iVar2 = ${iVar1 * iVar2}");
    dstSink.write("$iVar1 x $iVar2 = ${iVar1 * iVar2}\n");
    count++;
  }
  dstSink.write(':=> $count ITMES CALCULATED');

  dstSink.close();
}
