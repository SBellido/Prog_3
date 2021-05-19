package entregable_3;

public class UndirecterGraph<T> extends DirecterGraph<T> {

	@Override
	public void addArc(int vertexId1, int vertexId2, T etiqueta) {
		super.addArc(vertexId1, vertexId2, etiqueta);
		super.addArc(vertexId2, vertexId1, etiqueta);
	}
	
	@Override
	public void deleteArc(int vertexId1, int vertexId2) {
		super.deleteArc(vertexId1, vertexId2);
		super.deleteArc(vertexId2, vertexId1);
	}

}
