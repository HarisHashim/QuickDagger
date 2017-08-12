package my.devs.apps.testing.quickdagger;

import javax.inject.Inject;

/**
 * Created by harishashim on 8/12/2017.
 */

public class TestService {

    private TestUser user;

    @Inject
    public TestService(){
        user = new TestUser();
        user.setName("Test User");
        user.setEmail("test@user.com");
    }

    public TestUser getUser() {
        return user;
    }

    public class TestUser {
        private String name;

        private String email;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}


