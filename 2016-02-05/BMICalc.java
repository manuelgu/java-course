import java.util.Scanner;

public class BMICalc {
  private static Scanner s;
  private static double weight, height, result;
  
  public static void main(String[] args) {
    s = new Scanner(System.in);
    
    System.out.println("Please enter your weight");
    weight = s.nextInt();
    System.out.println("Please enter your height");
    height = s.nextInt();
    
    // BMI formula (weight / height * height)
    result = getBMI(weight, height);
    
    System.out.printf("%n Your weight: " + weight);
    System.out.printf("%n Your height: " + height);
    System.out.printf("%n Your BMI is " + Math.round(result) + ".");
  }
  
  private static double getBMI(double weight, double height) {
    return (weight / (height * height)) * 10000;
  }
}
