package tasks.task_demo.user.service;

import tasks.task_demo.user.entitY.User;
import tasks.task_demo.user.request.CreateUserRequest;

public interface IUserService {
    User create (CreateUserRequest request);

}
