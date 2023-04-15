package br.univille.cofrinho.domains.frequency;

public class FrequenciaMapper {

	private FrequenciaMapper() {}

	public static FrequenciaDTO paraDTO(FrequenciaEntity frequenciaEntity) {
		return new FrequenciaDTO(frequenciaEntity.getId(), frequenciaEntity.getNome(), frequenciaEntity.getGrandeza());
	}

}
