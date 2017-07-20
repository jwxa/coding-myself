package com.github.jwxa.classloader.exercise2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Date;

/**
 * 自定义classloader
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/6/26 ProjectName: coding-myself Version: 1.0
 */
public class MyClassLoader extends URLClassLoader {

    private  MyClassLoader loader = null;
    Date startDate = new Date();

    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    public MyClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
    }

    @Override
    public void close() throws IOException {
        // TODO Auto-generated method stub
        super.close();
    }
    /**
     * Adds a jar file from the filesystems into the jar loader list.
     *
     * @param jarfile
     *            The full path to the jar file.
     * @throws MalformedURLException
     */
    public void addJarFile(String jarfile) throws MalformedURLException {
        URL url = new URL("file:" + jarfile);
        addURL(url);
    }

    public void addDir(File path) throws MalformedURLException{
        addURL(path.toURI().toURL());
    }

    public void addFile(File f) throws MalformedURLException{
        this.addURL(f.toURI().toURL());
        System.out.println("URL:" + f.toURI().toURL());
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ",time:"+startDate.toLocaleString();
    }


}
