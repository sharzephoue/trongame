package model;
/**
 * <h1>The  Model class</h1>
 * 
 * @author Guillaume-Muller
 * @version 2.0
 */
public class TronModel implements ITronModel{
	private IGrid grid;
	/**
	 * 
	 * (non-Javadoc)
	 * @see model.ITronModel#getGrid()
	 */
	public IGrid getGrid() {
		return grid;
	}
	/**
	 * (non-Javadoc)
	 * @see model.ITronModel#setGrid(model.IGrid)
	 */
	public void setGrid(IGrid grid) {
		this.grid = grid;
	}

	
	
	
}
