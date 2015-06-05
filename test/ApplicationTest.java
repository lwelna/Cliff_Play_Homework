import views.html.*;
import model.Input;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.*;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.Form;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    @Test
    public void renderTemplate() {
        Content html = add.render("CLIFF'S BLOGGING SITE", Form.form(User.class));
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("CLIFF&#x27;S BLOGGING SITE");
    }

    @Test
    public void renderLogin() {
        Content html = login.render("CLIFF'S BLOGGING SITE", Form.form(Input.class));
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("CLIFF&#x27;S BLOGGING SITE");
    }

    @Test
    public void renderPost() {
        Content html = post.render("CLIFF'S BLOGGING SITE", Form.form(Input.class));
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("CLIFF&#x27;S BLOGGING SITE");
    }
}
