package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.*;
import org.springframework.data.repository.*;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
