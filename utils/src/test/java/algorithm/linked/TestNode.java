package algorithm.linked;

import lombok.Data;
import org.junit.Test;

import java.util.Objects;

public class TestNode {

    @Data
    public static class Node {
        String value;
        Node parent;
        Node first;
        Node second;
        Node brother;
    }

    @Test
    public void testMain() {
        Node root = new Node();
        Node div = new Node();
        Node h1 = new Node();
        Node h2 = new Node();
        Node p = new Node();
        Node a = new Node();


        root.setParent(null);
        root.setFirst(div);
        root.setSecond(null);
        root.setBrother(null);
        root.setValue("root");

        div.setParent(root);
        div.setFirst(h1);
        div.setSecond(h2);
        div.setBrother(null);
        div.setValue("div");

        h1.setParent(div);
        h1.setFirst(p);
        h1.setSecond(a);
        h1.setBrother(h2);
        h1.setValue("h1");

        h2.setParent(div);
        h2.setFirst(null);
        h2.setSecond(null);
        h2.setBrother(null);
        h2.setValue("h2");

        p.setParent(h1);
        p.setFirst(null);
        p.setSecond(null);
        p.setBrother(a);
        p.setValue("p");

        a.setParent(h1);
        a.setFirst(null);
        a.setSecond(null);
        a.setBrother(null);
        a.setValue("a");


        get(root);
    }

    private void get(Node root) {
        if (Objects.isNull(root)) {
            return;
        }

        System.out.println(root.value);

        get(root.first);
        get(root.getBrother());
    }
}
