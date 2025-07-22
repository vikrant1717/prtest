public class NewClass {

    public void exampleMethod() {
        String insecure = new String(new char[] {'s', 'e', 'c', 'r', 'e', 't'}); // Insecure string construction
    }
}