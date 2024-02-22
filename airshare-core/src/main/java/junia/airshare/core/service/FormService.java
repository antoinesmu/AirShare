package junia.airshare.core.service;


import junia.airshare.core.dao.FormDAO;
import junia.airshare.core.entity.Form;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Named
@Service
@Transactional
public class FormService {

    private FormDAO formDAO;

    public FormService(FormDAO formDAO) { this.formDAO = formDAO; }

    public void saveForm(Form form) { formDAO.save(form); }

    public void deleteAll() { formDAO.deleteAll(); }

    public List<Form> getAllForm() { return formDAO.findAll(); }

    public List<Form> getFormFromUserRequests() { return formDAO.getFormFromUserRequest(); }

}
