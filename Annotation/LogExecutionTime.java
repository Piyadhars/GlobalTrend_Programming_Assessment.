import java.lang.reflect.Method;

public class LogExecutionTime {

    public void process(Object object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecution.class)) {
                long startTime = System.currentTimeMillis();
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                System.out.println("Method " + method.getName() + " took " + (endTime - startTime) + " ms to execute");
            }
        }
    }
}
