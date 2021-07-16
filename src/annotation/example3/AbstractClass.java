package annotation.example3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AbstractClass {

    public AbstractClass() {

        for (Method method : AnnotationExample2.class.getDeclaredMethods()) {
            // AutoExecute 어노테이션을 취득
            AutoExecute anno = method.getDeclaredAnnotation(AutoExecute.class);

            if (anno != null) {
                // 접근 제어자 무시
                method.setAccessible(true);
                // 함수 실행
                try {
                    method.invoke(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }

        }

    }

}
