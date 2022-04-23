package ch2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Ex16 {
    public static class Queue implements Iterable<String> {
        private Node listHead;
        private Node listTail;


        public void add(String value) {
            var node = new Node(value);

            if (listTail == null) {
                listHead = listTail = node;
            } else {
                listTail.next = node;
                listTail = node;
            }
        }

        public String remove() {
            if (listTail == null) {
                return null;
            } else {
                var value = listHead.value;
                listHead = listHead.next;
                return value;
            }
        }

        @Override
        public String toString() {
            var stringValue = new StringBuilder();

            var currentNode = listHead;
            while (currentNode != null) {
                if (currentNode != listHead) {
                    stringValue.append(" -> ");
                }
                stringValue.append(currentNode.value);

                currentNode = currentNode.next;
            }

            return stringValue.toString();
        }

        public Iterator<String> iterator() {
            return new QueueIterator();
        }

        public class QueueIterator implements Iterator<String> {
            private Node currentNode = listHead;

            @Override
            public String next() {
                if (hasNext()) {
                    var value = currentNode.value;
                    currentNode = currentNode.next;
                    return value;
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }
        }

        public static class Node {
            private final String value;
            public Node next;

            public Node(String value) {
                this.value = value;
            }
        }
    }
}
