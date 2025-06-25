package chapter13;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import chapter13_vo.Student;

public class CFPTest {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
	            new Student("Alice", 85),
	            new Student("Bob", 70),
	            new Student("Charlie", 90)
	        );

	        Predicate<Student> predicate = student -> student.getScore() >= 80;

	        Function<List<Student>, Long> countFunction = list ->
	            list.stream().filter(predicate).count();

	        Consumer<List<Student>> printNamesConsumer = list ->
	            list.stream()
	                .filter(predicate)
	                .map(Student::getName)
	                .forEach(System.out::println);

	        long count = countFunction.apply(students);
	        System.out.println("80점 이상 학생 수: " + count);

	        System.out.println("80점 이상 학생");
	        printNamesConsumer.accept(students);
	}
}
