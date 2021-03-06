package com.jkramr.java10cycles.archive.interview;


import java.io.ByteArrayInputStream;
import java.util.Scanner;

class _EmptySolution {
  public static void main(String[] args) {
    _EmptySolution algorithm = new _EmptySolution();

    mockInput();
    //read from STDIN
    Input input = readFromSTDIN();

    System.out.println(algorithm.solution(input));
  }

  private static void mockInput() {
    String lines =
            "5 5 5" + "\n" +
            "1 1" + "\n" +
            "1 2" + "\n" +
            "1 3" + "\n" +
            "1 4" + "\n" +
            "1 5" + "\n" +
            "1 2 10" + "\n" +
            "1 3 10" + "\n" +
            "2 4 10" + "\n" +
            "3 5 10" + "\n" +
            "4 5 10" + "\n";

    ByteArrayInputStream in = new ByteArrayInputStream(lines.getBytes());
    System.setIn(in);
  }

  private static Input readFromSTDIN() {
    Scanner inputScanner = new Scanner(System.in);

    String[] firstLine = inputScanner.nextLine().split(" ");

    int inputCount = Integer.parseInt(firstLine[0]);

    String[] lines = new String[inputCount];

    for (int i = 0; i < inputCount; i++) {
      lines[i] = inputScanner.nextLine();
    }

    return new Input(lines);
  }

  public Output solution(Input input) {
    return null;
  }

  private static class Input {
    private String[] lines;

    public Input(String[] lines) {
      this.lines = lines;
    }
  }

  private class Output {

    int value;

    @Override
    public String toString() {
      return "" + value;
    }
  }
}
