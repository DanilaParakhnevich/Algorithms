package org.example.linkedList;

import java.util.Objects;

public class LinkedList <E> {
    Node<E> firstElement;
    Node<E> currentElement;
    int length;

    //FOR SERIALISATION PURPOSES
    public LinkedList() {
    }

    public E push(E e) {
        if (firstElement == null) {
            firstElement = new Node<>();
            firstElement.setValue(e);
            currentElement = firstElement;
        } else {
            Node<E> newCurrentNode = new Node<>();
            newCurrentNode.setValue(e);
            newCurrentNode.setPrevNode(currentElement);
            currentElement.setNextNode(newCurrentNode);
            currentElement = newCurrentNode;
        }
        ++length;
        return e;
    }

    public E get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Bad index");
        }

        Node node;
        if (index > length / 2) {
            int length = this.length;
            node = currentElement;
            while (length - 1 != index) {
                --length;
                node = node.getPrevNode();
            }
        } else {
            int length = 0;
            node = firstElement;
            while (length != index) {
                ++length;
                node = node.getNextNode();
            }
        }
        return (E) node.getValue();
    }

    public E remove(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Bad index");
        }

        Node node;
        if (index > length / 2) {
            int length = this.length;
            node = currentElement;
            while (length - 1 != index) {
                --length;
                node = node.getPrevNode();
            }
        } else {
            int length = 0;
            node = firstElement;
            while (length != index) {
                ++length;
                node = node.getNextNode();
            }
        }

        if (node == firstElement) {
            firstElement.getNextNode().setPrevNode(null);
            firstElement = firstElement.getNextNode();
        } else if (node == currentElement) {
            currentElement.getPrevNode().setNextNode(null);
            currentElement = currentElement.getPrevNode();
        } else {
            node.getPrevNode().setNextNode(node.getNextNode());
            node.getNextNode().setPrevNode(node.getPrevNode());
        }

        return (E) node.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedList<?> that = (LinkedList<?>) o;
        return length == that.length && Objects.equals(firstElement, that.firstElement) && Objects.equals(currentElement, that.currentElement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstElement, currentElement, length);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        Node node = firstElement;

        while (node != null) {
            builder.append(node.getValue().toString()).append(", ");
            node = node.getNextNode();
        }

        if (builder.length() == 0) {
            return "List is empty";
        }

        return builder.delete(builder.length() - 2, builder.length()).toString();
    }
}
