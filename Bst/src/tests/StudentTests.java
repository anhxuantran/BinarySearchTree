package tests;

import java.util.ArrayList;

import java.util.List;
import searchTree.SearchTreeMap;
import searchTree.NonEmptyTree;
import searchTree.EmptyTree;
import searchTree.Tree;
import junit.framework.TestCase;

public class StudentTests extends TestCase {

	public void testSearchMethod() {
		SearchTreeMap<Integer, String> tree = new SearchTreeMap<Integer, String>();
		tree.put(23, "twenty-three");
		tree.put(10, "ten");
		tree.put(25, "twenty-five");
		tree.put(1, "one");
		tree.put(50, "fifty");
		tree.put(44, "fortyfour");
		assertTrue(tree.get(10) == "ten");
		assertTrue(tree.get(1) == "one");
		assertTrue(tree.get(50) == "fifty");
		assertTrue(tree.get(25) == "twenty-five");
	}

	public void testMax() {
		SearchTreeMap<Integer, String> tree = new SearchTreeMap<Integer, String>();
		tree.put(23, "twenty-three");
		tree.put(10, "ten");
		tree.put(25, "twenty-five");
		tree.put(1, "one");
		tree.put(50, "fifty");
		tree.put(44, "fortyfour");
		assertTrue(tree.getMax() == 50);
		assertTrue(tree.getMax() != 10);
		assertTrue(tree.getMax() != 1);
		assertTrue(tree.getMax() != 3);
	}

	public void testMin() {
		SearchTreeMap<Integer, String> tree = new SearchTreeMap<Integer, String>();
		tree.put(23, "twenty-three");
		tree.put(10, "ten");
		tree.put(25, "twenty-five");
		tree.put(1, "one");
		tree.put(50, "fifty");
		tree.put(44, "fortyfour");
		assertTrue(tree.getMin() == 1);
		assertTrue(tree.getMin() != 50);
	}

	public void testSize() {
		SearchTreeMap<Integer, String> tree = new SearchTreeMap<Integer, String>();
		SearchTreeMap<Integer, String> treeTwo = new SearchTreeMap<Integer, String>();
		tree.put(23, "twenty-three");
		tree.put(10, "ten");
		tree.put(25, "twenty-five");
		tree.put(1, "one");
		tree.put(50, "fifty");
		tree.put(44, "fortyfour");
		treeTwo.put(4, "four");

		assertTrue(tree.size() == 6);
		assertFalse(tree.size() == 7);
		assertFalse(tree.size() == treeTwo.size());
	}

	public void testInsert() {
		SearchTreeMap<Integer, String> tree = new SearchTreeMap<Integer, String>();
		tree.put(23, "twenty-three");
		tree.put(10, "ten");
		tree.put(25, "twenty-five");
		tree.put(1, "one");
		tree.put(50, "fifty");
		tree.put(44, "fortyfour");

	}

	public void testDeleteKey() {
		SearchTreeMap<Integer, String> tree = new SearchTreeMap<Integer, String>();
		tree.put(23, "twenty-three");
		tree.put(10, "ten");
		tree.put(25, "twenty-five");
		tree.put(1, "one");
		tree.put(50, "fifty");
		tree.put(44, "fortyfour");

		System.out.println("Before removing Anything");
		System.out.println(tree.keyList());
		System.out.println();

		tree.remove(23);
		System.out.println("After Removing 23");
		System.out.println(tree.keyList());

		tree.remove(50);
		System.out.println("After Removing 50");
		System.out.println(tree.keyList());
		System.out.println();

	}
	
	public void testKeyList(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		SearchTreeMap<Integer, String> tree = new SearchTreeMap<Integer, String>();
		tree.put(1, "");
		tree.put(2, "");
		tree.put(3, "");
		tree.put(4, "");
		assertTrue(list.equals(tree.keyList()));
	}

	public void testSubMap() {
		SearchTreeMap<Integer, String> tree = new SearchTreeMap<Integer, String>();
		tree.put(23, "twenty-three");
		tree.put(10, "ten");
		tree.put(25, "twenty-five");
		tree.put(1, "one");
		tree.put(50, "fifty");
		tree.put(44, "fortyfour");
		System.out.println("TreeBeforeSubTreeMap");
		System.out.println(tree.keyList());
		System.out.println();
		System.out.println("SubTreeMap");
		SearchTreeMap<Integer, String> sub = tree.subMap(10, 50);
		System.out.println(tree.subMap(10, 50).keyList());
		System.out.println();
		System.out.println(sub.keyList());
		System.out.println();
		assertTrue(sub.get(10) == "ten");
		assertTrue(sub.get(50) == "fifty");

	}
	
	public void testInsertNonEmptyTree(){
		Tree<Integer, String> emptyTree = EmptyTree.getInstance();
		NonEmptyTree<Integer, String> tree = new NonEmptyTree<Integer, String>(1, "one",emptyTree);
		tree.insert(23, "twenty-three");
		tree.insert(10, "ten");
		tree.insert(25, "twenty-five");
		tree.insert(1, "one");
		tree.insert(50, "fifty");
		tree.insert(44, "fortyfour");
		System.out.println("NonEmptyTree Insert KeyList");
		assertTrue(tree.search(1)=="one");
		assertTrue(tree.search(10)!=null);
	}
	
