package netpro2024.mid_exam.q9;

public class CalcTotalPrice {

    public static void main(String[] args) {
        Item[] books = {
                new Item("本A", 1000, false, true),
                new Item("本B", 200, true, true),
                new Item("皿", 400, true, false),
                new Item("本C", 500, false, false),
        };

        System.out.println(calcTotalPrice(books)); // 11700
    }

    public static int calcTotalPrice(Item[] items) {
        int total = 0;
        for (Item item : items) {
            int price = item.price;
            if (item.isPremier) {
                price *= 10;
            }
            if (item.isBroken) {
                price /= 2;
            }
            total += price;
        }
        return total;
    }

    public static class Item {
        public final String name;
        public final int price;
        public final boolean isBroken;
        public final boolean isPremier;

        public Item(String name, int price, boolean isBroken, boolean isPremier) {
            this.name = name;
            this.price = price;
            this.isBroken = isBroken;
            this.isPremier = isPremier;
        }
    }
}
