package models;

public class RawModel {
//This model represents a 3d model stored in memory
	
	//The id of the specific vertex array object
	private int vaoID;
    //The actual vertex data
	private int vertexCount;
	
	public RawModel(int vaoID, int vertexCount) {
		this.vaoID = vaoID;
		this.vertexCount = vertexCount;
		
	}

	public int getVaoID() {
		return vaoID;
	}

	public int getVertexCount() {
		return vertexCount;
	}
	
}
