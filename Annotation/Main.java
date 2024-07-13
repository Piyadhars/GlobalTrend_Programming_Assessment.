public class Main{
    @LogExecution
    public void myMethod() {
        System.out.println("Done");
    }


    public static void main(String[] args) {
        Main myClass = new Main();
        LogExecutionTime processor = new LogExecutionTime();
        processor.process(myClass);
    }
}
