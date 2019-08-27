package systemmanagment;
 
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class SystemController {
 
    @Autowired
    private SystemDao systemDao;
 
    @RequestMapping(value= "/systemmanagment")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            systemDao.persist(new SystemEntity(name));
 
        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest.jsp", "systemDao", systemDao);
    }
}