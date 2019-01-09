import java.io.IOException;

public class test {
    public static void main(String[] args) {
        try{
            func();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void func(){
        throw new RuntimeException();
    }
}
