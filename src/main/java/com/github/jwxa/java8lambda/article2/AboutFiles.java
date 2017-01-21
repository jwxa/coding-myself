package com.github.jwxa.java8lambda.article2;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 文件相关
 * 列举目录下的所有文件和监视文件变化
 * <p>
 * http://blog.csdn.net/dm_vincent/article/details/40423389
 * </p>
 * User: Jwxa Date: 2017/1/21 ProjectName: coding-myself Version: 1.0
 */
public class AboutFiles {

    public static void main(String[] args) throws IOException, InterruptedException {
        //列举目录中的所有文件
        Files.list(Paths.get(".")).forEach(System.out::println);
        //如果只想获取目标路径下的所有目录文件：
        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
        //在以前的Java版本中，如果需要实现一个自定义的过滤器，那么通常会选择使用FilenameFilter结合匿名类的方式：
        new File(".").list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return dir.getName().endsWith(".java");
            }
        });
        //Java 8中新添加的DirectoryStream，可以将上述代码重新实现为：
        //当目标目录下含有大量的文件或者子目录时，使用DirectoryStream往往会具有更好的性能。因为它实际上是一个Iterator用来遍历目标目录，而直接使用listFiles方法时，得到的是一个代表了所有文件和目录的数组，意味着内存的开销会更大。
        Files.newDirectoryStream(Paths.get("."), path->path.toString().endsWith(".java")).forEach(System.out::println);
        //使用flatMap列举所有直接子目录
        listSubdirectory();
        //监视文件变化
        watchFile();

    }

    /**
     * 使用flatMap列举所有直接子目录
     *
     *  从flatMap方法的签名来看，它接受了一个Function接口作为参数，将一种类型转换为另一种类型的Stream类型。而从flatMap方法的命令来看，它的执行过程主要包含两个步骤：
     首先是会对当前Stream的每个元素执行一次map操作，根据传入的mapper对象将一个元素转换为对应的Stream对象
     将第一步中得到的若干个Stream对象汇集成一个Stream对象
     */
    public static void listSubdirectory(){

        List<File> files = Stream.of(new File(".").listFiles())
                .flatMap(file->file.listFiles()==null?
                        Stream.of(file):Stream.of(file.listFiles()))
                        .collect(Collectors.toList());
        System.out.println(files);
    }

    /**
     * WatchService是Java 7中新添加的一个特性，用来监视一某个路径下的文件或者目录是否发生了变化。
     * @throws IOException
     */
    public static void watchFile() throws IOException, InterruptedException {
        final Path path = Paths.get(".");
        final WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Report any file changed within next 1 minutes...");
        //注册了需要监视的目录后，需要使用WatchKey来得到一段时间内的，该目录的变化情况：
        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
        if(watchKey != null) {
            watchKey.pollEvents().stream().forEach(event ->
                    System.out.println(event.context()));
        }
    }


}
