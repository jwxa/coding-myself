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
 * �ļ����
 * �о�Ŀ¼�µ������ļ��ͼ����ļ��仯
 * <p>
 * http://blog.csdn.net/dm_vincent/article/details/40423389
 * </p>
 * User: Jwxa Date: 2017/1/21 ProjectName: coding-myself Version: 1.0
 */
public class AboutFiles {

    public static void main(String[] args) throws IOException, InterruptedException {
        //�о�Ŀ¼�е������ļ�
        Files.list(Paths.get(".")).forEach(System.out::println);
        //���ֻ���ȡĿ��·���µ�����Ŀ¼�ļ���
        Files.list(Paths.get(".")).filter(Files::isDirectory).forEach(System.out::println);
        //����ǰ��Java�汾�У������Ҫʵ��һ���Զ���Ĺ���������ôͨ����ѡ��ʹ��FilenameFilter���������ķ�ʽ��
        new File(".").list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return dir.getName().endsWith(".java");
            }
        });
        //Java 8������ӵ�DirectoryStream�����Խ�������������ʵ��Ϊ��
        //��Ŀ��Ŀ¼�º��д������ļ�������Ŀ¼ʱ��ʹ��DirectoryStream��������и��õ����ܡ���Ϊ��ʵ������һ��Iterator��������Ŀ��Ŀ¼����ֱ��ʹ��listFiles����ʱ���õ�����һ�������������ļ���Ŀ¼�����飬��ζ���ڴ�Ŀ��������
        Files.newDirectoryStream(Paths.get("."), path->path.toString().endsWith(".java")).forEach(System.out::println);
        //ʹ��flatMap�о�����ֱ����Ŀ¼
        listSubdirectory();
        //�����ļ��仯
        watchFile();

    }

    /**
     * ʹ��flatMap�о�����ֱ����Ŀ¼
     *
     *  ��flatMap������ǩ����������������һ��Function�ӿ���Ϊ��������һ������ת��Ϊ��һ�����͵�Stream���͡�����flatMap��������������������ִ�й�����Ҫ�����������裺
     �����ǻ�Ե�ǰStream��ÿ��Ԫ��ִ��һ��map���������ݴ����mapper����һ��Ԫ��ת��Ϊ��Ӧ��Stream����
     ����һ���еõ������ɸ�Stream����㼯��һ��Stream����
     */
    public static void listSubdirectory(){

        List<File> files = Stream.of(new File(".").listFiles())
                .flatMap(file->file.listFiles()==null?
                        Stream.of(file):Stream.of(file.listFiles()))
                        .collect(Collectors.toList());
        System.out.println(files);
    }

    /**
     * WatchService��Java 7������ӵ�һ�����ԣ���������һĳ��·���µ��ļ�����Ŀ¼�Ƿ����˱仯��
     * @throws IOException
     */
    public static void watchFile() throws IOException, InterruptedException {
        final Path path = Paths.get(".");
        final WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Report any file changed within next 1 minutes...");
        //ע������Ҫ���ӵ�Ŀ¼����Ҫʹ��WatchKey���õ�һ��ʱ���ڵģ���Ŀ¼�ı仯�����
        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
        if(watchKey != null) {
            watchKey.pollEvents().stream().forEach(event ->
                    System.out.println(event.context()));
        }
    }


}
