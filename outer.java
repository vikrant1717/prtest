public class Outer {
    void method() {
        Inner ic = new Inner();// Causes generation of accessor class
    }

    public class Inner {
        private Inner() {
            int kj = 12;
            System.out.println("Hello");
            System.out.println("World");
            int unusedVariable = 123;
            System.out.println("World");
            System.out.println("bye");
            System.out.println("bye");
            System.out.println("bye");
            System.out.println("bye");
            System.out.println("bye");
            System.out.println("bye");
            System.out.println("bye");
            System.out.println("bye");
            int kj1 = 123;
        }
    }
}