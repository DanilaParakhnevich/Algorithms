package by.parakhnevich.algorithms.linkedList;

import java.util.Objects;

public class Node <E> {
    private Node prevNode;
    private Node nextNode;
    private E value;

    //FOR SERIALISATION PURPOSES
    public Node() {
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(prevNode, node.prevNode) && Objects.equals(nextNode, node.nextNode) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prevNode, nextNode, value);
    }

    @Override
    public String toString() {
        return "Node{" +
                "prevNode=" + prevNode +
                ", nextNode=" + nextNode +
                ", value=" + value +
                '}';
    }

}
