class Post {
  final int pno;
  final String title;
  final String body;

  Post({required this.pno, required this.title, required this.body});
  factory Post.fromJson(Map<String, dynamic> json) {
    return Post(
      pno: json['pno'] as int? ?? 0,
      title: json['title'] as String? ?? 'blank',
      body: json['body'] as String? ?? 'blank',
    );
  }

  Map<String, dynamic> toJson() {
    return {'pno': pno, 'title': title, 'body': body};
  }
}
