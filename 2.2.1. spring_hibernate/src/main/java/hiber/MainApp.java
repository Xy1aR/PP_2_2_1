package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("BMW", 5)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("AUDI", 6)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("VAZ", 2101)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("VW", 3)));

      List<User> users = userService.listUsers();
      users.forEach(System.out::println);

      User user = userService.getUserByCar("VAZ", 2101);

      System.out.println(user.toString());

      context.close();
   }
}
