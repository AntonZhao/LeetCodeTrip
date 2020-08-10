public class Singleton {
    private Singleton() {}

    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    private static class LazyHolder{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance2() {
        return LazyHolder.instance;
    }

    public static void main(String[] args) {
        SingletonEnum instance = SingletonEnum.INSTANCE;
    }
}

enum SingletonEnum {
    INSTANCE(1, "anton"),
    LALA(2, "lxlx");

    private Integer id;
    private String name;

    SingletonEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
