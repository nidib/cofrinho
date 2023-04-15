package br.univille.cofrinho.domains.priority;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrioridadeService {

	@Autowired
	private PrioridadeRepository prioridadeRepository;

	public List<PrioridadeEntity> obterTodasAsPrioridades() {
		Sort ordenarCrescentePorGrandeza = Sort.by(Sort.Direction.ASC, "grandeza");

		return prioridadeRepository.findAll(ordenarCrescentePorGrandeza);
	}

}
