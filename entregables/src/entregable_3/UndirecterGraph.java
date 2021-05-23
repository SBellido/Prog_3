package entregable_3;

public class UndirecterGraph<T> extends DirecterGraph<T> {


	@Override
	public void addArc(Integer vertexId1, Integer vertexId2, T etiqueta) {
		super.addArc(vertexId1, vertexId2, etiqueta);
		super.addArc(vertexId2, vertexId1, etiqueta);
	}


	@Override
	public void deleteArc(Integer vertexId1, Integer vertexId2) {
		super.deleteArc(vertexId1, vertexId2);
		super.deleteArc(vertexId2, vertexId1);
	}



}
