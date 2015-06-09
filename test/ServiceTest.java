import static org.fest.assertions.Assertions.assertThat;

import model.User;
import model.UserPost;

import services.PostService;
import services.UserService;

import configs.AppConfig;
import configs.TestDataConfig;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.List;

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
