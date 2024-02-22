package junia.airshare.core.dao;

import junia.airshare.core.entity.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FormDAO extends JpaRepository<Form, Long> {

    @Query("Select f from Form f where f.user.status = 10")
    List<Form> getFormFromUserRequest();




}
