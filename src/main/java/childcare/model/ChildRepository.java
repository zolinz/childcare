package childcare.model;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


@Transactional
public interface ChildRepository extends CrudRepository<Child, Long>{

    // Hibernate creates a childreposotory object
    Child findById(int id);

}
