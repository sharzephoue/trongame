package model;
/**
 * <h1>The Biker Cless</h1>
 * 
 * @author Guillaume-Muller
 * @version 2.0
 */
import java.awt.Color;
import java.util.ArrayList;

public class Rider extends Elements implements IRider , IElements{
	private Direction direction;
	public ArrayList<IElements> particles = new ArrayList<IElements>();
	boolean alive = true;
	public Grid grid;

	
/**
 * Constructor
 * @param x,y,color,direction,grid
 * 
 * 	
 */
public Rider(int x, int y, Color color , Direction direction,Grid grid) {
		super(x, y, color);
		this.setDirection(direction);
		this.grid=grid;
		// TODO Auto-generated constructor stub
	}



/**
 * (non-Javadoc)
 * @see model.IRider#move()
 */
public void move() {
	this.particles.add(0, new Particles(this.x, this.y, this.color));
	switch(this.getDirection()) {
	case EST: this.x=x+1;
		break;
	case NORD: this.y=y-1;
		break;
	case OUEST: this.x=x-1;
		break;
	case SUD: this.y=y+1;
		break;
	default:
		break;
	}
	
	grid.checkColision(this);
	this.setChanged();
	this.notifyObservers();
	
	
}



/**
 * (non-Javadoc)
 * @see model.IRider#isAlive()
 */
public boolean isAlive() {
	return alive;
}


/**
 * set rider alive status
 */
public void setAlive(boolean alive) {
	this.alive = alive;
}


/**
 * (non-Javadoc)
 * @see model.IRider#getParticles()
 */

@Override
public ArrayList<IElements> getParticles() {
	// TODO Auto-generated method stub
	return particles;
}
/**
 * (non-Javadoc)
 * @see model.IRider#turnRight()
 */
@Override
public void turnRight() {
	switch(this.getDirection()) {
	case NORD: setDirection(Direction.EST);break;
	case EST: setDirection(Direction.SUD);break;
	case SUD: setDirection(Direction.OUEST);break;
	case OUEST: setDirection(Direction.NORD);break;
	}
	
}
/**
 * (non-Javadoc)
 * @see model.IRider#turnLeft()
 */
@Override
public void turnLeft() {
		switch(this.getDirection()) {
		case NORD: setDirection(Direction.OUEST);break;
		case EST: setDirection(Direction.NORD);break;
		case SUD: setDirection(Direction.EST);break;
		case OUEST: setDirection(Direction.SUD);break;
		}
	
}



public Direction getDirection() {
	return direction;
}



public void setDirection(Direction direction) {
	this.direction = direction;
}


	


	
	

	
}
