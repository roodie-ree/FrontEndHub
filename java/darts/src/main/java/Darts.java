class Darts {

    private double x;
    private double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        double distance = Math.sqrt(x * x + y * y);
        if (distance > 10.0) {
            return 0;
        }
        if (distance > 5.0) {
            return 1;
        }
        if (distance > 1.0) {
            return 5;
        }
        return 10;
    }

}
