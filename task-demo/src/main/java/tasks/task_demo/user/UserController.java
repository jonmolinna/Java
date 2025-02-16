package tasks.task_demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tasks.task_demo.response.ApiResponse;
import tasks.task_demo.user.entitY.User;
import tasks.task_demo.user.request.CreateUserRequest;
import tasks.task_demo.user.service.IUserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;
    
    @PostMapping("add")
    public ResponseEntity<ApiResponse> create(@RequestBody CreateUserRequest request) {
        try {
            User user = userService.create(request);
            return ResponseEntity.ok(new ApiResponse("Register", user));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
