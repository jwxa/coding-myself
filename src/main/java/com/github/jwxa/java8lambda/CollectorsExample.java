package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.github.jwxa.java8lambda.Example2.getAlbums;

/**
 * �ռ���<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class CollectorsExample {

    public static void main(String[] args) {

        List<Album> albums = getAlbums();
        //������˵������Ĵ�����Ŀ¼����Ϊ��ֵ����һ������������
        Map<Integer,Album> albumsByCatalogNumber = albums.stream()
                .collect(Collectors.toMap(e->e.getCatalogNumber(),e->e));
        System.out.println(albumsByCatalogNumber);

        //groupingBy ��һ���� toMap �����Ƶ��ռ���������˵������Ҫ��������ϲ�������ְ������г�������ʱ���Ǿ���Ҫ������ Collector��
        // ���� Track ��Ϊ���룬�� Map<Artist, List<Track>> ��Ϊ�����
        //groupingBy �ռ����Ϳ���ʤ����������������շ��ຯ����classification function����
        // Ȼ���������������� Map���� Map �ļ��Ƿ��ຯ���ķ��ؽ����ֵ�Ǹ÷����µ�Ԫ���б�

        List<Track> tracks = new ArrayList<>();//ר���е����и���
        albums.stream().map(a->a.tracks).forEach(a->tracks.addAll(a));
        System.out.println(tracks);

        Map<String, List<Track>> favsByArtist = tracks.stream()
                .filter(t -> t.rating >= 4)
                .collect(Collectors.groupingBy(a -> a.artist));
        System.out.println(favsByArtist);


        //��������汾������һ������ͨ�ã�general���İ汾������ʹ�� ���� �ռ�������������Ԫ�أ�������һ�����ຯ���Լ�һ��������downstream���ռ������������汾�� groupingBy ʹ�� toList() ��Ϊ��Ĭ�������ռ�������
        //������˵������������ÿ�׸������ݳ����ռ��� Set ���� List �У����ǿ���ʹ�� toSet �ռ�����
        Map<String, Set<Track>> favsByArtistSet = tracks.stream().filter(t->t.rating>4).collect(Collectors.groupingBy(a->a.artist,Collectors.toSet()));
        System.out.println(favsByArtistSet);
        //���������Ҫ���ո��ֺ�������������������ǿ������ɶ༶ Map��

        Map<String, Map<Integer, List<Track>>> byArtistAndRating =
                tracks.stream().collect(Collectors.groupingBy(t->t.artist,Collectors.groupingBy(t->t.rating)));
        System.out.println(byArtistAndRating);


    }

}
