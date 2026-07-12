import java.util.Scanner;
public class RemoveSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("enter employee name: ");
//        String emp_name=sc.nextLine();
//        1st question answer
//        System.out.println("1st answer:"+ emp_name.trim());
//        2nd question answer
//        System.out.println("Enter email: ");
//        String email=sc.nextLine();
//        System.out.println("2nd answer:"+email.toLowerCase());
        //3rd question answer
//        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
//        if(email.matches(regex)) {
//            System.out.println("Valid");
//        }
        //4TH QUESTION ANSWER
//        System.out.println("enter employee id: ");
//        String eid=sc.nextLine();
//        String ex="^EMP-[0-9]{4}$";
//        if(eid.matches(ex)){
//            System.out.println("valid");
//        }
        //5th question answer
//        System.out.println("Enter employee name:");
//        String name = sc.nextLine();
//
//        String username = name.toLowerCase().replace(" ", ".");
//        System.out.println(username);
//
//
//        //6th question answer
//        String[] words = name.trim().split("\\s+");
//        System.out.println(words.length);
//
//
//        //7th question answer
//        System.out.println("Enter password:");
//        String password = sc.nextLine();
//
//        String passRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$";
//
//        if(password.matches(passRegex))
//            System.out.println("Strong");
//        else
//            System.out.println("Weak");
//
//
//        //8th question answer
//        System.out.println("Enter email:");
//        String email = sc.nextLine();
//
//        int index = email.indexOf("@");
//
//        String masked = email.substring(0,2) + "********" + email.substring(index);
//
//        System.out.println(masked);
//
//
//        //9th question answer
//        System.out.println("Enter emails separated by comma:");
//        String emailList = sc.nextLine();
//
//        String[] emails = emailList.split(",");
//
//        boolean duplicate = false;
//
//        for(int i=0;i<emails.length;i++){
//            for(int j=i+1;j<emails.length;j++){
//
//                if(emails[i].equals(emails[j])){
//                    System.out.println("Duplicate: " + emails[i]);
//                    duplicate = true;
//                    break;
//                }
//            }
//        }
//
//        if(!duplicate)
//            System.out.println("No Duplicate");
//
//
//        //10th question answer
//        int pos = email.indexOf("@");
//
//        System.out.println(email.substring(pos+1));
//
//
//        //11th question answer
//        int vowelCount = 0;
//
//        String temp = name.toLowerCase();
//
//        for(int i=0;i<temp.length();i++){
//
//            char ch = temp.charAt(i);
//
//            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
//                vowelCount++;
//        }
//
//        System.out.println(vowelCount);
//
//
//        //12th question answer
//
//        System.out.println("Enter string:");
//        String str = sc.nextLine();
//
//        int upper = 0;
//        int lower = 0;
//        int digit = 0;
//        int special = 0;
//
//
//        for(int i=0;i<str.length();i++){
//
//            char ch = str.charAt(i);
//
//            if(Character.isUpperCase(ch))
//                upper++;
//
//            else if(Character.isLowerCase(ch))
//                lower++;
//
//            else if(Character.isDigit(ch))
//                digit++;
//
//            else
//                special++;
//        }
//
//
//        System.out.println("Uppercase="+upper+
//                ", Lowercase="+lower+
//                ", Digits="+digit+
//                ", Special="+special);
//
//
//
//        //13th question answer
//
//        String reverse = "";
//
//        for(int i=name.length()-1;i>=0;i--){
//
//            reverse += name.charAt(i);
//
//        }
//
//        System.out.println(reverse);
//
//
//
//        //14th question answer
//
//        System.out.println("Enter word:");
//
//        String word = sc.nextLine();
//
//        String rev = "";
//
//        for(int i=word.length()-1;i>=0;i--){
//
//            rev += word.charAt(i);
//
//        }
//
//
//        if(word.equalsIgnoreCase(rev))
//            System.out.println("Palindrome");
//        else
//            System.out.println("Not Palindrome");
//
//
//
//        //15th question answer
//
//        System.out.println("Enter string:");
//
//        String str1 = sc.nextLine();
//
//        for(int i=0;i<str1.length();i++){
//
//            int count = 0;
//
//            for(int j=0;j<str1.length();j++){
//
//                if(str1.charAt(i)==str1.charAt(j))
//                    count++;
//
//            }
//
//            if(count==1){
//
//                System.out.println(str1.charAt(i));
//                break;
//
//            }
//        }
//
//
//
//        //16th question answer
//
//        String input = "programming";
//
//        int max = 0;
//        char result = ' ';
//
//
//        for(int i=0;i<input.length();i++){
//
//            int count=0;
//
//            for(int j=0;j<input.length();j++){
//
//                if(input.charAt(i)==input.charAt(j))
//                    count++;
//
//            }
//
//            if(count>max){
//
//                max=count;
//                result=input.charAt(i);
//
//            }
//
//        }
//
//        System.out.println(result);
//
//
//
//        //17th question answer
//
//        System.out.println(name.replace(" ","_"));
//
//
//
//        //18th question answer
//
//        String s1 = "Java";
//        String s2 = new String("Java");
//
//
//        System.out.println("equals() = " + s1.equals(s2)
//                + ", == = " + (s1==s2));
//
//
//
//        //19th question answer - Sort names
//
//        String names = "John,Alice,David";
//
//        String[] arr = names.split(",");
//
//
//        for(int i=0;i<arr.length;i++){
//
//            for(int j=i+1;j<arr.length;j++){
//
//                if(arr[i].compareTo(arr[j])>0){
//
//                    String t = arr[i];
//                    arr[i]=arr[j];
//                    arr[j]=t;
//
//                }
//
//            }
//
//        }
//
//
//        for(int i=0;i<arr.length;i++){
//
//            System.out.print(arr[i]);
//
//            if(i<arr.length-1)
//                System.out.print(", ");
//
//        }
//
//
//
//        //20th question answer
//
//        String empName = "John Smith";
//        String empId = "EMP-1023";
//
//
//        String[] parts = empName.split(" ");
//
//        String code = "";
//
//        for(int i=0;i<parts.length;i++){
//
//            code += parts[i].charAt(0);
//
//        }
//
//
//        code = code.toUpperCase();
//
//        String number = empId.substring(empId.indexOf("-")+1);
//
//
//        System.out.println("\n"+code+number);
//    }
//}
