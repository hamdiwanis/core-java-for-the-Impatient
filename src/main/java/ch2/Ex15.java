package ch2;

import java.io.PrintStream;
import java.util.HashMap;

public class Ex15 {
    public static class Invoice {
        private HashMap<String, Item> items = new HashMap<>();

        public void addItem(Item item, int quantity) {
            if (items.containsKey(item.id)) {
                var savedItem = items.get(item.id);
                savedItem.setQuantity(savedItem.getQuantity() + quantity);
            } else {
                items.put(item.id, item);
            }
        }

        public void addItem(Item item) {
            addItem(item, 1);
        }

        public void addItem(String id, int quantity) throws Exception {
            if (items.containsKey(id)) {
                addItem(items.get(id), quantity);
            } else {
                throw new Exception("Item Not Found");
            }
        }

        public void addItem(String id) throws Exception {
            addItem(id, 1);
        }

        public void removeItem(String id, int quantity) throws Exception {
            if (items.containsKey(id)) {
                var savedItem = items.get(id);
                if (savedItem.getQuantity() > quantity) {
                    savedItem.setQuantity(savedItem.getQuantity() - quantity);
                } else if (savedItem.getQuantity() == quantity) {
                    items.remove(id);
                } else {
                    throw new Exception("Item Does Not Have Enough Quantity");
                }
            } else {
                throw new Exception("Item Not Found");
            }
        }

        public void removeItem(String id) throws Exception {
            removeItem(id, 1);
        }

        public void removeAllItems(String id) throws Exception {
            if (items.containsKey(id)) {
                items.remove(id);
            } else {
                throw new Exception("Item Not Found");
            }
        }

        public void print(PrintStream printer) {
            for (var item : items.values()) {
                printer.println(item);
            }
        }

        public static class Item {
            private String id;
            private String description;
            private int quantity;
            private double unitPrice;

            public Item(String id, String description, int quantity, double unitPrice) {
                this.id = id;
                this.description = description;
                this.quantity = quantity;
                this.unitPrice = unitPrice;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            @Override
            public String toString() {
                return "| " + id + " | " + description + " | " + unitPrice + " /unit | " + quantity + " units |";
            }
        }
    }

    public static void main(String[] args) {
        var invoice = new Invoice();

        invoice.addItem(new Invoice.Item("code-1", "Item1", 4, 10));
        invoice.addItem(new Invoice.Item("code-2", "Item2", 3, 7));
        invoice.addItem(new Invoice.Item("code-3", "Item3", 2, 12));

        try {
            invoice.removeItem("code-3");
            invoice.removeItem("code-3");
            invoice.removeItem("code-2");

            invoice.addItem("code-1", 1);

            invoice.print(System.out);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
