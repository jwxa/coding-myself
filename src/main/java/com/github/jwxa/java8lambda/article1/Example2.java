package com.github.jwxa.java8lambda.article1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class Example2 {

    public static List<Album> getAlbums() {
        List<Album> albums = new ArrayList<>();
        Album a = new Album(Arrays.asList(new Track(4,"A artist"), new Track(1,"B artist")), "A album",1);
        Album b = new Album(Arrays.asList(new Track(2,"C artist"), new Track(3,"D artist")), "B album",2);
        Album c = new Album(Arrays.asList(new Track(3,"E artist"), new Track(5,"F artist")), "C album",3);
        albums.add(c);
        albums.add(b);
        albums.add(a);
        return albums;
    }

    public static void main(String[] args) {
        List<Album> albums = getAlbums();
        //����������Ҫ�õ�һ�������������ר���б�ר���б������ÿ��ר�������ٰ���һ�����Ǽ��������ϵ����죬Ϊ�˹������ר���б����ǿ�����ôд��
        List<Album> favs = new ArrayList<>();
        for (Album album : albums) {
            boolean hasFavorite = false;
            for (Track track : album.tracks) {
                if (track.rating >= 4) {
                    hasFavorite = true;
                    break;
                }
            }
            if (hasFavorite)
                favs.add(album);
        }
        Collections.sort(favs, new Comparator<Album>() {
            public int compare(Album a1, Album a2) {
                return a1.name.compareTo(a2.name);
            }
        });
        System.out.println(favs);

        //���ǿ������������������������е�������Ҫ���衪��ʶ��һ��ר���Ƿ����һ�����ִ��ڵ������ǵ����죨ʹ�� anyMatch���������������Լ�������������ר������һ�� List �У�
        List<Album> sortedFavs = albums.stream()
                .filter(a -> a.tracks.stream()
                        .anyMatch(t -> t.rating >= 4))
                .sorted(Comparator.comparing(a -> a.name))
                .collect(Collectors.toList());
        System.out.println(sortedFavs);
    }


}

/**
 * ר��
 */
class Album {
    /**
     * ����
     */
    public List<Track> tracks;
    /**
     * ר������
     */
    public String name;

    /**
     * Ŀ¼����
     */
    public Integer catalogNumber;

    public Integer getCatalogNumber() {
        return catalogNumber;
    }

    public Album(List<Track> tracks, String name, Integer catalogNumber) {
        this.tracks = tracks;
        this.name = name;
        this.catalogNumber = catalogNumber;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Album{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class Track {
    /**
     * �Ǽ�
     */
    public int rating;

    /**
     * ����
     */
    public String artist;

    public Track(int rating, String artist) {
        this.rating = rating;
        this.artist = artist;
    }

    public int getRating() {
        return rating;
    }

    public String getArtist() {
        return artist;
    }
}
