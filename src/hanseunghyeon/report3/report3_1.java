package hanseunghyeon.report3;
import java.util.*;

//4-1. 다음의 문장들을 조건식으로 표현해보세요.

// int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
// 10 < x && x < 20
// char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식
// !(ch == ' ' || ch == '\t')
// char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식
// ch == 'x' || ch == 'X'
// char형 변수 ch가 숫자('0'~'9')일 때 true인 조건식
// '0' <= ch && ch <= '9'
// char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
// 'a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z'
// int형 변수 year가 400으로 나눠떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지 않을때 true인 조건식
// vear % 400 == 0 || vear % 4 == 0 && vear % 100 != 0
// boolean형 변수 powerOn이 false일 때 true인 조건식
// !powerOn
// 문자열 참조변수 str이 "yes"일 때 true인 조건식
// str.equals("str")

//4-2. 1부터 20까지의 정수중에서 2 또는 3의 배수가 아닌 수의 총합을 구하세요.
class Exercise4_2 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i < 21; i++) {
            if(!(i % 2 == 0 || i % 3 == 0))
                sum += i;
        }
        System.out.println("sum="+sum);
    }
}



//4-3. 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)의 결과를 계산하세요.
class Exercise4_3 {
    public static void main(String[] args) {
        int sum = 0;
        int totalSum = 0;
        for (int i = 1; i < 11; i++) {
            sum += i;
            totalSum += sum;
        }
        System.out.println("totalSum="+totalSum);
    }
}



//4-4. 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때,
//몇까지 더해야 총합이 100 이상이 되는지 구하세요.
class Exercise4_4 {
    public static void main(String[] args) {
        int sum = 0; // 총합을 저장할 변수
        int s = -1; // 값의 부호를 바꿔주는데 사용할 변수
        int num = 0;

        while(sum < 100){
            num++;
            num = num % 2 == 0 ? num * s : num;
            sum += num;
            num = num < 0 ? num * s : num;
        }

        System.out.println("num="+num);
        System.out.println("sum="+sum);
    }
}



//4-5. 다음의 for문을 while문으로 변경하세요.
class Exercise4_5 {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        while(i<=10){
            while(j<=i){
                System.out.print('*');
                j++;
            }
            System.out.println(" ");
            j = 0;
            i++;
        }
    }//end of main
} // end of class



//4-6. 두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수를 출력하는 프로그램을 작성하세요.
class Exercise4_6 {
    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            for (int j = 1; j < 6; j++) {
                if(i + j == 6)
                    System.out.println("["+i+","+j+"]");
            }
        }
    }
}



//4-7. 숫자로 이루어진 문자열 str이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하세요.
//만일 문자열이 "12345"라면, ‘1+2+3+4+5’의 결과인 15를 출력이 출력되어야 합니다.
class Exercise4_7 {
    public static void main(String[] args) {
        String str = "12345";
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        System.out.println("sum=" + sum);
    }
}//예상 결과 : sum=15



//4-8. Math.random()을 이용해서 1부터 6 사이의 임의의 정수를 변수 value에 저장하는 코드를 완성하세요.
class Exercise4_8{
    public static void main(String[] args){
        int value = (int)(Math.random()*5)+1;
        System.out.println("value:"+value);
    }
}



//4-9. int 타입의 변수 num이 있을 때, 각 자리의 합을 더한 결과를 출력하는 코드를 완성하세요.
//만일 변수 num의 값이 12345라면, ‘1+2+3+4+5’의 결과인 15를 출력하세요.
//문자열로 변환하지 말고 숫자로만 처리하세요.
class Exercise4_9 {
    public static void main(String[] args) {
        int num = 12345;
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        System.out.println("sum="+sum);
    }
}//예상 결과 : sum=15



//4-10. 다음은 숫자맞추기 게임을 작성한 것이다. 1과 100사이의 값을 반복적으로 입력해서
//컴퓨터가 생각한 값을 맞추면 게임이 끝난다.
//사용자가 값을 입력하면, 컴퓨터는 자신이 생각한 값과 비교해서 결과를 알려준다.
//사용자가 컴퓨터가 생각한 숫자를 맞추면 게임이 끝나고 몇 번 만에 숫자를 맞췄는지 알려준다.

class Exercise4_14 {
    public static void main(String[] args) {
        // 1~100사이의 임의의 값을 얻어서  answer에 저장한다.
        int answer = (int)(Math.random()*100)+1;
        int input = 0; //사용자입력을 저장할 공간
        int count = 0; //시도횟수를 세기위한 변수

        // 화면으로 부터 사용자입력을 받기 위해서 Scanner클래스 사용
        java.util.Scanner s = new java.util.Scanner(System.in);
        do {
            count++;
            System.out.print("1과 100사이의 값을 입력하세요 : ");
            input = s.nextInt(); //입력받은 값을 변수 input에 저장한다.
            if (input > answer)
                System.out.println("더 작은 수를 입력하세요.");
            else if (input < answer)
                System.out.println("더 큰 수를 입력하세요.");
            else{
                System.out.println("맞혔습니다.");
                System.out.println("시도 횟수는 "+count+"번 입니다.");
                break;
            }
        } while(true); //무한반복문
    } // end of main
} // end of class

//예상 결과
//1과 100사이의 값을 입력하세요 : 50
//더 큰 수를 입력하세요.
//1과 100사이의 값을 입력하세요 : 75
//더 큰 수를 입력하세요.
//1과 100사이의 값을 입력하세요 : 87
//더 작은 수를 입력하세요.
//1과 100사이의 값을 입력하세요 : 80
//더 작은 수를 입력하세요.
//1과 100사이의 값을 입력하세요 : 77
//더 작은 수를 입력하세요.
//1과 100사이의 값을 입력하세요 : 76
//맞혔습니다.
//시도횟수는 6번입니다.