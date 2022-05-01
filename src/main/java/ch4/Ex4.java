package ch4;

import static ch4.Ex1.Point;

public class Ex4 {
    public static abstract class Shape {
        protected Point mainPoint;

        public Shape(Point point) {
            this.mainPoint = point;
        }

        public void moveBy(double dx, double dy) {
            mainPoint.setX(mainPoint.getX() + dx);
            mainPoint.setY(mainPoint.getY() + dy);
        }

        public abstract Point getCenter();
    }

    public static class Circle extends Shape {
        protected final double radius;

        public Circle(Point center, double radius) {
            super(center);
            this.radius = radius;
        }

        @Override
        public Point getCenter() {
            return mainPoint;
        }
    }

    public static class Rectangle extends Shape {
        protected final double width, height;

        public Rectangle(Point topLeft, double width, double height) {
            super(topLeft);
            this.width = width;
            this.height = height;
        }

        @Override
        public Point getCenter() {
            return new Point(mainPoint.x + (width / 2), mainPoint.x + (height / 2));
        }
    }

    public static class Line extends Shape {
        protected final Point to;

        public Line(Point from, Point to) {
            super(from);
            this.to = to;
        }

        @Override
        public Point getCenter() {
            return new Point((mainPoint.x - to.x) / 2, (mainPoint.y - to.y) / 2);
        }

        @Override
        public void moveBy(double dx, double dy) {
            super.moveBy(dx, dy);
            
            to.setX(to.getX() + dx);
            to.setY(to.getY() + dy);
        }
    }
}
