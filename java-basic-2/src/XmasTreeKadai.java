public class XmasTreeKadai {
    public static void main(String[] args) {
        System.out.println("Setting 1:");
        createChristmasTree(19, 3, 7);

    }


    public static void createChristmasTree(int leafWidth, int trunkWidth, int trunkHeight) {
        
        for (int i = 0; i < leafWidth; i++) {
            
            for (int j = 0; j < leafWidth - i - 1; j++) {
                System.out.print(" ");
            }
            //葉
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 幹
        int trunkPadding = (2 * leafWidth - trunkWidth) / 2;
        for (int i = 0; i < trunkHeight; i++) {
            for (int j = 0; j < trunkPadding; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < trunkWidth; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
