package question4112;

import groovy.lang.GroovyShell;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

public class CalculateAnnotationBeenPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            Calculate annotation = field.getAnnotation(Calculate.class);
            if(annotation != null) {
                String a = annotation.a();
                String b = annotation.b();
                String action = annotation.action();
                GroovyShell groovyShell = new GroovyShell();
                String result = groovyShell.evaluate(a + action + b).toString();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, result);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        return bean;
    }
}
