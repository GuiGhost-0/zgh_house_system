package example;

public class SingleTon {
    private SingleTon(){};

    private static SingleTon singleTon = null;

    public static SingleTon getInstance(){
        if(singleTon == null){
            singleTon = new SingleTon();
        }
        return singleTon;
    }

    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        SingleTon singleTon1 = SingleTon.getInstance();

        System.out.println(singleTon == singleTon1);
    }
}
