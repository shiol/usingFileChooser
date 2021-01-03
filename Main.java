class Main {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Hello World");
    Frame frame = new Frame();
    frame.setVisible(true);
    while (frame.currentDirectory == "") {
      Thread.sleep(1000);
    }
    frame.setVisible(false);
    System.exit(0);
  }
}