package ch4;

import java.util.Objects;

public class Ex6 {
    public static class Item {
        private String description;
        private double price;

        public Item(String description, double price) {
            this.description = description;
            this.price = price;
        }

        @Override
        public boolean equals(Object otherObject) {
            if (this == otherObject) return true;
            if (otherObject == null) return false;
            if (!(otherObject instanceof Item)) return false;
            var other = (Item) otherObject;
            return Objects.equals(description, other.description) && price == other.price;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.description, this.price);
        }
    }

    public static class DiscountedItem extends Item {
        private double discount;

        public DiscountedItem(String description, double price, double discount) {
            super(description, price);
            this.discount = discount;
        }

        @Override
        public boolean equals(Object otherObject) {
            if (!super.equals(otherObject)) return false;
            if (otherObject.getClass() == Item.class) {
                return super.equals(otherObject);
            }
            var other = (DiscountedItem) otherObject;
            return this.discount == other.discount;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.discount, super.hashCode());
        }
    }
}
