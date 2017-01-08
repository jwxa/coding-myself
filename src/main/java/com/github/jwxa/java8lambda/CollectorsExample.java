package com.github.jwxa.java8lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.github.jwxa.java8lambda.Example2.getAlbums;

/**
 * 收集器<br>
 * User: Jwxa<br>
 * Date: 2017/1/7.
 */
public class CollectorsExample {

    public static void main(String[] args) {

        List<Album> albums = getAlbums();
        //举例来说，下面的代码以目录数字为键值创建一个倒排索引：
        Map<Integer,Album> albumsByCatalogNumber = albums.stream()
                .collect(Collectors.toMap(e->e.getCatalogNumber(),e->e));
        System.out.println(albumsByCatalogNumber);

        //groupingBy 是一个与 toMap 相类似的收集器，比如说我们想要把我们最喜欢的音乐按歌手列出来，这时我们就需要这样的 Collector：
        // 它以 Track 作为输入，以 Map<Artist, List<Track>> 作为输出。
        //groupingBy 收集器就可以胜任这个工作，它接收分类函数（classification function），
        // 然后根据这个函数生成 Map，该 Map 的键是分类函数的返回结果，值是该分类下的元素列表。

        List<Track> tracks = new ArrayList<>();//专辑中的所有歌曲
        albums.stream().map(a->a.tracks).forEach(a->tracks.addAll(a));
        System.out.println(tracks);

        Map<String, List<Track>> favsByArtist = tracks.stream()
                .filter(t -> t.rating >= 4)
                .collect(Collectors.groupingBy(a -> a.artist));
        System.out.println(favsByArtist);


        //除了这个版本，还有一个更加通用（general）的版本允许你使用 其它 收集器来整理输入元素：它接收一个分类函数以及一个下流（downstream）收集器（单参数版本的 groupingBy 使用 toList() 作为其默认下流收集器）。
        //举例来说，如果我们想把每首歌曲的演唱者收集到 Set 而非 List 中，我们可以使用 toSet 收集器：
        Map<String, Set<Track>> favsByArtistSet = tracks.stream().filter(t->t.rating>4).collect(Collectors.groupingBy(a->a.artist,Collectors.toSet()));
        System.out.println(favsByArtistSet);
        //如果我们需要按照歌手和评分来管理歌曲，我们可以生成多级 Map：

        Map<String, Map<Integer, List<Track>>> byArtistAndRating =
                tracks.stream().collect(Collectors.groupingBy(t->t.artist,Collectors.groupingBy(t->t.rating)));
        System.out.println(byArtistAndRating);


    }

}
