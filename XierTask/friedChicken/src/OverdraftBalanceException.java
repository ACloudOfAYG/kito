public class OverdraftBalanceException extends RuntimeException{

    public OverdraftBalanceException(){}

    //构造函数
    public OverdraftBalanceException(String message){
        super(message);
    }

}
