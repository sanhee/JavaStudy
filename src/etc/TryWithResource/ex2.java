package etc.TryWithResource;

public class ex2 {

    public static void main(String[] args) {
        try (CustomResource cr = new CustomResource()) {
            System.out.println("Do something...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class CustomResource implements AutoCloseable {

        public void doSomething() {
            System.out.println("Do something...");
        }

        @Override
        public void close() throws Exception {
            System.out.println("CustomResource.close() is called");
        }
    }
}
