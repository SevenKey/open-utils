package algorithm.tree;

import base.TransactionTestBase;
import org.junit.Assert;
import org.junit.Test;
import sevenkey.open.utils.algorithm.tree.Tree;

public class TreeTest extends TransactionTestBase {
    private Tree tree = new Tree();

    private Tree.BinaryTreeNode binaryTreeNode() {
        Tree.BinaryTreeNode root = new Tree.BinaryTreeNode();
        root.setData(0);
        Tree.BinaryTreeNode node1 = new Tree.BinaryTreeNode();
        node1.setData(1);
        Tree.BinaryTreeNode node2 = new Tree.BinaryTreeNode();
        node2.setData(2);
        Tree.BinaryTreeNode node3 = new Tree.BinaryTreeNode();
        node3.setData(3);
        Tree.BinaryTreeNode node4 = new Tree.BinaryTreeNode();
        node4.setData(4);
        Tree.BinaryTreeNode node5 = new Tree.BinaryTreeNode();
        node5.setData(5);
        Tree.BinaryTreeNode node6 = new Tree.BinaryTreeNode();
        node6.setData(6);

        root.setLeft(node2);
        root.setRight(node5);

        node2.setLeft(node1);
        node2.setRight(null);

        node5.setLeft(null);
        node5.setRight(node3);

        node1.setLeft(null);
        node1.setRight(node6);

        node3.setLeft(null);
        node3.setRight(node4);

        node4.setLeft(null);
        node4.setRight(null);

        node6.setLeft(null);
        node6.setRight(null);

        return root;
    }

    @Test
    public void testTreeHeight() {
        Assert.assertEquals(4, tree.treeHeight(binaryTreeNode()));
    }
}
