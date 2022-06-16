package lesson7.junit;

import com.google.common.reflect.ClassPath;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;

public class MyJUnit {

    public static void main(String[] args) throws Exception {
        customJUnit(Test.class);
        customJUnit(BeforeAll.class);
        customJUnit(AfterAll.class);
    }

    public static <T extends Annotation> void customJUnit(Class<T> annotationClass) throws Exception {
        // Достает все классы
        Set<? extends Class<?>> classes = ClassPath.from(ClassLoader.getSystemClassLoader())
                .getAllClasses()
                .stream()
                .filter(classInfo -> classInfo.getPackageName().contains("lesson7.junit"))
                .map(ClassPath.ClassInfo::load)
                .collect(Collectors.toSet());

        for (Class<?> aClass : classes) {
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                // Смотрит в метаинформации классов нет ли там @Test
                T annotation = method.getAnnotation(annotationClass);
                if (annotation != null) {
                    // Если есть, то запускает этот метод
                    method.setAccessible(true);
                    try {
                        method.invoke(aClass.getDeclaredConstructor().newInstance());
                    } catch (Throwable t) {
                        // Если метод выбросил исключение с типом AssertionError - желтый тест
                        if (AssertionError.class.isAssignableFrom(t.getCause().getClass())) {
                            System.out.println("Тест :" + method.getName() + " желтый");
                        } else {
                            // Если метод выбросил исключение с любым другим - красный тест
                            System.out.println("Тест :" + method.getName() + " красный");
                        }
                        continue;
                    }
                    // Если метод успешно выполнился - зеленый тест
                    System.out.println("Тест :" + method.getName() + " зеленый");
                }
            }
        }
    }
}
