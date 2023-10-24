// Kevin Xu
class Rect {

    private double x, y, width, height;


    // constructors
    public Rect() {
        this(0, 0, 0, 0);
    }

    public Rect(double posX, double posY, double w, double h) {

        this.x = posX;
        this.y = posY;
        this.width = w;
        this.height = h;

    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }



    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void resize(double amount) {
        this.width *= amount;
        this.height *= amount;
    }


    public boolean overlaps(Rect rectangle) {

        // return (this.x + this.width >= rectangle.x && this.x <= rectangle.x + rectangle.width) && (this.y + this.height >= rectangle.y && this.y <= rectangle.y + rectangle.height);
        return (this.contains(rectangle.x, rectangle.y) || this.contains(rectangle.x + rectangle.width, rectangle.y) || this.contains(rectangle.x, rectangle.y + rectangle.height) || this.contains(rectangle.x + rectangle.width, rectangle.y + rectangle.height)) || (rectangle.contains(this.x, this.y) || rectangle.contains(this.x + this.width, this.y) || rectangle.contains(this.x, this.y + this.height) || rectangle.contains(this.x + this.width, this.y + this.height));


    }

    public boolean contains(double x2, double y2) {

        return (x2 >= this.x && x2 <= this.x + this.width) && (y2 >= this.y && y2 <= this.y + this.height);

    }

    public double[] centre() {
        double[] ret = new double[2];
        ret[0] = this.x + (this.width / 2);
        ret[1] = this.y + (this.height / 2);

        return ret;
    }   

    public void union(Rect rectangle) {

        // return bounding rectangle of this and rectangle
        double minX = Math.min(this.x, rectangle.x);
        double minY = Math.min(this.y, rectangle.y);
        double maxX = Math.max(this.x + this.width, rectangle.x + rectangle.width);
        double maxY = Math.max(this.y + this.height, rectangle.y + rectangle.height);

        this.x = minX;
        this.y = minY;
        this.width = maxX - minX;
        this.height = maxY - minY;


    }

}