	public void testAddKeysToCollection(){
		Tree<Integer, String> emptyTree = EmptyTree.getInstance();
		NonEmptyTree<Integer, String> tree = new NonEmptyTree<Integer, String>(1, "one",emptyTree);
		
		tree.insert(23, "twenty-three");
		tree.insert(10, "ten");
		tree.insert(25, "twenty-five");
		tree.insert(1, "one");
		tree.insert(50, "fifty");
		tree.insert(44, "fortyfour");
		
		List<Integer> list = new ArrayList<Integer>();
	
		tree.addKeysToCollection(list);
		System.out.println("AddKeysToCollection testing");
		System.out.println(tree.search(1));
		System.out.println(tree.search(10));
		System.out.println(tree.search(25));
		System.out.println(tree.search(44));
		assertTrue(tree.search(1)=="one");
		assertTrue(tree.search(10)=="ten");
		assertTrue(tree.search(25)=="twenty-five");
		assertTrue(tree.search(44)=="fortyfour");
		System.out.println(list);
		assertTrue(list.contains(1));
		assertFalse(list.contains(2));
		
	}

	public void testSearchNonEmptyTree() {
		Tree<Integer, String> emptyTree = EmptyTree.getInstance();
		NonEmptyTree<Integer, String> tree = new NonEmptyTree<Integer, String>(
				1, "one", emptyTree);
		tree.insert(23, "twenty-three");
		tree.insert(10, "ten");
		tree.insert(25, "twenty-five");
		tree.insert(1, "one");
		tree.insert(50, "fifty");
		tree.insert(44, "fortyfour");

		assertTrue(tree.search(23) == "twenty-three");
		assertTrue(tree.search(10) == "ten");
		assertTrue(tree.search(25) == "twenty-five");
		assertTrue(tree.search(1) == "one");
		
	}

	public void testDeleteNonEmptyTree() {
		Tree<Integer, String> emptyTree = EmptyTree.getInstance();
		NonEmptyTree<Integer, String> tree = new NonEmptyTree<Integer, String>(
				1, "one", emptyTree);
		tree.insert(23, "twenty-three");
		tree.insert(10, "ten");
		tree.insert(25, "twenty-five");
		tree.insert(1, "one");
		tree.insert(50, "fifty");
		tree.insert(44, "fortyfour");

		tree.delete(23);
		assertTrue(tree.search(23) == null);

	}
	
	public void testSubTree(){
		Tree<Integer, String> emptyTree = EmptyTree.getInstance();
		NonEmptyTree<Integer, String> tree = new NonEmptyTree<Integer, String>(
				1, "one", emptyTree);
		tree.insert(23, "twenty-three");
		tree.insert(10, "ten");
		tree.insert(25, "twenty-five");
		tree.insert(1, "one");
		tree.insert(50, "fifty");
		tree.insert(44, "fortyfour");
		
		assertTrue(tree.subTree(10, 44).search(1)==null);
		assertTrue(tree.subTree(10, 44).search(10)=="ten");
		
	}
	
	public void testMaxNonEmptyTree(){
		Tree<Integer, String> emptyTree = EmptyTree.getInstance();
		NonEmptyTree<Integer, String> tree = new NonEmptyTree<Integer, String>(
				1, "one", emptyTree);
		tree.insert(23, "twenty-three");
		tree.insert(10, "ten");
		tree.insert(25, "twenty-five");
		tree.insert(1, "one");
		tree.insert(50, "fifty");
		tree.insert(44, "fortyfour");
		
		assertTrue(tree.max()==50);
		assertFalse(tree.max()==1);
	}

	public void testMinNonEmptyTree(){
		Tree<Integer, String> emptyTree = EmptyTree.getInstance();
		NonEmptyTree<Integer, String> tree = new NonEmptyTree<Integer, String>(
				1, "one", emptyTree);
		tree.insert(23, "twenty-three");
		tree.insert(10, "ten");
		tree.insert(25, "twenty-five");
		tree.insert(1, "one");
		tree.insert(50, "fifty");
		tree.insert(44, "fortyfour");
		
		assertTrue(tree.min()==1);
		assertFalse(tree.min()==50);
		
	}
	
	public void testNonEmptyTreeSize(){
		Tree<Integer, String> emptyTree = EmptyTree.getInstance();
		NonEmptyTree<Integer, String> tree = new NonEmptyTree<Integer, String>(
				1, "one", emptyTree);
		tree.insert(23, "twenty-three");
		tree.insert(10, "ten");
		tree.insert(25, "twenty-five");
		tree.insert(1, "one");
		tree.insert(50, "fifty");
		tree.insert(44, "fortyfour");
		assertTrue(tree.size()==6);
	}
	
	public void testEmptyTreeSize(){
		EmptyTree<Integer, String> emptyTree = EmptyTree.getInstance();
		assertTrue(emptyTree.size()==0);
	}
	
	public void testEmptyTreeSearch(){
		EmptyTree<Integer, String> emptyTree = EmptyTree.getInstance();
		assertTrue(emptyTree.search(0)==null);
		assertTrue(emptyTree.search(10)==null);
		assertTrue(emptyTree.search(20)==null);
		assertTrue(emptyTree.search(30)==null);
	}
	
	public void testDeleteEmpty(){
		EmptyTree<Integer, String> emptyTree = EmptyTree.getInstance();
		
	}
	
	
}