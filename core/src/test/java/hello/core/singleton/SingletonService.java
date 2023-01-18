package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); //static 으로 하면 클래스 영역에 생성되므로 한 개만 존재하게 됨.

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
