package com.github.jwxa.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * http://blog.csdn.net/vessl/article/details/42439909
 * <p>
 * ��META-INF/servicesĿ¼�´���spi.Search(����+�ӿ���)�ļ�
 * </p>
 * User: Jwxa Date: 2017/7/19 ProjectName: coding-myself Version: 1.0
 */
public class DoSearch {

    public static void main(String[] args) {
        ServiceLoader<Search> sl = ServiceLoader.load(Search.class);
        Iterator<Search> s = sl.iterator();
        if (s.hasNext()) {
            Search ss = s.next();
            ss.search();
        }
    }

}
