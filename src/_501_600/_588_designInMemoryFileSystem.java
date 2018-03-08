package _501_600;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _588_designInMemoryFileSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Design an in-memory file system to simulate the following functions:

		ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.

		mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.

		addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.

		readContentFromFile: Given a file path, return its content in string format.
	
		Note:
			You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
			You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
			You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.
	*/
	
	/**
	 * Your FileSystem object will be instantiated and called as such:
	 * FileSystem obj = new FileSystem();
	 * List<String> param_1 = obj.ls(path);
	 * obj.mkdir(path);
	 * obj.addContentToFile(filePath,content);
	 * String param_4 = obj.readContentFromFile(filePath);
	 */
	
	class File {
        boolean isFile = false;
        Map<String, File> children = new HashMap<>();
        String content = "";
    }
    
    File root = null;
    
    public _588_designInMemoryFileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        File node = root;
        List<String> result = new ArrayList<>();
        String name = "";
        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) {
                return result;
            }
            node = node.children.get(dir);
            name = dir;
        }
        
        if (node.isFile) {
            result.add(name);
        }
        else {
            for (String key : node.children.keySet()) {
                result.add(key);
            }
        }
        
        Collections.sort(result);
        
        return result;
    }
    
    public void mkdir(String path) {
        String[] dirs = path.split("/");
        File node = root;
        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) {
                File file = new File();
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] dirs = filePath.split("/");
        File node = root;
        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) {
                File file = new File();
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
        node.isFile = true;
        node.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        File node = root;
        for (String dir : dirs) {
            if (dir.length() == 0) continue;
            if (!node.children.containsKey(dir)) {
                File file = new File();
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }

        return node.content;
    }
}

/*
class FileSystem {

    File root;

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        String[] split = path.split("/");
        File cur = root;
        for (String dir : split) {
            if (dir.isEmpty()) {
                continue;
            }
            cur = cur.children.get(dir);
        }
        if (cur.isDir) {
            return new ArrayList<>(cur.children.keySet());
        } else {
            return Collections.singletonList(split[split.length - 1]);
        }
    }

    public void mkdir(String path) {
        createIfNotExists(path);
    }

    public void addContentToFile(String filePath, String content) {
        File file = createIfNotExists(filePath);
        file.isDir = false;
        file.content += content;
    }

    public String readContentFromFile(String filePath) {
        String[] split = filePath.split("/");
        File cur = root;
        for (String dir : split) {
            if (dir.isEmpty()) {
                continue;
            }
            cur = cur.children.get(dir);
        }
        return cur.content;
    }

    private File createIfNotExists(String path) {
        String[] split = path.split("/");
        File cur = root;
        for (String dir : split) {
            if (dir.isEmpty()) {
                continue;
            }
            if (!cur.children.containsKey(dir)) {
                cur.children.put(dir, new File());
            }
            cur = cur.children.get(dir);
        }
        return cur;
    }
}

class File {
    boolean isDir = true;
    String content = "";
    TreeMap<String, File> children = new TreeMap<>();
}
*/