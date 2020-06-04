package sevenkey.open.utils.algorithm.tree;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringExclude;

import java.util.ArrayList;

/**
 * 树相关
 *
 * @author weijianyu
 */
public class Tree {

    @Data
    public static class BinaryTreeNode {
        private int data;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
    }

    /**
     * 二叉树高
     */
    public int treeHeight(BinaryTreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(treeHeight(root.getLeft()), treeHeight(root.getRight())) + 1;
    }

    public void printBinaryTree1(){

    }

    public void printBinaryTree2(){

    }

    public void printBinaryTree3(){

    }


}
