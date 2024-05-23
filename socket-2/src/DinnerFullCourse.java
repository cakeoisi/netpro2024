public class DinnerFullCourse {

    private Dish[] list = new Dish[5]; // [0]-[4]の計5個

    public static void main(String[] args) {
        DinnerFullCourse fullcourse = new DinnerFullCourse();
        fullcourse.eatAll();
    }

    public DinnerFullCourse() {
        list[0] = new Dish("特選シーザサラダ", 10);
        list[1] = new Dish("銀しゃり", 20);
        list[2] = new Dish("梅干し", 50);
        list[3] = new Dish("冷めた感じ特選風スープ", 1);
        list[4] = new Dish("締めとしての銀しゃりのお茶漬け", 20);
    }

    public void eatAll() {
        for (Dish dish : list) {
            System.out.println("料理名: " + dish.getName() + ", 値段: " + dish.getValue() + "円");
        }
    }

    class Dish {
        private String name;
        private int value;

        public Dish(String name, int value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
