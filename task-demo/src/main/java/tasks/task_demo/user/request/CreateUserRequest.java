package tasks.task_demo.user.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String name;
    private String username;
    private String password;
}
