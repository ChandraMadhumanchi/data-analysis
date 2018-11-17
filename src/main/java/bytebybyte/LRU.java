package bytebybyte;

import java.util.HashMap;
//https://medium.com/@krishankantsinghal/my-first-blog-on-medium-583159139237
public class LRU {

	class Entry {
		int key;
		int value;
		Entry left;
		Entry right;
	}
	
	int capacity;
	HashMap<Integer,Entry> hm = new HashMap<Integer,Entry>();
	Entry start, end;
	public LRU(int capacity){
		this.capacity = capacity;
	}
	
	public void put(int key, int value){
		
		
		if(hm.containsKey(key)){
			Entry node = hm.get(key);
			node.value = value;
			removeNode(node);
			addAtTop(node);
		} else {
			Entry e = new Entry();
			e.key = key;
			e.value = value;
			e.left = null; e.right = null;
			if(hm.size() == capacity ){
				removeNode(e);
				addAtTop(e);
			} else {
				addAtTop(e);
			}
			hm.put(key, e);
		}
	}
	
	public int get(int key){
		
		if(hm.containsKey(key)){
			Entry node = hm.get(key);
			removeNode(node);
			addAtTop(node);
			return node.value;
		}
		return -1;
	}
	
	public void removeNode(Entry node){
		
		if(node.left != null)
			node.left.right = node.right;
		else
			start = node.right;
		
		if(node.right != null)
			node.right.left = node.left;
		else
			end = node.left;
	}
	
	public void addAtTop(Entry node){
	
		node.left = null;
		node.right = start;
		
		if(start != null)
			start.left = node;
		
		start = node;
		
		if (end == null)
			end = start;
		
	}
	
	public static void main(String[] args) {

		// your code goes here
		LRU lrucache = new LRU(6);
				lrucache.put(1, 1);
				lrucache.put(10, 15);
				lrucache.put(15, 10);
				lrucache.put(10, 16);
				lrucache.put(12, 15);
				lrucache.put(18, 10);
				lrucache.put(13, 16);

				System.out.println(lrucache.get(1));
				System.out.println(lrucache.get(10));
				System.out.println(lrucache.get(15));
		
	}

}
