import java.util.*;
import java.util.stream.Collectors;

class StreamsBasics {

	List<Integer> findLargeNumbersOldWay(List<Integer> nums) {
		List<Integer> largeNums = new ArrayList<>();
		for(int num : nums) {
			if(num > 100)
				largeNums.add(num);
		}
		return largeNums;
		/* Problems with this approach:
			- it uses a new list which comsumes memory
			- SE is explecitely expected to write iteration code
			  - "how to do it" vs "what to do it".
			  - lang or lib should deal with "how and when" to do a task while SE
			  	should only focus on "what to do"
			  - no separation of concerns
		  	- Code is written for a single threaded execition model
		  	  - when we move the list from 1k to 1 bll, we need to change the code
		  	- it is pain to fet the multi threaded code correct.
		  	- What if we need add few more conditions which comes with && and || code blocks
		  	  - so forced to write lot of control statements.
		  	  - not a great to express the intent as well.
		*/
	}

	List<Integer> findLargeNumbersNewWay(List<Integer> nums) {
		List<Integer> largeNums = nums.stream()
			.filter(num -> num > 100)
			.collect(Collectors.toList());
		return largeNums;
	}

	public static void main(String[] args) {
		StreamsBasics obj = new StreamsBasics();
		List<Integer> list = Arrays.asList(10,200,30,500,100,140);
		System.out.println(obj.findLargeNumbersOldWay(list));
		System.out.println(obj.findLargeNumbersNewWay(list));
	}
}
