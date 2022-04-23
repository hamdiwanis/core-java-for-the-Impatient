package ch2;

public class Ex16 {
    public static class Queue {
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

        public static class Node {
            private final String value;
            public Node next;

            public Node(String value) {
                this.value = value;
            }
        }
    }
}
