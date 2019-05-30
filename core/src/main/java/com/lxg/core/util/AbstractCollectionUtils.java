package com.lxg.core.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**************************
 * @description: Spring-Core AbstractCollectionUtils
 * @author: xuegangliu
 * @date: 2019/2/27 10:35
 ***************************/
public abstract class AbstractCollectionUtils {
    public AbstractCollectionUtils() {
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static List arrayToList(Object source) {
        return Arrays.asList(AbstractObjectUtils.toObjectArray(source));
    }

    public static void mergeArrayIntoCollection(Object array, Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        } else {
            Object[] arr = AbstractObjectUtils.toObjectArray(array);
            Object[] var6 = arr;
            int var5 = arr.length;

            for(int var4 = 0; var4 < var5; ++var4) {
                Object elem = var6[var4];
                collection.add(elem);
            }

        }
    }

    public static void mergePropertiesIntoMap(Properties props, Map map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        } else {
            String key;
            Object value;
            if (props != null) {
                for(Enumeration en = props.propertyNames(); en.hasMoreElements(); map.put(key, value)) {
                    key = (String)en.nextElement();
                    value = props.getProperty(key);
                    if (value == null) {
                        value = props.get(key);
                    }
                }
            }

        }
    }

    public static boolean contains(Iterator iterator, Object element) {
        if (iterator != null) {
            while(iterator.hasNext()) {
                Object candidate = iterator.next();
                if (AbstractObjectUtils.nullSafeEquals(candidate, element)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean contains(Enumeration enumeration, Object element) {
        if (enumeration != null) {
            while(enumeration.hasMoreElements()) {
                Object candidate = enumeration.nextElement();
                if (AbstractObjectUtils.nullSafeEquals(candidate, element)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean containsInstance(Collection collection, Object element) {
        if (collection != null) {
            Iterator var3 = collection.iterator();

            while(var3.hasNext()) {
                Object candidate = var3.next();
                if (candidate == element) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean containsAny(Collection source, Collection candidates) {
        if (!isEmpty(source) && !isEmpty(candidates)) {
            Iterator var3 = candidates.iterator();

            while(var3.hasNext()) {
                Object candidate = var3.next();
                if (source.contains(candidate)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public static Object findFirstMatch(Collection source, Collection candidates) {
        if (!isEmpty(source) && !isEmpty(candidates)) {
            Iterator var3 = candidates.iterator();

            while(var3.hasNext()) {
                Object candidate = var3.next();
                if (source.contains(candidate)) {
                    return candidate;
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public static <T> T findValueOfType(Collection<?> collection, Class<T> type) {
        if (isEmpty(collection)) {
            return null;
        } else {
            T value = null;
            Iterator var4 = collection.iterator();

            while(true) {
                Object element;
                do {
                    if (!var4.hasNext()) {
                        return value;
                    }

                    element = var4.next();
                } while(type != null && !type.isInstance(element));

                if (value != null) {
                    return null;
                }

                value = (T) element;
            }
        }
    }

    public static Object findValueOfType(Collection<?> collection, Class<?>[] types) {
        if (!isEmpty(collection) && !AbstractObjectUtils.isEmpty(types)) {
            Class[] var5 = types;
            int var4 = types.length;

            for(int var3 = 0; var3 < var4; ++var3) {
                Class<?> type = var5[var3];
                Object value = findValueOfType(collection, type);
                if (value != null) {
                    return value;
                }
            }

            return null;
        } else {
            return null;
        }
    }

    public static boolean hasUniqueObject(Collection collection) {
        if (isEmpty(collection)) {
            return false;
        } else {
            boolean hasCandidate = false;
            Object candidate = null;
            Iterator var4 = collection.iterator();

            while(var4.hasNext()) {
                Object elem = var4.next();
                if (!hasCandidate) {
                    hasCandidate = true;
                    candidate = elem;
                } else if (candidate != elem) {
                    return false;
                }
            }

            return true;
        }
    }

    public static Class<?> findCommonElementType(Collection collection) {
        if (isEmpty(collection)) {
            return null;
        } else {
            Class<?> candidate = null;
            Iterator var3 = collection.iterator();

            while(var3.hasNext()) {
                Object val = var3.next();
                if (val != null) {
                    if (candidate == null) {
                        candidate = val.getClass();
                    } else if (candidate != val.getClass()) {
                        return null;
                    }
                }
            }

            return candidate;
        }
    }

    public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] array) {
        ArrayList elements = new ArrayList();

        while(enumeration.hasMoreElements()) {
            elements.add(enumeration.nextElement());
        }

        return (A[]) elements.toArray(array);
    }

    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        return new AbstractCollectionUtils.EnumerationIterator(enumeration);
    }

    public static <K, V> MultiValueMap<K, V> toMultiValueMap(Map<K, List<V>> map) {
        return new AbstractCollectionUtils.MultiValueMapAdapter(map);
    }

    public static <K, V> MultiValueMap<K, V> unmodifiableMultiValueMap(MultiValueMap<? extends K, ? extends V> map) {
        AbstractAssert.notNull(map, "'map' must not be null");
        Map<K, List<V>> result = new LinkedHashMap(map.size());
        Iterator var3 = map.entrySet().iterator();

        while(var3.hasNext()) {
            Map.Entry<? extends K, ? extends List<? extends V>> entry = (Map.Entry)var3.next();
            List<V> values = Collections.unmodifiableList((List)entry.getValue());
            result.put(entry.getKey(), values);
        }

        Map<K, List<V>> unmodifiableMap = Collections.unmodifiableMap(result);
        return toMultiValueMap(unmodifiableMap);
    }

    private static class EnumerationIterator<E> implements Iterator<E> {
        private Enumeration<E> enumeration;

        public EnumerationIterator(Enumeration<E> enumeration) {
            this.enumeration = enumeration;
        }

        @Override
        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }
        @Override
        public E next() {
            return this.enumeration.nextElement();
        }
        @Override
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    private static class MultiValueMapAdapter<K, V> implements MultiValueMap<K, V>, Serializable {
        private final Map<K, List<V>> map;

        public MultiValueMapAdapter(Map<K, List<V>> map) {
            AbstractAssert.notNull(map, "'map' must not be null");
            this.map = map;
        }
        @Override
        public void add(K key, V value) {
            List<V> values = (List)this.map.get(key);
            if (values == null) {
                values = new LinkedList();
                this.map.put(key, values);
            }

            ((List)values).add(value);
        }
        @Override
        public V getFirst(K key) {
            List<V> values = (List)this.map.get(key);
            return values != null ? values.get(0) : null;
        }
        @Override
        public void set(K key, V value) {
            List<V> values = new LinkedList();
            values.add(value);
            this.map.put(key, values);
        }
        @Override
        public void setAll(Map<K, V> values) {
            Iterator var3 = values.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<K, V> entry = (Map.Entry)var3.next();
                this.set(entry.getKey(), entry.getValue());
            }

        }
        @Override
        public Map<K, V> toSingleValueMap() {
            LinkedHashMap<K, V> singleValueMap = new LinkedHashMap(this.map.size());
            Iterator var3 = this.map.entrySet().iterator();

            while(var3.hasNext()) {
                Map.Entry<K, List<V>> entry = (Map.Entry)var3.next();
                singleValueMap.put(entry.getKey(), (V)((List)entry.getValue()).get(0));
            }

            return singleValueMap;
        }
        @Override
        public int size() {
            return this.map.size();
        }
        @Override
        public boolean isEmpty() {
            return this.map.isEmpty();
        }
        @Override
        public boolean containsKey(Object key) {
            return this.map.containsKey(key);
        }
        @Override
        public boolean containsValue(Object value) {
            return this.map.containsValue(value);
        }
        @Override
        public List<V> get(Object key) {
            return (List)this.map.get(key);
        }
        @Override
        public List<V> put(K key, List<V> value) {
            return (List)this.map.put(key, value);
        }
        @Override
        public List<V> remove(Object key) {
            return (List)this.map.remove(key);
        }
        @Override
        public void putAll(Map<? extends K, ? extends List<V>> m) {
            this.map.putAll(m);
        }
        @Override
        public void clear() {
            this.map.clear();
        }
        @Override
        public Set<K> keySet() {
            return this.map.keySet();
        }
        @Override
        public Collection<List<V>> values() {
            return this.map.values();
        }
        @Override
        public Set<Map.Entry<K, List<V>>> entrySet() {
            return this.map.entrySet();
        }
        @Override
        public boolean equals(Object other) {
            return this == other ? true : this.map.equals(other);
        }
        @Override
        public int hashCode() {
            return this.map.hashCode();
        }
        @Override
        public String toString() {
            return this.map.toString();
        }
    }
}
