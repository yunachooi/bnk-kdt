mixin Logger {
  void log(String msg) {
    print("LOG: '$msg'");
  }
}

class FileManager with Logger {
  void saveFile(String fileName) {
    log('Saving File : $fileName');
  }

  void delete(String fileName) {
    log('Delete File : $fileName');
  }
}

void main() {
  FileManager fileManager = FileManager();
  fileManager.saveFile('text.txt');
  fileManager.delete('text.txt');
}
