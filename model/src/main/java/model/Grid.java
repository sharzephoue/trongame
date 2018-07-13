package model;
/**
 * <h1>The Grid Class</h1>
 * 
 * @author Guillaume-Muller
 * @version 2.0
 */


import java.awt.Color;

import DAO.Datamanager;



public class Grid implements IGrid{
	
	
	private IRider rider1;
	private IRider rider2;
	private int width = 600;
	private int height = 400;
	private int nbCelsHeight=40;
	private int nbCelsWidth=60;
	private ITimer timer;
	private Datamanager db = new Datamanager();

	
	

	/**
	 * Costructor
	 * set 2 rider on the grid
	 */
	public Grid () {
		this.rider1= new Rider(20,20,Color.pink,Direction.EST,this);
		this.rider2= new Rider(25,25,Color.blue,Direction.OUEST,this);
		this.timer= new timer();
		timer.start();
	}
	
	/**
	 * Check colision for a rider
	 * checkif rider is in colision
	 * @param rider
	 * @return boolean colision
	 * 
	 */
	public boolean checkColision(Rider rider) {
		if(rider.getX()>this.nbCelsWidth || rider.getX()<=0 || rider.getY()<=0 || rider.getY()>this.nbCelsHeight) {rider.setAlive(false); return true;} 
		
		for (IElements particle : rider1.getParticles()) {
			if(rider.getX() == particle.getX() && rider.getY() == particle.getY()) {rider.setAlive(false);return true;}
		}
		
		for (IElements particle : rider2.getParticles()) {
			if(rider.getX() == particle.getX() && rider.getY() == particle.getY()) {rider.setAlive(false);return true;}
	
	}
		return false;
	
}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getRider1()
	 */
	@Override
	public IRider getRider1() {
		return rider1;
	}

	/**
	 * Set rider 1
	 */
	public void setRider1(Rider rider1) {
		this.rider1 = rider1;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getRider2()
	 */
	@Override
	public IRider getRider2() {
		return rider2;
	}

	/**
	 * Set rider 2
	 */
	public void setRider2(Rider rider2) {
		this.rider2 = rider2;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getWidth()
	 */
	@Override
	public int getWidth() {
		return width;
	}

	/**
	 * Set the width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getHeight()
	 */
	@Override
	public int getHeight() {
		return height;
	}

	/**
	 * set the height in pixels of the grid
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getNbCelsHeight()
	 */
	@Override
	public int getNbCelsHeight() {
		return nbCelsHeight;
	}


	public void setNbCelsHeight(int nbCelsHeight) {
		this.nbCelsHeight = nbCelsHeight;
	}
	/**
	 * (non-Javadoc)
	 * @see model.IGrid#getNbCelsWidth()
	 */
	@Override
	public int getNbCelsWidth() {
		return nbCelsWidth;
	}


	public void setNbCelsWidth(int nbCelsWidth) {
		this.nbCelsWidth = nbCelsWidth;
	}
	@Override
	public ITimer getTimer() {
		return timer;
	}
	@Override
	public void save() {
		
		if(rider1.isAlive()) {
			db.save(2, (int) timer.getTime());}
		else {
			db.save(1, (int) timer.getTime());}
		}
		

}

	
	
	
	
	
	
	
	
	
	
	

