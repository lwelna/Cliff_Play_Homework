import views.html.*;

import org.junit.Test;

import model.LoginInfo;
import model.UserPost;
import model.UserPostInput;
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
        Content html = login.render("CLIFF'S BLOGGING SITE", Form.form(LoginInfo.class));
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("CLIFF&#x27;S BLOGGING SITE");
    }

    @Test
    public void renderPost() {
        Content html = displayPost.render("Cliff's Blogging Site", Form.form(UserPostInput.class));
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("CLIFF&#x27;S BLOGGING SITE");
    }

    @Test
    public void callLogin() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("loginName", "thing");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.auth(), fakeRequest);
                assertThat(status(result)).isEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void calladdUser() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("user", "thing");
                formParams.put("firstName", "thing");
                formParams.put("lastName", "thing");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void calladdUser1() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("user", "");
                formParams.put("firstName", "thing");
                formParams.put("lastName", "thing");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isNotEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void calladdUser2() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("user", "thing");
                formParams.put("firstName", "thing");
                formParams.put("lastName", "");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isNotEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void calladdUser3() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("user", "thing");
                formParams.put("firstName", "");
                formParams.put("lastName", "thing");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isNotEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void calladdUser4() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("user", "thing");
                formParams.put("firstName", "");
                formParams.put("lastName", "");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isNotEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void calladdUser5() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("user", "");
                formParams.put("firstName", "");
                formParams.put("lastName", "thing");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isNotEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void calladdUser6() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("user", "");
                formParams.put("firstName", "thing");
                formParams.put("lastName", "");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isNotEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void calladdUser7() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("user", "");
                formParams.put("firstName", "");
                formParams.put("lastName", "");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isNotEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void callCreatePost() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("postInput", "something");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams).withSession("User:", "thing");

                Result result = callAction(controllers.routes.ref.Application.createNewPost(), fakeRequest);
                assertThat(status(result)).isEqualTo(SEE_OTHER);
            }
        });
    }

    @Test
    public void callCreatePost2() {
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("postInput", "");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams).withSession("User:", "thing");

                Result result = callAction(controllers.routes.ref.Application.createNewPost(), fakeRequest);
                assertThat(status(result)).isNotEqualTo(SEE_OTHER);
            }
        });
    }
}
