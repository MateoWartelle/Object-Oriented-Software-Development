import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

@SuppressWarnings("unused")
public class Composite extends Rectangle implements Component {
	ArrayList<Component> circlesInside = new ArrayList<>();
	Color color;
	Random colorGenerator = new Random();
	
	public Composite(double x, double y, int w, int h) {
		super(x,y,w,h);
		this.color = RandomColor();
		this.setStrokeWidth(6);
		this.setStroke(this.color);
		this.setFill(Color.TRANSPARENT);
	}

	@Override
	public void move(double deltaX, double deltaY) {
		this.setX(this.getX() + deltaX);
		this.setY(this.getY() + deltaY);
		Iterator<Component> iter = circlesInside.iterator();
		while(iter.hasNext()) {
			Component circle = iter.next();
			if(circle instanceof DragCircle) ((DragCircle) circle).move(deltaX, deltaY);
 		}
	}

	@Override
	public Point2D getLocation() {
		return new Point2D(this.getX(), this.getY());
	}
	
	public void addCircle(Component circle) {
		circlesInside.add(circle);
		Iterator<Component> changeCircle = circlesInside.iterator();
		while(changeCircle.hasNext()) {
			Component c = changeCircle.next();
			if(c instanceof DragCircle) ((DragCircle)  c).ChangeColor(this.color);
		}
		
	}
	
	public boolean CheckCircle(Component circle) {
		if(circle instanceof DragCircle) {
			if(this.contains(((DragCircle) circle).getCenterX(), ((DragCircle) circle).getCenterY())){
				return true;
			}
		}
		return false;
	}
	public Color RandomColor() {
		float r = colorGenerator.nextFloat();
		float g = colorGenerator.nextFloat();
		float b = colorGenerator.nextFloat();
		float a = colorGenerator.nextFloat();
		
		while(r == 1.0 || g == 1.0  || b == 1.0 ) {
			r  = colorGenerator.nextFloat();
			g  = colorGenerator.nextFloat();
			b  = colorGenerator.nextFloat();
		}
		
		return new Color(b, g, r, a);		
	}
	
	
}
