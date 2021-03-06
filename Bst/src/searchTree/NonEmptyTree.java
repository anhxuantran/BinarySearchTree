package searchTree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 * 
 */
public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

	// Provide whatever constructors and instance variables you need
	private Tree<K, V> right, left;
	private K key;
	private V value;

	public NonEmptyTree(K key, V value, Tree<K, V> emptyTree) {
		this.key = key;
		this.value = value;
		this.left = emptyTree;
		this.right = emptyTree;
	}

	public V search(K key) {
		int comparison = key.compareTo(this.key);
		if (comparison < 0) {
			return left.search(key);
		} else if (comparison > 0) {
			return right.search(key);
		}
		return this.value;

	}

	public NonEmptyTree<K, V> insert(K key, V value) {
		int comparison = key.compareTo(this.key);

		if (comparison == 0) {
			this.value = value;
		} else if (comparison < 0) {
			left = left.insert(key, value);
		} else if (comparison > 0) {
			right = right.insert(key, value);
		}

		return this;
	}

	public Tree<K, V> delete(K key) {
		int comparison = key.compareTo(this.key);
		
		if (comparison > 0) {
			right = right.delete(key);
		} else if (comparison < 0) {
			left = left.delete(key);
		} else if (comparison == 0) {
			try {
				K max = left.max();
				this.key = max;
				this.value = left.search(max);
				left = left.delete(max);
			} catch (TreeIsEmptyException e) {
				return right;
			}
		}
		return this;
	}

	public K max() {
		try {
			return right.max();
		} catch (TreeIsEmptyException e) {
			return this.key;
		}

	}

	public K min() {
		try {
			return left.min();
		} catch (TreeIsEmptyException e) {
			return this.key;
		}
	}

	public int size() {

		return right.size() + left.size() + 1;
	}

	public String toString() {		
		String results = "";
		results = " {key: " + key + "; value: " + value + "}" + "\n";
		return results + left.toString() + right.toString();

	}

	public void addKeysToCollection(Collection<K> c) {
		left.addKeysToCollection(c);
		c.add(key);
		right.addKeysToCollection(c);
	}

	public Tree<K, V> subTree(K fromKey, K toKey) {
		NonEmptyTree<K, V> sub;
		if (fromKey.compareTo(this.key) > 0) {
			return right.subTree(fromKey, toKey);
		} else if (toKey.compareTo(this.key) < 0) {
			return left.subTree(fromKey, toKey);
		} else {
			sub = new NonEmptyTree<K, V>(this.key, this.value, this);
			sub.left = left.subTree(fromKey, toKey);
			sub.right = right.subTree(fromKey, toKey);
		}
		return sub;
	}
}