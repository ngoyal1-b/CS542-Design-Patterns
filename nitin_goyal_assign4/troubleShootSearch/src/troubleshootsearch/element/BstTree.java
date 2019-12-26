package troubleshootsearch.element;

import java.util.ArrayList;
import java.util.List;

public class BstTree {
	
	public Node root;
	int count = 0;
	List<Integer>linenumber = new ArrayList<>();
	public void addNode(String word,int count)
	{
		Node newNode = new Node(word,count);
		if(root == null)
			root = newNode;
		else {
			Node data = root,parent;
			while(true)
			{
				parent = data;
				if(word.compareTo(data.word) < 0)
				{
					data = data.leftChild;
					if(data == null)
					{
						parent.leftChild = newNode;
						return;
					}
				}
				else
				{
					data = data.rightChild;
					if(data == null)
					{
						parent.rightChild = newNode;
						return;
					}
				}
				
			}
		}
	}
	
	public void inorderTraversal(Node focusNode,String token,MyTree mytree)
	{
		if(focusNode!=null)
		{
			inorderTraversal(focusNode.leftChild,token,mytree);
			if(focusNode.word.indexOf(token)!=-1 && focusNode.word.compareTo(token)!=0)
			{
				count++;
				linenumber.add(focusNode.linenumber);
				mytree.setLineNumbersFoundIn(linenumber);
				mytree.setCount(count);
			}
			inorderTraversal(focusNode.rightChild,token,mytree);
		}
	}
	
}


class Node{
	String word;
	Integer linenumber;
	Node leftChild;
	Node rightChild;
	Node(String word,Integer linenumber)
	{
		this.word = word;
		this.linenumber = linenumber;
	}	
}
