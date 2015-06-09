import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.fakeApplication;

import configs.AppConfig;
import configs.TestDataConfig;

import services.PostService;
import services.UserService;
import views.html.add;
import views.html.displayPost;
import views.html.login;

import model.User;
import model.UserPost;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import play.mvc.Result;
import play.test.FakeRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration(classes = {
    AppConfig.class, TestDataConfig.class
})
public class ServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    //Tests adding users and posts to the in memory database

    @Test
    public void createUser() {
        User user = new User();
        user.setFirstName("clifford");
        user.setLastName("clifford");
        user.setUser("clifford");
        userService.addUser(user);
        assertThat(userService.checkUser("clifford")).isEqualTo(true);
        assertThat(userService.checkUsername("clifford")).isEqualTo(false);
        assertThat(user.getUser()).isNotNull();
    }


    @Test
    public void getPost() {
        User user = new User();
        user.setFirstName("clifford");
        user.setLastName("clifford");
        user.setUser("clifford");
        userService.addUser(user);
        postService.addUserPost("something", "clifford");
        List<UserPost> post = postService.getAllPost();
        assertThat(post.size()).isEqualTo(1);
    }
}
