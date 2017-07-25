package childcare.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


@Transactional
public interface ChildRepository extends CrudRepository<Child, Long>{

    Child findById(int id);

}
