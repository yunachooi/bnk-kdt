void main() async {
  //1
  print("main(): started.");
  await Future.delayed(
    Duration(seconds: 3),
    () => print("main(): Hello, World! @ 3 seconds"),
  );
  print("main(): completed.");

  var bgJobFinished = ActivationFlag(false);

  //2
  print("main(): started.");
  doBackgroundJob(5, bgJobFinished);
  while (bgJobFinished.activated == false) {
    await Future.delayed(Duration(seconds: 1));
  }
  print("main(): completed.");

  //3
  print("main(): started.");
  var customerOrder = serveCustomer();
  print("main(): serve '$customerOrder'.");
  print("main(): completed.");

  //4
  print("main(): started.");
  var customerOrder2 = await serveCustomer();
  print("main(): serve '$customerOrder2'.");
  print("main(): completed.");
}

void doBackgroundJob(int jobTime, var jobEnd) {
  if (jobTime > 0) {
    print("doBackgroundJob(): $jobTime sec remained.");
    Future.delayed(
      Duration(seconds: 1),
      () => doBackgroundJob(jobTime - 1, jobEnd),
    );
  } else {
    print("doBackgroundJob(): finished.");
    jobEnd.activated = true;
  }
}

class ActivationFlag {
  late bool _flag;

  ActivationFlag(bool givenFlag) : _flag = givenFlag;
  bool get activated => _flag;
  set activated(bool givenFlag) => (_flag = givenFlag);
}

Future<String> serveCustomer() async {
  print("serveCustomer(): waiting for order.");
  var customerOrder = await simulateCustomerOrder();
  print("serveCustomer(): order '$customerOrder' received.");
  return customerOrder;
}

Future<String> simulateCustomerOrder() {
  return Future.delayed(Duration(seconds: 2), () => 'Ice Coffee');
}
