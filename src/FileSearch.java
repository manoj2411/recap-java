/*
	Design Unix File Search API to search file with different arguments as "extension", "name", "size" ...
	  The design should be maintainable to add new contraints.

	  Follow up: How would you handle if some contraints should support AND, OR conditionals.
*/

/*
	** Specification Pattern ** is the Answer to this question
	** Interpreter Design Pattern **

	Think in terms of SearchParams class which contains all search related data with defaults etc.

*/

interface FileItem {
	boolean isDirectory;
	String name;
	int getSize();
}

class File implements FileItem {
	boolean isDirectory = false;
	String content;

	// boolean shouldInclude(SearchParams param) {

	// }
}

class Directory implements FileItem {
	boolean isDirectory = true;
	List<FileItem> children;

	// List<String> search(SearchParams param) {
	// 	List<String> result = new LinkedList<>();

	// 	// this is DFS, may replace it with BFS
	// 	for(FileItem child : children) {
	// 		if(child.isDirectory) {
	// 			result.addAll(child.search(param));
	// 		} else if(child.shouldInclude(param)) {
	// 			result.add(child.path);
	// 		}
	// 	}
	// 	return result;
	// }
}

class SearchParams {
	String name;
	String extension;
	int minSize = -1;
	int maxSize = -1;
	String regexp;
}

interface IFilter {
	boolean shouldInclude(SearchParams params, File file);
}

class NameFilter implements IFilter {
	boolean shouldInclude(SearchParams params, File file) {
		if(params.name == null) return true;
		return params.name.equals(file.name);
	}
}

class ExtensionFilter implements IFilter {
	boolean shouldInclude(SearchParams params, File file) {
		if(params.extension == null) return true;
		return params.extension.equals(file.extension);
	}
}

class MinSizeFilter implements IFilter {
	boolean shouldInclude(SearchParams params, File file) {
		if(params.extension == null) return true;
		return params.extension.equals(file.extension);
	}
}