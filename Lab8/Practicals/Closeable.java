class FileResource implements AutoCloseable {

    public FileResource() {
        System.out.println("Resource opened");
    }

    public void read() {
        System.out.println("Reading resource...");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}

public class Closeable{

    public static void main(String[] args) {

        try (FileResource resource = new FileResource()) {

            resource.read();

            throw new RuntimeException("Something went wrong!");

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}