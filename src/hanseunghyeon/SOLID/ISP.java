package hanseunghyeon.SOLID;

class Client {
    public static void main(String[] args) throws Exception {
        int firNum = 140;
        int secNum = 60;

        // 연산 결과만 출력
        DisplayTypeA displayTypeA = new DisplayTypeA();
        displayTypeA.displayResult(new AddOperation(), firNum, secNum);
        // displayTypeA.displayResultWithOperator(new AddOperation(), firNum, secNum); // Error 발생

        // 연산 과정까지 출력
        DisplayTypeB displayTypeB = new DisplayTypeB();
        displayTypeB.displayResultWithOperator(new AddOperation(), firNum, secNum);
        // displayTypeB.displayResult(new AddOperation(), firNum, secNum); // Error 발생
    }
}

class Calculator {
    public int calculate(AbstractOperation operation, int firstNumber, int secondNumber){
        return operation.operate(firstNumber, secondNumber);
    }
}

abstract class AbstractOperation {
    public abstract int operate(int firstNumber, int secondNumber);
    public abstract String getOperator();
}

interface DisplayResult {
    public abstract void displayResult(AbstractOperation operation, int firstNumber, int secondNumber) throws Exception;
}

interface DisplayResultWithOperator {
    public abstract void displayResultWithOperator(AbstractOperation operation, int firstNumber, int secondNumber) throws Exception;
}

// 연산 결과만 출력
class DisplayTypeA extends Calculator implements DisplayResult {

    @Override
    public void displayResult(AbstractOperation operation, int firstNumber, int secondNumber) {
        int answer = operation.operate(firstNumber, secondNumber);
        System.out.println(answer);
    }
}

// 연산 과정을 포함한 출력
class DisplayTypeB extends Calculator implements DisplayResultWithOperator {
    @Override
    public void displayResultWithOperator(AbstractOperation operation, int firstNumber, int secondNumber) {
        int answer = operation.operate(firstNumber, secondNumber);
        String operator = operation.getOperator();
        System.out.println(firstNumber + " " + operator + " " + secondNumber + " = " + answer);
    }
}

class AddOperation extends AbstractOperation {
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

    @Override
    public String getOperator() {
        return "+";
    }
}

class SubstractOperation extends AbstractOperation {
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }

    @Override
    public String getOperator() {
        return "-";
    }
}

class MultiplyOperation extends AbstractOperation {
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }

    @Override
    public String getOperator() {
        return "*";
    }
}

class DivideOperation extends AbstractOperation {
    @Override
    public int operate(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }

    @Override
    public String getOperator() {
        return "/";
    }
}
