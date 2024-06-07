### Java Stream API Notes

#### Introduction
- **Stream API**: Introduced in Java 8, the Stream API is used to process sequences of elements (e.g., collections) in a functional and declarative manner.
- **Purpose**: Simplifies bulk operations on collections like filtering, mapping, and reducing, using a fluent and readable syntax.

#### Key Concepts
- **Stream**: A sequence of elements supporting sequential and parallel aggregate operations.
- **Pipeline**: A series of operations that transform a stream. It consists of a source, zero or more intermediate operations, and a terminal operation.

#### Stream Creation
Streams can be created from various data sources:
- **Collection**: `List<String> list = Arrays.asList("a", "b", "c"); Stream<String> stream = list.stream();`
- **Arrays**: `Stream<int[]> stream = Arrays.stream(new int[]{1, 2, 3});`
- **Static methods**: `Stream<String> stream = Stream.of("a", "b", "c");`
- **Files**: `Stream<String> lines = Files.lines(Paths.get("file.txt"));`

#### Types of Operations
- **Intermediate Operations**: Transform a stream into another stream. They are lazy and do not execute until a terminal operation is invoked.
  - Examples: `filter()`, `map()`, `flatMap()`, `distinct()`, `sorted()`, `limit()`, `skip()`
- **Terminal Operations**: Produce a result or a side-effect and terminate the stream.
  - Examples: `forEach()`, `collect()`, `reduce()`, `count()`, `anyMatch()`, `allMatch()`, `noneMatch()`, `findFirst()`, `findAny()`

#### Common Intermediate Operations
- **filter()**: Filters elements based on a predicate.
  ```java
  List<String> filtered = list.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
  ```
- **map()**: Transforms each element using a function.
  ```java
  List<Integer> lengths = list.stream().map(String::length).collect(Collectors.toList());
  ```
- **flatMap()**: Flattens nested structures.
  ```java
  List<String> flatMapped = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
  ```
- **distinct()**: Removes duplicate elements.
  ```java
  List<Integer> distinctElements = list.stream().distinct().collect(Collectors.toList());
  ```
- **sorted()**: Sorts elements.
  ```java
  List<String> sortedList = list.stream().sorted().collect(Collectors.toList());
  ```
- **limit()**: Limits the number of elements.
  ```java
  List<String> limited = list.stream().limit(2).collect(Collectors.toList());
  ```
- **skip()**: Skips the first N elements.
  ```java
  List<String> skipped = list.stream().skip(2).collect(Collectors.toList());
  ```

#### Common Terminal Operations
- **forEach()**: Applies an action to each element.
  ```java
  list.stream().forEach(System.out::println);
  ```
- **collect()**: Converts the stream to a collection or another data structure.
  ```java
  List<String> collected = list.stream().collect(Collectors.toList());
  ```
- **reduce()**: Combines elements to produce a single result.
  ```java
  Optional<String> concatenated = list.stream().reduce((s1, s2) -> s1 + s2);
  ```
- **count()**: Counts the number of elements.
  ```java
  long count = list.stream().count();
  ```
- **anyMatch()**: Checks if any element matches a predicate.
  ```java
  boolean anyMatch = list.stream().anyMatch(s -> s.startsWith("a"));
  ```
- **allMatch()**: Checks if all elements match a predicate.
  ```java
  boolean allMatch = list.stream().allMatch(s -> s.length() > 2);
  ```
- **noneMatch()**: Checks if no elements match a predicate.
  ```java
  boolean noneMatch = list.stream().noneMatch(s -> s.isEmpty());
  ```
- **findFirst()**: Finds the first element.
  ```java
  Optional<String> first = list.stream().findFirst();
  ```
- **findAny()**: Finds any element (useful in parallel streams).
  ```java
  Optional<String> any = list.stream().findAny();
  ```

#### Parallel Streams
- **Parallel Processing**: Stream API can process elements in parallel to leverage multi-core processors.
  ```java
  List<String> parallelList = list.parallelStream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
  ```

#### Collectors Utility
- **toList()**: Collects elements into a `List`.
  ```java
  List<String> collectedList = list.stream().collect(Collectors.toList());
  ```
- **toSet()**: Collects elements into a `Set`.
  ```java
  Set<String> collectedSet = list.stream().collect(Collectors.toSet());
  ```
- **toMap()**: Collects elements into a `Map`.
  ```java
  Map<String, Integer> map = list.stream().collect(Collectors.toMap(Function.identity(), String::length));
  ```
- **joining()**: Concatenates elements into a single `String`.
  ```java
  String joined = list.stream().collect(Collectors.joining(", "));
  ```
- **groupingBy()**: Groups elements by a classifier function.
  ```java
  Map<Integer, List<String>> groupedByLength = list.stream().collect(Collectors.groupingBy(String::length));
  ```
- **partitioningBy()**: Partitions elements by a predicate.
  ```java
  Map<Boolean, List<String>> partitioned = list.stream().collect(Collectors.partitioningBy(s -> s.length() > 2));
  ```

#### Examples
- **Filtering and Mapping**
  ```java
  List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
  List<String> result = names.stream()
                             .filter(name -> name.startsWith("A"))
                             .map(String::toUpperCase)
                             .collect(Collectors.toList());
  // Output: [ALICE]
  ```
- **Reducing**
  ```java
  List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
  int sum = numbers.stream().reduce(0, Integer::sum);
  // Output: 15
  ```

### Conclusion
The Stream API in Java enhances the ability to perform complex data manipulations and transformations in a concise and readable manner. It supports functional programming paradigms and is a powerful tool for developers to handle collections efficiently.
