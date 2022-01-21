/*
    https://judge.softuni.org/Contests/Practice/Index/1319#3

    04. Songs

Define a class Song, which holds the following information about songs: Type List, Name and Time.
On the first line you will receive the number of songs - N.
On the next N-lines you will be receiving data in the following format: "{typeList}_{name}_{time}".
On the last line you will receive "Type List" / "all".
Print only the Names of the songs which are from that Type List / All songs.
 */

package L07ObjectsAndClasses.Lab.T04Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer numSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 1; i <= numSongs; i++) {
            String[] data = scanner.nextLine().split("_");
            songs.add(new Song(data[0], data[1], data[2]));
        }

        String list = scanner.nextLine();

        if (list.equals("all")) {
            for (Song song : songs)
                System.out.println(song.getName());
        } else for (Song song : songs) {
            if (song.typeList.equals(list))
                System.out.println(song.getName());
        }
    }
}
