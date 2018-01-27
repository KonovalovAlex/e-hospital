package kz.astonline.ehospital.spring.caching;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKey;

import java.lang.reflect.Method;

public class AdvancedKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        Object[] resourcesForKeyBuild = ArrayUtils.addAll(params, target.toString(),
                method.getName(), method.getGenericReturnType().getTypeName());

        return generateKey(resourcesForKeyBuild);
    }

    /**
     * Generate a key based on the specified parameters and other method metadata
     */
    public static Object generateKey(Object... params) {
        if (params.length == 0) {
            return SimpleKey.EMPTY;
        }
        if (params.length == 1) {
            Object param = params[0];
            if (param != null && !param.getClass().isArray()) {
                return param;
            }
        }
        return new SimpleKey(params);
    }
}
