package designpattern.FactoryMethod;

public abstract class Operation {
    private double numberA = 0;
    private double numberB = 0;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }

    public abstract double getResult();
}


class OperationAdd extends Operation {
    @Override
    public double getResult() {
        return getNumberA() + getNumberB();
    }
}

class OperationSub extends Operation {
    @Override
    public double getResult() {
        return getNumberA() - getNumberB();
    }
}

class OperationMul extends Operation {
    @Override
    public double getResult() {
        return getNumberA() * getNumberB();
    }
}

class OperationDiv extends Operation {
    @Override
    public double getResult() {
        if (getNumberB() == 0) {
            throw new ArithmeticException("除是不能為0");
        }
        return getNumberA() / getNumberB();
    }
}

class OperationSqr extends Operation {
    @Override
    public double getResult() {
        return getNumberB() * getNumberB();
    }
}

class OperationFactory {
    public static Operation createOperate(String operate) {
        switch (operate) {
            case "+":
                return new OperationAdd();
            case "-":
                return new OperationSub();
            case "*":
                return new OperationMul();
            case "/":
                return new OperationDiv();
            case "sqr":
                return new OperationSqr();
            default:
                throw new IllegalArgumentException("無效運算符號：" + operate);
        }
    }
}
