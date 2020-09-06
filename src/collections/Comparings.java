// package collections;

import java.util.*;

public class Comparings {

	public static void main(String[] args) {
		List<Track> tracks = new ArrayList<>();
		tracks.add(new Track(8, "Thandi hawa"));
		tracks.add(new Track(10, "Brown rang"));
		tracks.add(new Track(20, "Gabru"));
		System.out.println("tracks : \n" + tracks);
		Collections.sort(tracks);
		System.out.println("Sorted by name : \n" + tracks);
		Collections.sort(tracks, Collections.reverseOrder(new PopularitySorting()));
		System.out.println("Sorted by popularity : \n" + tracks);
	}
}

class PopularitySorting implements Comparator<Track> {
	public int compare(Track t1, Track t2) {
		// return -Integer.compare(t1.count, t2.count);
		return Integer.compare(t1.count, t2.count);
	}

}

class Track implements Comparable<Track> {
	int count;
	String title;

	Track(int count, String title) {
		this.count = count;
		this.title = title;
	}

	public int compareTo(Track t) {
		return title.compareTo(t.title);
	}
	public String toString() {
		return "Track(" + title + ", "+ count + ")";
	}
}