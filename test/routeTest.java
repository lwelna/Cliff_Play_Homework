import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.GET;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.route;
import org.junit.Test;
import play.mvc.Result;
import play.test.WithApplication;

public class routeTest  extends WithApplication {

    @Test
    public void testPostRoute() {
        Result result = route(fakeRequest(GET, "/post"));
        assertThat(result).isNotNull();
    }

    @Test
    public void testLoginRoute() {
        Result result = route(fakeRequest(GET, "/"));
        assertThat(result).isNotNull();
    }

    @Test
    public void testIndexRoute() {
        Result result = route(fakeRequest(GET, "/index"));
        assertThat(result).isNotNull();
    }

    @Test
    public void testGetPostRoute() {
        Result result = route(fakeRequest(GET, "/GetPost"));
        assertThat(result).isNotNull();
    }
}
